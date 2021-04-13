package exercise12;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        BinaryHeap heap = new BinaryHeap();
        char select;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Delete an element.");
            System.out.println("\t\t\t3. Head of the heap.");
            System.out.println("\t\t\t4. Everything from the heap.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = exercise11.Read.character();
            int value;
            switch (select) {
                case '1':
                    System.out.println("Give a value to add to the heap (int): ");
                    value = Read.readInt();
                    heap.insert(value);
                    break;
                case '2':
                    System.out.println("Deleted: " + heap.deleteMin());
                    break;
                case '3':
                    System.out.println("Head of the heap: " + heap.head());
                    break;
                case '4':
                    heap.print();
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
