package exercise14;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        char select;
        Stack stack = new Stack();
        String data;
        do {
            System.out.println("\n\t\t\t1. Create a postfix calculation");
            System.out.println("\t\t\t2. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            switch (select) {
                case '1':
                    System.out.println("(Example: \"(3 + 4) * (5 / 2)\" is in postfix \"3 4 + 5 2 / *\")");
                    System.out.println("Write the content of the postfix calculation: ");
                    data = Read.row();
                    stack.receiveData(data.split(" "));
                    break;
                case '2':
                    break;
            }
        }
        while (select != '2');
    }
}
