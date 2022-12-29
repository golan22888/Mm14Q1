import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class GenericPriorityQ<T> implements Iterable<T>{
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

    public int getLength(){
        return this.len;
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
    public Iterator iterator() {
        return new CustomIterator();
    }

    class CustomIterator implements Iterator<T>{

        int len = q.length, indexArray, indexItem;
        Iterator <T> it;

        CustomIterator(){
            it = q[0].iterator();
            indexArray = 0;
            indexItem = 0;
        }

        @Override
        public boolean hasNext() {
            boolean res = false;

            if (indexItem < size())
                res = true;

            return res;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                indexItem++;
                if (it.hasNext())
                    return it.next();

                if (indexArray < len)
                    indexArray++;
                while (indexArray < len && q[indexArray].isEmpty()) {
                    indexArray++;
                }
                return q[indexArray].get(0);
            }
            throw new NoSuchElementException();
        }
    }
}