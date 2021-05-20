package exercise2;

class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        char select;
        Queue queue = new Queue();
        String data;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Remove an element.");
            System.out.println("\t\t\t3. Queue content.");
            System.out.println("\t\t\t4. Queue size.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            switch (select) {
                case '1':
                    System.out.println("Write the content of the element (string)");
                    data = Read.row();
                    queue.push(data);
                    break;
                case '2':
                    ListItem item = queue.pop();
                    if (item == null)
                        System.out.println("Queue is empty");
                    else
                        System.out.println("Removed element: " + item.getData());
                    break;
                case '3':
                    queue.printItems();
                    break;
                case '4':
                    System.out.println("Queue size = " + queue.size());
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
