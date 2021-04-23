import binaryTree.BinaryTree;
import treeSet.TreeSetContainer;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args){
        int[] randomNumberArray = new int[MAX];

        System.out.println("\n\nGenerating random numbers into array");
        for(int i = 0; i <= randomNumberArray.length - 1; i++)
            randomNumberArray[i] = (int)Math.round(Math.random() * MAX);

        System.out.println("\n\nTesting the speed of BinaryTree:");

        System.out.println("\nCreating binaryTree");
        BinaryTree bTree = new BinaryTree();

        System.out.println("\nInserting values into binaryTree and printing inOrder");
        final long startTime = System.currentTimeMillis();
        for(int i = 0; i <= randomNumberArray.length - 1; i++)
            bTree.insert(randomNumberArray[i]);
        bTree.inOrder();
        final long endTime = System.currentTimeMillis();

        System.out.println("\nCreating treeSet");
        TreeSetContainer sTree = new TreeSetContainer();

        System.out.println("\nInserting values into treeSet and printing inOrder");
        final long startTime2 = System.currentTimeMillis();
        for(int i = 0; i <= randomNumberArray.length - 1; i++)
            sTree.add(randomNumberArray[i]);
        sTree.inOrder();
        final long endTime2 = System.currentTimeMillis();

        System.out.println("\n");
        System.out.println("BinaryTree execution time: " + ((endTime - startTime) / 1000F) + " sec");
        System.out.println("TreeSet execution time: " + ((endTime2 - startTime2) / 1000F) + " sec");
    }

}
