package parallelStreams;

import exercise19to22.RandomString;
import exercise19to22.TrafficCard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        ArrayList<TrafficCard> cardUsersArray = new ArrayList<>();
        LinkedList<TrafficCard> cardUsersLinked = new LinkedList<>();
        RandomString rString = new RandomString(10);

        float genBalance;
        TrafficCard myCard;
        Random r = new Random();

        for (int i = 0; i < 5000000; i++) {
            genBalance = ((float) r.nextInt(10000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsersArray.add(myCard);
            cardUsersLinked.add(myCard);
        }

        final long startTimeArray = System.currentTimeMillis();
        cardUsersArray
                .stream().parallel()
                .sorted((t1, t2) -> Float.compare(t1.getBalance(), t2.getBalance()))
                .forEach(System.out::println);
        final long endTimeArray = System.currentTimeMillis();

        final long startTimeLinked = System.currentTimeMillis();
        cardUsersLinked
                .stream().parallel()
                .sorted((t1, t2) -> Float.compare(t1.getBalance(), t2.getBalance()))
                .forEach(System.out::println);
        final long endTimeLinked = System.currentTimeMillis();

        System.out.println("ArrayList took: " + ((endTimeArray - startTimeArray) / 1000F) + " s to execute");
        System.out.println("LinkedList took: " + ((endTimeLinked - startTimeLinked) / 1000F) + " s to execute");
    }
}
