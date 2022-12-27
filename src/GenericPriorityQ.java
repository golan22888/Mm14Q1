import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class GenericPriorityQ<T> implements Iterable<T> {
    private ArrayList<T>[] q;
    private int len;


    //constructor that initializes an array of arraylists with the size of the priority levels we have.
    public GenericPriorityQ(int priorityRange) {
        this.len = priorityRange;
        initializeAL(len);
    }

    //initializing every arraylist in the array.
    private void initializeAL(int size) {
        q = new ArrayList[len];
        for (int i = 0; i < size; i++) {
            q[i] = new ArrayList<T>();
        }
    }

    //add item to the priorityQ
    public void add(T item, int priority) {
        int range = q.length;
        //checks if the priority is out of the range
        if (priority < 1 || priority > range) {
            //if it is-> set the priority to the lowest priority available.
            priority = range;
        }
        // array start with 0 and the priorities with 1. so we want to adjust the priority to the array.
        priority = priority - 1;
        q[priority].add(item);
    }

    public T poll() {
        int range = q.length, i;
        T temp;
        for (i = 0; i < range && q[i].isEmpty(); i++) ;
        if (i >= range)
            return null;
        else {
            temp = q[i].get(0);
            q[i].remove(0);
        }
        return temp;
    }

    public T pop() {
        int range = q.length, i;
        T temp;
        for (i = 0; i < range && q[i].isEmpty(); i++) ;
        if (i >= range)
            return null;
        else {
            temp = q[i].get(0);
        }
        return temp;
    }


    public boolean contains(T item) {
        for (int i = 0; i < len; i++) {
            if (q[i].contains(item))
                return true;
        }
        return false;
    }

    public boolean remove(T item) {
        for (int i = 0; i < len; i++) {
            if (q[i].remove(item))
                return true;
        }
        return false;
    }

    public int size() {
        int sumSize = 0;
        for (int i = 0; i < len; i++) {
            sumSize += q[i].size();
        }
        return sumSize;
    }


    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
    }
}


class CustomIterator<T> implements Iterator<T> {
    T current;

    public CustomIterator(GenericPriorityQ<T> gpq){
        current = gpq.pop();
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < 10; i++) {

        }
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}