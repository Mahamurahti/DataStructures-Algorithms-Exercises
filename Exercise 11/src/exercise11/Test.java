package exercise11;

public class Test {
    public static void main(String[] args) {

        System.out.println("\n\n Binary Search with a table with even number of elements \n\n");

        int[] evenTable = new int[100];

        for (int i = 0; i < evenTable.length; i++)
            evenTable[i] = (i + 1) * 2;
        printContent(evenTable);

        System.out.printf("\n\nBinary even search: %d\n", 14);
        System.out.println(binarySearch(14, evenTable, 0, evenTable.length));

        System.out.printf("\n\nBinary odd non-existent search: %d\n", 171);
        System.out.println(binarySearch(171, evenTable, 0, evenTable.length));

        System.out.printf("\nBinary even search low number: %d\n", 2);
        System.out.println(binarySearch(2, evenTable, 0, evenTable.length));

        System.out.printf("\nBinary even search high number: %d\n", 200);
        System.out.println(binarySearch(200, evenTable, 0, evenTable.length));

        System.out.printf("\nBinary even search too high number: %d\n", 400);
        System.out.println(binarySearch(400, evenTable, 0, evenTable.length));

        System.out.printf("\nBinary even search too low number: %d\n", 1);
        System.out.println(binarySearch(1, evenTable, 0, evenTable.length));

        System.out.println("\n\n Binary Search with a table with odd numbers of elements \n\n");

        int[] oddTable = new int[101];

        for (int i = 0; i < oddTable.length; i++)
            oddTable[i] = (i + 1) * 2;
        printContent(oddTable);

        System.out.printf("\n\nBinary odd search: %d\n", 14);
        System.out.println(binarySearch(14, oddTable, 0, oddTable.length));

        System.out.printf("\n\nBinary odd non-existent search: %d\n", 171);
        System.out.println(binarySearch(171, oddTable, 0, oddTable.length));

        System.out.printf("\nBinary odd search low number: %d\n", 2);
        System.out.println(binarySearch(2, oddTable, 0, oddTable.length));

        System.out.printf("\nBinary odd search high number: %d\n", 202);
        System.out.println(binarySearch(202, oddTable, 0, oddTable.length));

        System.out.printf("\nBinary even search too high number: %d\n", 400);
        System.out.println(binarySearch(400, oddTable, 0, oddTable.length));

        System.out.printf("\nBinary even search too low number: %d\n", 1);
        System.out.println(binarySearch(1, oddTable, 0, oddTable.length));
    }

    public static void printContent(int[] table){
        for (int i = 0; i < table.length; i++){
            if(i % 10 == 0 && i != 0)
                System.out.println();
            System.out.printf("Index %3d - %3d, ", i, table[i]);
        }
    }

    public static int binarySearch(int value, int[] table, int low, int high){
        int mid = (int)Math.floor(low + (high - low) / 2);
        if(value >= table[0] && value <= table[table.length - 1] && high >= low){
            System.out.println("Middle index is now: " + mid);
            if(table[mid] == value){
                System.out.println("Correct value found");
                return table[mid];
            }else if(table[mid] > value){
                System.out.println(value + " is smaller than " + table[mid] + " value");
                return binarySearch(value, table, low,mid - 1);
            }else{
                System.out.println(value + " is greater than " + table[mid] + " value");
                return binarySearch(value, table, mid + 1, high);
            }
        }
        System.out.println("Value is not in table");
        return -1;
    }
}
