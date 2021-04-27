package exercise19to21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Eric Keränen
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<TrafficCard> cardUsers = new ArrayList<>();
        RandomString rString = new RandomString(10);

        float genBalance;
        TrafficCard myCard;
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }

        Iterator<TrafficCard> iterator = cardUsers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Exercise 19: -----------------------------------------------------------
        System.out.println("\nSort the card according to balance:\n");

        Collections.sort(cardUsers);

        iterator = cardUsers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Exercise 20: -----------------------------------------------------------
        System.out.println("\nSort the card according to travelling number:\n");

        Collections.sort(cardUsers, new TravellingNumberComparator());

        iterator = cardUsers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nSort the card according to owner name:\n");

        Collections.sort(cardUsers, new NameComparator());

        iterator = cardUsers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Exercise 21: -----------------------------------------------------------
        System.out.println("\nSort the card according to travelling number using lambda:\n");

        Collections.sort(cardUsers, (t1, t2) -> Integer.compare(t1.getTravellerNumber(), t2.getTravellerNumber()));
        /*Collections.sort(cardUsers, Comparator.comparingInt(TrafficCard::getTravellerNumber));*/

        iterator = cardUsers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
