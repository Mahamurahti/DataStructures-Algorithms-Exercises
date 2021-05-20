package exercise2;

/**
 * @author Eric Keränen
 */
public class Queue {
    private ListItem head, tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Create a new member to the list and set the next value to be null
     * 1. If the queue has no members, then set the new member to be as the head and tail of the queue
     * 2. If the queue has one member, then set the new member as the tail and change heads next member to be the tail
     * 3. If the queue has more than two members, then set the tails next member to be the new member and set the
     *    new member to be the new tail.
     * @param data {String} information that will be stored
     */
    public void push(String data){
        ListItem item = new ListItem();
        item.setData(data);
        item.setNext(null);
        if(size == 0){
            head = tail = item;
        }else if(size == 1){
            tail = item;
            head.setNext(tail);
        }else{
            tail.setNext(item);
            tail = item;
        }
        this.size++;
    }

    /**
     * Remove the first member of the list and set the next member of the first member to be the new first member
     * @return {ListItem} value of the first member of the stack, if stack is empty return null
     */
    public ListItem pop(){
        if(this.head == null)
            return null;
        ListItem poppedItem = this.head;
        this.head = head.getNext();
        this.size--;
        return poppedItem;
    }

    /**
     * Print out the data inside of the list without changing anything in the list.
     */
    public void printItems(){
        if(this.head == null){
            System.out.println("Queue is empty");
            return;
        }
        ListItem item = this.head;
        while(item != null) {
            System.out.println(item);
            item = item.getNext();
        }
    }

    /**
     * Returns the size of the stack
     * @return {int} size of the stack
     */
    public int size(){
        return this.size;
    }
}
