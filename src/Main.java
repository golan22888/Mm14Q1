import java.util.Iterator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        GenericPriorityQ gpq = new GenericPriorityQ<Integer>(5);
        gpq.add(15, 3);
        gpq.add(13, 5);
        gpq.add(13, 1);
//        System.out.println(gpq.poll());
//        System.out.println(gpq.poll());
//        System.out.println(gpq.poll());
        System.out.println(gpq.size());

        for (Iterator<Integer> it = gpq.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}