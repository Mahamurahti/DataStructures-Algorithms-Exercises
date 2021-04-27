package exercise19to21;

/**
 * @author Eric Keränen
 */
public class TrafficCard implements Comparable {

    private int travellerNumber;
    private String ownerName;
    private float balance;

    public TrafficCard(int number, String name, float balance){
        this.travellerNumber = number;
        this.ownerName = name;
        this.balance = balance;
    }

    public int getTravellerNumber() {
        return travellerNumber;
    }

    public void setTravellerNumber(int travellerNumber) {
        this.travellerNumber = travellerNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "Owner: " + ownerName + " Number: " + travellerNumber + " Balance: " + balance;
    }

    /**
     * Exercise 19:
     * Comparing logic
     *
     * @param obj {Object} is the object this instance is compared to
     * @return zero, if balance is the same, one if this instances balance or more than the objects and minus one
     *         if the balance of this instance is less than the objects balance
     */
    @Override
    public int compareTo(Object obj){
        TrafficCard tc = (TrafficCard) obj;
        if(balance == tc.getBalance())
            return 0;
        else if(balance > tc.getBalance())
            return 1;
        else
            return -1;
    }
}
