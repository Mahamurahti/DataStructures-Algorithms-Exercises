package exercise11;

public class Table {

    private final int[] table;

    public Table(int size) {
        table = new int[size];
    }

    public void insert(int value) {
        if(table[0] != 0){
            System.out.println("There is no more space in the table");
        }else{
            table[0] = value;
            selectSort(table);
        }
    }

    public int binarySearch(int value, int low, int high) {
        int mid = (int) Math.floor(low + (high - low) / 2);
        if (value >= table[0] && value <= table[table.length - 1] && high >= low) {
            System.out.println("Middle index is now: " + mid);
            if (table[mid] == value) {
                System.out.println("Correct value found: " + table[mid]);
                return table[mid];
            } else if (table[mid] > value) {
                System.out.println(value + " is smaller than " + table[mid] + " value");
                return binarySearch(value, low, mid - 1);
            } else {
                System.out.println(value + " is greater than " + table[mid] + " value");
                return binarySearch(value, mid + 1, high);
            }
        }
        System.out.println("Value is not in table");
        return -1;
    }

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
