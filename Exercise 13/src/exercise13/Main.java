package exercise13;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        HashTable hashTable = null;
        boolean prime = false;
        char select;
        int value;

        do {
            System.out.println();
            System.out.println("Give the size of your table (prime number): ");
            value = Read.readInt();
            if(isPrimeNum(value)){
                prime = true;
                hashTable = new HashTable(value);
            }else{
                System.out.println(value + " is not a prime number.");
            }
        }while (!prime);

        do {
            System.out.println("\n\t\t\t1. Insert data into the table.");
            System.out.println("\t\t\t2. Find data from the table.");
            System.out.println("\t\t\t3. Print table data.");
            System.out.println("\t\t\t4. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            switch (select) {
                case '1':
                    System.out.println("Give a number to insert (int): ");
                    value = Read.readInt();
                    hashTable.insert(value);
                    break;
                case '2':
                    System.out.println("Give a number to find from the table (int): ");
                    value = Read.readInt();
                    hashTable.find(value);
                    break;
                case '3':
                    System.out.println("Content of the table:");
                    hashTable.print();
                    break;
                case '4':
                    break;
            }
        }
        while (select != '4');
    }

    /**
     * Check if a number is a prime number
     *
     * @param num {int} number to check
     * @return true if is prime, false if isn't prime
     */
    private static boolean isPrimeNum(int num){
        if(num == 0 || num == 1)
            return false;
        for(int i = 2; i <= num / 2; i++) {
            int temp = num % i;
            if(temp == 0)
                return false;
        }
        return true;
    }
}
