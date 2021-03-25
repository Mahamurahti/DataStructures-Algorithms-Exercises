package exercise4;

/**
 * @author Eric Keränen
 */
public class Stack {

    private static final int MAX = 100;
    private String[] list;
    private int index;

    public Stack() {
        this.list = new String[MAX];
        this.index = 0;
    }

    /**
     * Iterator of the stack
     * @return {Iterator} new Iterator class with the current stack content
     */
    public IIterator iterator() {
        return new Iterator(this);
    }

    /**
     * Create a new member to the list and set it as the top member, add one to index
     * @param data {String} information that will be stored
     */
    public void push(String data){
        list[index] = data;
        this.index++;
    }

    /**
     * Remove the first member of the list and return its value, subtract one from index
     * @return {String} value of the first member of the stack, if stack is empty return null
     */
    public String pop(){
        if(index <= 0)
            return null;
        String poppedItem = list[--index];
        return poppedItem;
    }

    /**
     * Peek and return the first element in the array
     * @return {String} the first element of the array
     */
    public String peek(){
        return list[index];
    }

    /**
     * Print out the data inside of the list without changing anything in the list.
     */
    public void printItems(){
        if(list.length == 0){
            System.out.println("Stack is empty");
            return;
        }
        int tempIndex = index;
        while(tempIndex > 0) {
            System.out.println(list[--tempIndex]);
        }
    }

    /**
     * Get the whole stack
     * @return {String[]} the stack itself
     */
    public String[] getStack(){
        return list;
    }

    /**
     * Returns the size of the stack
     * @return {int} size of the stack
     */
    public int size(){
        return this.index;
    }
}
