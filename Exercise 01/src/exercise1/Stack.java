package exercise1;

/**
 * @author Eric Keränen
 */
public class Stack {
    private ListItem top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Create a new member to the list and set it as the top member
     * @param data {String} information that will be stored
     */
    public void push(String data){
        ListItem item = new ListItem();
        item.setNext(this.top);
        item.setData(data);
        this.top = item;
        this.size++;
    }

    /**
     * Remove the first member of the list and return its value
     * @return {ListItem} value of the first member of the stack, if stack is empty return null
     */
    public ListItem pop(){
        if(this.top == null)
            return null;
        ListItem poppedItem = this.top;
        this.top = top.getNext();
        this.size--;
        return poppedItem;
    }

    /**
     * Print out the data inside of the list without changing anything in the list.
     */
    public void printItems(){
        if(this.top == null){
            System.out.println("Stack is empty");
            return;
        }
        ListItem item = this.top;
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
