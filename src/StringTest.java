public class StringTest {

    public static void main(String[] args) {
        final int NUMBER_OF_PRIORITIES = 5;
        GenericPriorityQ gpq = new GenericPriorityQ<String>(NUMBER_OF_PRIORITIES);
        gpq.add("Third", 0);
        gpq.add("Third", 2);
        gpq.add("Fifth", -1);
        gpq.add("Fifth1", 5);
        gpq.add("First", 6);
        gpq.add("First1", 1);
        //gpq.remove("Third");
        System.out.println("After adding");
        for (Object it: gpq) {
            System.out.println(it);
        }

        gpq.remove("Third");
        System.out.println("After removing 3");
        for (Object it: gpq) {
            System.out.println(it);
        }

        gpq.poll();
        System.out.println("After poll");
        for (Object it: gpq) {
            System.out.println(it);
        }
    }
}