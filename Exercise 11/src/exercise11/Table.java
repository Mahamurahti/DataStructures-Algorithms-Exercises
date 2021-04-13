package exercise11;

/**
 * @author Eric Keränen
 */
public class Table {

    private final int[] table;

    public Table(int size) {
        table = new int[size];
    }

    /**
     * Inserts values into the table and sorts the table.
     * If table is full, dont insert anything
     *
     * @param value {int} data to be inserted
     */
    public void insert(int value) {
        if(table[0] != 0){
            System.out.println("There is no more space in the table");
        }else{
            table[0] = value;
            selectSort(table);
        }
    }

    /**
     * Searches for a specified value from the table in the class.
     *
     * @param value {int} searching value
     * @param low {int} lowest index of the table
     * @param high {int} highest index of the table
     * @return {int} the correct value or -1 if the value was not found
     */
    public int binarySearch(int value, int low, int high) {
        int mid = (int) Math.floor(low + (high - low) / 2);                             // Find the middle point
        if (value >= table[0] && value <= table[table.length - 1] && high >= low) {     // Check that the value is within reach
            System.out.println("Middle index is now: " + mid);
            if (table[mid] == value) {                                                  // If the value is in the middle ->
                System.out.println("Correct value found: " + table[mid]);
                return table[mid];                                                      // Return the correct value
            } else if (table[mid] > value) {                                            // If the value is less than the
                System.out.println(value + " is smaller than " + table[mid] + " value");// middle value, it is on the left ->
                return binarySearch(value, low, mid - 1);                          // Continue searching from the lower half. (Recursion)
            } else {                                                                    // If the value is more than the
                System.out.println(value + " is greater than " + table[mid] + " value");// middle value, it is on the right ->
                return binarySearch(value, mid + 1, high);                          // Continue searching from the upper half. (Recursion)
            }
        }
        System.out.println("Value is not in table");
        return -1;                                                                      // Return -1 if the value was not found
    }

    /**
     * Print the content od the table
     */
    public void printContent(){
        for (int i = 0; i < table.length; i++){
            if(i % 10 == 0 && i != 0)
                System.out.println();
            System.out.printf("Index %3d - %3d, ", i, table[i]);
        }
    }

    public int getTableLength() {
        return table.length;
    }

    /**
     * Sort the table with a simple select sort
     * @param table {int[]} to be sorted
     */
    public static void selectSort(int[] table) {
        int i, j, help, smallest;

        for (i = 0; i < table.length; i++) {
            smallest = i;
            for (j = i + 1; j < table.length; j++) {
                if (table[j] < table[smallest]) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                help = table[smallest];
                table[smallest] = table[i];
                table[i] = help;
            }
        }
    }
}
