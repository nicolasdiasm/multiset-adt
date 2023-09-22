import java.util.ArrayList;

public class ArrayListMultiSet extends MultiSet {

    private ArrayList<Object> alist;

    public ArrayListMultiSet() {
        this.alist = new ArrayList<>();
    }

    public boolean add(Object item) {
        this.alist.add(item);
        return true;
    }

    public void remove(Object item) {
            this.alist.remove(item);
    }

    public boolean contains(Object item) {
        return this.alist.contains(item);
    }

    public boolean is_empty() {
       return this.alist.isEmpty();
    }

    public int count(Object item) {
        int count = 0;
        for (Object o : this.alist)
            if (o == item) {
                count ++;
            }
        return count;
    }

    public int size() {
        return this.alist.size();
    }
}



