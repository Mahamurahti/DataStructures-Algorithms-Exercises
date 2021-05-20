package exercise3;

import java.util.Random;

/**
 * Translated to English from Finnish
 * @author kamaj
 */
public class SortAlgorithms {
    static int MAX = 30000;
    static long counter = 0, selectSort, mergeSort, quickSort;

    public static void printResults(){
        System.out.printf(
                "Results:" +
                        "\n%25s %s" +
                        "\n%25s %s" +
                        "\n%25s %s",
                "Select sort comparisons:", selectSort,
                "Merge sort comparisons:", mergeSort,
                "Quicksort comparisons:", quickSort
        );
    }

    public static void resetCounter(){
        counter = 0;
    }

    /* ---------------------------------- SELECT SORT ---------------------------------- */

    public static void selectSort() {

        int[] table = new int[MAX]; // Table saves the sorted information
        int i, j, help, smallest;
        Random r = new Random();

        System.out.println("Generating content: ");
        for (i = 0; i < MAX; i++) {
            table[i] = r.nextInt(1000); // Generate numbers
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) // New line
                System.out.println();
        }

        System.out.println("\nExecuting select sort, press Enter");
        Read.character();

        /* ----- START ALGO ----- */
        counter++; // For - start
        for (i = 0; i < MAX; i++) {
            smallest = i;
            counter++; // For - start
            for (j = i + 1; j < MAX; j++) {
                /* Is there any smaller element at the end of the table? */
                counter++; // If statement
                if (table[j] < table[smallest]) {
                    smallest = j;
                }
                counter++; // For - loop
            }
            counter++; // If statement
            if (smallest != i) {
                /* If there is a smaller element, switch their places */
                help = table[smallest];
                table[smallest] = table[i];
                table[i] = help;
            }
            counter++; // For - loop
        }

        /* ----- END ALGO ----- */

        System.out.println();
        for (i = 0; i < MAX; i++) {
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) // New line
                System.out.println();
        }
        selectSort = counter;
        System.out.println("\nComparisons in select sort = " + selectSort + ", press Enter");
        Read.character();
    }

    /* ---------------------------------- MERGE SORT ---------------------------------- */

    public static void mergeSort() {
        int[] a = new int[MAX];
        int i;
        Random r = new Random();

        System.out.println("\nGenerating content: ");
        for (i = 0; i < MAX; i++) {
            a[i] = r.nextInt(1000); // Generate numbers
            System.out.print(a[i] + " ");
            if (i > 0 && i % 40 == 0) // New line
                System.out.println();
        }

        System.out.println("\nExecuting merge sort, press Enter");
        Read.character();

        mergeSort(a, 0, MAX - 1);

        for (i = 0; i < MAX; i++) {
            System.out.print(a[i] + " ");
            if (i > 0 && i % 40 == 0) // New line
                System.out.println();
        }
        mergeSort = counter;
        System.out.println("\nComparisons in merge sort = " + mergeSort + ", press Enter");
        Read.character();
    }

    public static void mergeSort(int[] t, int start, int end) {
        int partition;
        long tableHead, tableTail, tableWhole;

        /* ----- START ALGO ----- */

        counter++; // If statement
        if (start < end) { // Is there at least two elements, that the partition can be made
            tableHead = start;
            tableTail = end;
            tableWhole = (tableHead + tableTail) / 2;
            partition = (int)tableWhole;
            mergeSort(t, start, partition); // Sort the tables head
            mergeSort(t, partition + 1, end); // Sort the tables tail
            merge(t, start, partition, end); // Merge the sorted tables
        }

        /* ----- END ALGO ----- */

    }

    private static int[] helpTable = new int[MAX]; // Helping table (static, don't reserve space from heap!)

    // Assumption: tables t[p..q] and t[q+1...r] are in order
    public static void merge(int[] t, int p, int q, int r) {
        // i points to 1. table (t[p..q]), j points to 2. table (t[q+1...r])
        // k points to the helpTable, where the merge will be written.
        int i = p, j = q + 1, k = 0;
        counter += 2; // While - start (logical and)
        while(i < q + 1 && j < r + 1) {
            counter++; // If statement
            if (t[i] < t[j]) {
                helpTable[k++] = t[i++];
            }
            else {
                helpTable[k++] = t[j++];
            }
            counter += 2; // While - loop (logical and)
        }
        // One table processed, move the other table to be processed
        counter++; // While - start
        while (i < q + 1){
            helpTable[k++] = t[i++];
            counter++; // While - loop
        }
        counter++; // While - start
        while (j < r + 1){
            helpTable[k++] = t[j++];
            counter++; // While - loop
        }
        // Move the merged table to the original table
        counter++; // For - start
        for (i = 0; i < k; i++) {
            t[p+i] = helpTable[i];
            counter++; // For - loop
        }
    }

    /* ---------------------------------- QUICK SORT ---------------------------------- */

    public static void quickSortLoop() {
        int[] table = new int[MAX];
        Random r = new Random();

        System.out.println("\nGenerating content: ");
        for (int i = 0; i < MAX; i++) {
            table[i] = r.nextInt(1000); // Generate numbers
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) { // New line
                System.out.println();
            }
        }
        System.out.println("\nExecuting quick sort, press Enter");
        Read.character();
        qs(table, MAX);

        quickSort = counter;
        System.out.println("\nComparisons in quick sort = " + quickSort + ", press Enter");
        Read.character();
    }

    public static void qs(int[] table, int values) {
        quickSort(table, 0, values - 1);

        for (int i = 0; i < values; i++) {
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) { // New line
                System.out.println();
            }
        }
    }

    public static void quickSort(int[] table, int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        int mid, swap;

        /* ----- START ALGO ----- */

        mid = table[(lo0 + hi0) / 2];
        counter++; // While - start
        while (lo <= hi) {
            counter++; // While - start
            while (table[lo] < mid) {
                ++lo;
                counter++; // While - loop
            }
            counter++; // While - start
            while (table[hi] > mid) {
                --hi;
                counter++; // While - loop
            }
            counter++; // If statement
            if (lo <= hi) {
                swap = table[lo];
                table[lo] = table[hi];
                ++lo;
                table[hi] = swap;
                --hi;
            }
            counter++; // While - loop
        }
        counter++; // If statement
        if (lo0 < hi) {
            quickSort(table, lo0, hi);
        }
        counter++; // If statement
        if (lo < hi0) {
            quickSort(table, lo, hi0);
        }

        /* ----- END ALGO ----- */
    }

}
