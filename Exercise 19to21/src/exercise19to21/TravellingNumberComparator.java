package exercise19to21;

import java.util.Comparator;

/**
 * @author Eric Keränen
 */
public class TravellingNumberComparator implements Comparator {
    /**
     * Exercise 20:
     * Comparing logic
     *
     * @param o1 {Object} is an object which is compared to o2
     * @param o2 {Object} is an object which is compared to o1
     * @return zero, if balance is the same, one if this instances balance or more than the objects and minus one
     *         if the balance of this instance is less than the objects balance
     */
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard tc1 = (TrafficCard) o1;
        TrafficCard tc2 = (TrafficCard) o2;
        if (tc1.getTravellerNumber() == tc2.getTravellerNumber())
            return 0;
        else if (tc1.getTravellerNumber() > tc2.getTravellerNumber())
            return 1;
        else
            return -1;

    }
}
