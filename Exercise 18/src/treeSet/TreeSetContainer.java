package treeSet;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Eric Keränen
 */
public class TreeSetContainer {

    private TreeSet<Integer> tree;

    public TreeSetContainer(){
        tree = new TreeSet<>();
    }

    public boolean add(int value){
        boolean found = tree.contains(value);
        if(found)
            return false;
        return tree.add(value);
    }

    public boolean remove(int value){
        return tree.remove(value);
    }

    public void inOrder(){
        Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
    }

}
