import java.util.ArrayList;

/**
 * A recursive tree data structure, which provides services required of the
 *        MultiSet ADT. See TreeMultiSet, which is the next class defined.
 *        This is a simplified version of the Tree data structure
 *        adapted from CSC148.
 */

public class Tree {
    private Object root;
    private ArrayList<Tree> subtrees;

    public Tree(Object root, ArrayList<Tree> subtrees) {
        this.root = root;
        if (subtrees != null) {
            this.subtrees = subtrees;
        } else {
            this.subtrees = new ArrayList<Tree>();
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int len() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.len();
            }
            return size;
        }
    }

    public int count(Object item) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int num = 0;
            if (this.root.equals(item)) {
                num += 1;
            }
            for (Tree subtree : this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }

    public String toString() {
        return this.stringIndented(0);
    }

    private String stringIndented(int depth) {

        if (this.root == null) {
            return "";
        } else {
            StringBuilder s = new StringBuilder(" ".repeat(depth) + this.root + '\n');
            for (Tree subtree : this.subtrees)
                s.append(subtree.stringIndented(depth + 1));
            return s.toString();
        }
    }

    public float average() {
        if (this.isEmpty()) {
            return 0.0F;
        } else {
            int total = this.averageHelper()[0], count = this.averageHelper()[1];
            return (float) (total / count);
        }
    }

    private Integer[] averageHelper() {
        if (this.isEmpty()) {
            return new Integer[]{0, 0};
        } else {
            int total = (int)this.root;
            int size = 1;
            for (Tree subtree : this.subtrees) {
                int subtree_total = subtree.averageHelper()[0], subtree_size = subtree.averageHelper()[1];
                total += subtree_total;
                size += subtree_size;
            }
            return new Integer[]{total, size};
        }
    }

    public boolean equalsTo(Tree other) {
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            if (this.root != other.root) {
                return false;
            } else if (this.subtrees.size() != other.subtrees.size()) {
                return false;
            }
            return this.subtrees == other.subtrees;
        }
    }

    public boolean contains(Object item) {
        if (this.isEmpty()) {
            return  false;
        }
        if (this.root == item) {
            return true;
        } else {
            for (Tree subtree : this.subtrees) {
                if (item.equals(subtree.root)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ArrayList<Object> leaves() {
        if (this.isEmpty()) {
            return new ArrayList<>();
        } else if (this.subtrees.isEmpty()) {
            ArrayList<Object> list = new ArrayList<>();
            list.add(this.root);
            return list;
        } else {
            ArrayList<Object> leaves = new ArrayList<>();
            for (Tree subtree : this.subtrees) {
                leaves.add(subtree.leaves());
            }
            return leaves;
        }
    }

    public boolean deleteItem(Object item) {
        if (this.isEmpty()) {
            return false;
        } else if (this.root.equals(item)) {
            this.deleteRoot();
            return true;
        } else {
            for (Tree subtree : this.subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    this.subtrees.remove(subtree);
                    return true;
                } else if (deleted) {
                    return true;
                } else {
                    ;
                }
            }
        }
        return false;
    }

    private void deleteRoot() {
        if (this.subtrees.isEmpty()) {
            this.root = null;
        } else {
            Tree csubtree = this.subtrees.remove(this.subtrees.size() - 1);
            this.root = csubtree.root;
            this.subtrees.addAll(csubtree.subtrees);
        }
    }

    public void insert(Object item) {
        if (this.isEmpty()) {
            this.root = item;
        } else if (this.subtrees.isEmpty()) {
            ArrayList<Tree> list = new ArrayList<>();
            list.add(new Tree(item, new ArrayList<>()));
            this.subtrees = list;
        } else {
            if ((1 + (int) (Math.random() * ((3 - 1) + 1))) == 3) {
                this.subtrees.add(new Tree(item, new ArrayList<>()));
            } else {
                int subtree_index = (int) (Math.random() * ((this.subtrees.size() - 1) + 1));
                this.subtrees.get(subtree_index).insert(item);
            }
        }
    }
}

