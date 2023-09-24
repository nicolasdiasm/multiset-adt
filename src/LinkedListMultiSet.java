/**
 * Unlike the TreeMultiList, this implementation does not just "wrap" an
 *         underlying tree, it is instead a custom LinkedListMultiSet implementation, which
 *         only provides the necessary MultiSet methods.
 *         Representation Invariant:
 *         this.front is None represents an empty MultiSet
 */

public class LinkedListMultiSet extends MultiSet {
    /**
     * Internal node structure used by the LinkedListMultiSet above.
     */
    private Node front;
    private int size;
    LinkedListMultiSet() {
        this.front = null;
        this.size = 0;
    }

    @Override
    public boolean add(Object item) {
        Node newNode = new Node(item);
        newNode.next = this.front;
        this.front = newNode;
        this.size += 1;
        return true;
    }

    @Override
    public void remove(Object item) {
        Node curr = this.front;
        Node prev = null;
        while (curr != null) {
            if (curr.item == item) {
                this.size -= 1;
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    this.front = curr.next;
                }
                return;
            }
            prev = curr;
            curr = prev.next;
        }
    }

    @Override
    public boolean contains(Object item) {
        Node curr = this.front;
        while (curr != null) {
            if (curr.item == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
    }

    @Override
    public int count(Object item) {
        int result = 0;
        Node curr = this.front;
        while (curr != null) {
            if (curr.item == item) {
                result += 1;
            }
            curr = curr.next;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        Object item;
        Node next;
        Node(Object obj) {
            this.item = obj;
        }
    }
}
