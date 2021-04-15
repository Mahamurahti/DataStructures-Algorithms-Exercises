package exercise13;

/**
 * @author Eric Keränen
 */
public class HashTable {

    private final int[] hashTable;
    private final int realSize;
    private final int size;
    private int iterations;

    public HashTable(int num){
        hashTable = new int[num];
        size = num;
        realSize = num - 1;
    }

    /**
     * Insert a value into the table with the desired index being the number modulus the size of the table.
     * If the desired index has a number other than zero, check the following index. Repeat this until free spot is found.
     *
     * @param num {int} value to insert into table
     */
    public void insert(int num){
        iterations = 0;
        int index = num % size;
        System.out.println("Checking space on index: " + index);
        if(hashTable[index] == 0){
            System.out.println("Inserting into index: " + index);
            hashTable[index] = num;
        }else
            insert(num, index + 1);
    }

    /**
     * "Continue searching" function for the insert function. Stops searching if iterations exceed the table size.
     *
     * @param num {int} value to insert into table
     * @param index {int} index to keep track where the pointer is
     */
    private void insert(int num, int index){
        iterations++;
        if(index >= size)
            index = 0;
        System.out.println("Checking space on index: " + index);
        if(hashTable[index] == 0){
            System.out.println("Inserting into index: " + index);
            hashTable[index] = num;
        }else if(iterations != realSize)
            insert(num, index + 1);
        else
            System.out.println("No space");
    }

    /**
     * Find a value from the table. Works the same way as the inserting does.
     *
     * @param num {int} value to find from the table
     */
    public void find(int num){
        iterations = 0;
        int index = num % size;
        System.out.println("Searching index: " + index);
        if(hashTable[index] == num)
            System.out.println(hashTable[index] + " found at index " + index);
        else
            find(num, index + 1);
    }

    /**
     * "Continue searching" function for the find function. Stops searching if iterations exceed the table size.
     *
     * @param num {int} value to find form the table
     * @param index {int} index to keep track where the pointer is
     */
    private void find(int num, int index){
        iterations++;
        if(index >= size)
            index = 0;
        System.out.println("Searching index: " + index);
        if(hashTable[index] == num)
            System.out.println(hashTable[index] + " found at index " + index);
        else if(iterations != realSize)
            find(num, index + 1);
        else
            System.out.println("Did not find any " + num);
    }

    /**
     * Prints the content of the table
     */
    public void print(){
        for(int num: hashTable)
            System.out.println(num);
    }

}
