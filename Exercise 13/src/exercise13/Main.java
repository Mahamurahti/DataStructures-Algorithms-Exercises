package exercise13;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        HashTable hashTable = null;
        char select;
        do {
            System.out.println("\n\t\t\t1. Create hash table.");
            System.out.println("\t\t\t2. Insert data into the table.");
            System.out.println("\t\t\t3. Find data from the table.");
            System.out.println("\t\t\t4. Print table data.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = exercise11.Read.character();
            int value;
            switch (select) {
                case '1':
                    System.out.println("Give the size of your table (prime number): ");
                    value = Read.readInt();
                    hashTable = new HashTable(value);
                    break;
                case '2':
                    System.out.println("Give a number to insert (int): ");
                    value = Read.readInt();
                    hashTable.insert(value);
                    break;
                case '3':
                    System.out.println("Give a number to find from the table (int): ");
                    value = Read.readInt();
                    hashTable.find(value);
                    break;
                case '4':
                    System.out.println("Content of the table:");
                    hashTable.print();
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
