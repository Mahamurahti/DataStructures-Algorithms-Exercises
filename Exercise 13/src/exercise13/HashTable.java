package exercise13;

public class HashTable {

    private int[] hashTable;
    private int size;

    public HashTable(int num){
        if(isPrimeNum(num)){
            hashTable = new int[num];
            size = num;
            System.out.println("Hash table created of the size " + num);
        }else{
            System.out.println(num + " is not a prime number.");
        }
    }

    private boolean isPrimeNum(int num){
        if(num == 0 || num == 1)
            return false;
        for(int i = 2; i <= num / 2; i++) {
            int temp = num % i;
            if(temp == 0)
                return false;
        }
        return true;
    }

    public void insert(int num) {

    }

    public int find(int num){
        return -1;
    }

    public void print(){
        for(int num: hashTable)
            System.out.println(num);
    }

}
