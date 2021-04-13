package exercise11;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        Table table = null;
        char select;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Find an element.");
            System.out.println("\t\t\t3. Content of the table.");
            System.out.println("\t\t\t4. Create new table.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            int value;
            switch (select) {
                case '1':
                    if(table != null){
                        System.out.println("Give a value to add (int):");
                        value = Read.readInt();
                        table.insert(value);
                    }else
                        System.out.println("No table found");
                    break;
                case '2':
                    if(table != null) {
                        System.out.println("Give a value to find (int):");
                        value = Read.readInt();
                        table.binarySearch(value, 0, table.getTableLength());
                    }else
                        System.out.println("No table found");
                    break;
                case '3':
                    if(table != null)
                        table.printContent();
                    else
                        System.out.println("No table found");
                    break;
                case '4':
                    System.out.println("Give the size of the table (int):");
                    value = Read.readInt();
                    table = new Table(value);
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
