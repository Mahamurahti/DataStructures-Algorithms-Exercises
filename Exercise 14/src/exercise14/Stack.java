package exercise14;

public class Stack {
    private ListItem top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Receives the postfix data and acts accordingly. On default everything is pushed to the stack, if an operation
     * is spotted, two previous values are executed by the operation and the result is pushed into the stack.
     *
     * @see "https://www.mathblog.dk/tools/infix-postfix-converter/"
     *
     * @param data {String[]} table of the input the user has to give. Must be formatted right (See link to format)
     */
    public void receiveData(String[] data){
        System.out.println("Your data: ");
        for (String dataPiece : data)
            System.out.print(dataPiece + ", ");
        System.out.println("\n");
        double num1, num2;
        try{
            for (String dataPiece : data){
                switch (dataPiece){
                    case "/":
                        num2 = Double.parseDouble(pop().getData());
                        num1 = Double.parseDouble(pop().getData());
                        System.out.println("Executing: " + num1 + " / " + num2);
                        push(String.valueOf(num1 / num2));
                        break;
                    case "*":
                        num2 = Double.parseDouble(pop().getData());
                        num1 = Double.parseDouble(pop().getData());
                        System.out.println("Executing: " + num1 + " * " + num2);
                        push(String.valueOf(num1 * num2));
                        break;
                    case "+":
                        num2 = Double.parseDouble(pop().getData());
                        num1 = Double.parseDouble(pop().getData());
                        System.out.println("Executing: " + num1 + " + " + num2);
                        push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        num2 = Double.parseDouble(pop().getData());
                        num1 = Double.parseDouble(pop().getData());
                        System.out.println("Executing: " + num1 + " - " + num2);
                        push(String.valueOf(num1 - num2));
                        break;
                    default:
                        push(dataPiece);
                        break;
                }
            }
            System.out.println("Result:");
            printItems();
            pop();
        }catch (Exception e){
            System.out.println("Something went wrong or incorrect input...");
        }
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
