package exercise6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author Eric Keränen
 */
public class Stack {
    private LinkedList<String> list;

    public Stack() {
        list = new LinkedList<>();
    }

    /**
     * Add data into the LinkedList
     * @param data {String} data to be pushed
     */
    public void push(String data){
        list.push(data);
    }

    /**
     * Delete and return the first element in the list
     * @return {String} the first element in the list
     */
    public String pop(){
        try{
            return list.pop();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * With the built-in iterator we print out the items in the list
     */
    public void printItems(){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    /**
     * Return the size of the list
     * @return {int} the size of the list
     */
    public int size(){
        return list.size();
    }
}
