package exercise17;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        char select;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Remove an element.");
            System.out.println("\t\t\t3. TreeSet content inOrder.");
            System.out.println("\t\t\t4. Find content.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            int value;
            switch (select) {
                case '1':
                    System.out.println("Give a value to add (int):");
                    value = Read.readInt();
                    tree.add(value);
                    break;
                case '2':
                    System.out.println("Give a value to delete (int):");
                    value = Read.readInt();
                    boolean removed = tree.remove(value);
                    if(removed)
                        System.out.println("Removed " + value);
                    else
                        System.out.println(value + " was not found");
                    break;
                case '3':
                    Iterator<Integer> iterator = tree.iterator();
                    while (iterator.hasNext())
                        System.out.println(iterator.next());
                    break;
                case '4':
                    System.out.println("Give a value to find (int):");
                    value = Read.readInt();
                    boolean found = tree.contains(value);
                    if(found){
                        System.out.println("Found: " + value);
                    }else{
                        System.out.println("Nothing was found.");
                    }
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
