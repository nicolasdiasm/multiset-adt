/**
 * This class uses an underlying Tree to implement our MultiSet ADT.
 */
public class TreeMultiSet extends MultiSet {
    private Tree tree;

    public TreeMultiSet() {
        this.tree = null;
    }
    @Override
    public boolean add(Object item) {
        this.tree.insert(item);
        return true;
    }

    @Override
    public void remove(Object item) {
        this.tree.deleteItem(item);
    }

    @Override
    public boolean contains(Object item) {
        return this.contains(item);
    }

    @Override
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    @Override
    public int count(Object item) {
        return this.tree.count(item);
    }

    @Override
    public int size() {
        return this.tree.len();
    }

}

