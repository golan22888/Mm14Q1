public class CostumerTest {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIORITIES = 5;
        GenericPriorityQ gpq = new GenericPriorityQ<CostumerCall>(NUMBER_OF_PRIORITIES);
        CostumerCall cc1 = new CostumerCall("Golan", "123456", "Can't connect to Outlook");
        CostumerCall cc2 = new CostumerCall("Igal", "123456", "Can't connect to Teams");
        CostumerCall cc3 = new CostumerCall("Nahum", "123456", "Can't connect to Github");
        gpq.add(cc1, 3);
        gpq.add(cc2, 2);
        gpq.add(cc1, 3);
        gpq.add(cc3, 2);
        gpq.add(cc3, 2);
        gpq.add(cc3, 2);
        gpq.add(cc3, 2);
        gpq.add(cc2, 1);
        gpq.add(cc3, 4);


        System.out.println("After adding 123");
        for (Object item : gpq) {
            System.out.println(item);
        }

        gpq.remove(cc2);
        System.out.println("After removing Igal");
        for (Object it : gpq) {
            System.out.println(it);
        }

        gpq.poll();
        System.out.println("After poll");
        for (Object it : gpq) {
            System.out.println(it);
        }

        if (gpq.contains(cc2))
            System.out.println("Does contain " + cc2.toString());
        else
            System.out.println("Does not contain " + cc2.toString());
        if (gpq.contains(cc1))
            System.out.println("Does contain " + cc1.toString());
        else
            System.out.println("Does not contain " + cc1.toString());
    }
}

