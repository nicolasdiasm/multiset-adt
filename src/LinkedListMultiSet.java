import jdk.jshell.spi.ExecutionControl;

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

    }

    @Override
    public boolean contains(Object item) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int count(Object item) {
        return 0;
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
