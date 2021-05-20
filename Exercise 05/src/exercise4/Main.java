package exercise4;

class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        char select;
        Stack stack = new Stack();
        String data;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Remove an element.");
            System.out.println("\t\t\t3. Stack content.");
            System.out.println("\t\t\t4. Stack content through iterator.");
            System.out.println("\t\t\t5. Stack size.");
            System.out.println("\t\t\t6. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            switch (select) {
                case '1':
                    System.out.println("Write the content of the element (string)");
                    data = Read.row();
                    stack.push(data);
                    break;
                case '2':
                    String item = stack.pop();
                    if (item == null)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Removed element: " + item);
                    break;
                case '3':
                    stack.printItems();
                    break;
                case '4':
                    IIterator iterator = stack.iterator();
                    while (iterator.hasNext())
                        System.out.println(iterator.next());
                    break;
                case '5':
                    System.out.println("Stack size = " + stack.size());
                    break;
                case '6':
                    break;
            }
        }
        while (select != '6');
    }
}
