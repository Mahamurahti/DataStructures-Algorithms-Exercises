import binaryTree.BinaryTree;
import treeSet.TreeSetContainer;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args){
        int[] randomNumberArray = new int[MAX];

        System.out.println("\n\nGenerating random numbers into array");
        for(int i = 0; i <= randomNumberArray.length - 1; i++){
            randomNumberArray[i] = (int)Math.round(Math.random() * MAX);
        }

        System.out.println("\n\nCreating binaryTree and treeSet");
        BinaryTree bTree = new BinaryTree();
        TreeSetContainer sTree = new TreeSetContainer();

        System.out.println("\n\nInserting values into the trees");
        for(int i = 0; i <= randomNumberArray.length - 1; i++){
            bTree.insert(randomNumberArray[i]);                     // We insert everything in the randomNumberArray,
            sTree.add(randomNumberArray[i]);                        // the sets handle cases of duplicates.
        }

        System.out.println("\n\nTesting the speed of both trees:");

        final long startTime = System.currentTimeMillis();
        bTree.inOrder();
        final long endTime = System.currentTimeMillis();

        final long startTime2 = System.currentTimeMillis();
        sTree.inOrder();
        final long endTime2 = System.currentTimeMillis();

        System.out.println();
        System.out.println("BinaryTree execution time: " + ((endTime - startTime) / 1000F) + " sec");
        System.out.println("TreeSet execution time: " + ((endTime2 - startTime2) / 1000F) + " sec");
    }

}
