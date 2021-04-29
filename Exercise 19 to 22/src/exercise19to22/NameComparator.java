package exercise19to22;

import java.util.Comparator;

/**
 * @author Eric Keränen
 */
public class NameComparator implements Comparator {
    /**
     * Exercise 20:
     * Comparing logic
     *
     * @param o1 {Object} is an object which is compared to o2
     * @param o2 {Object} is an object which is compared to o1
     * @return o1 compared to o2
     */
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard tc1 = (TrafficCard) o1;
        TrafficCard tc2 = (TrafficCard) o2;
        return tc1.getOwnerName().compareTo(tc2.getOwnerName());

    }
}
