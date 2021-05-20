package exercise4;

/**
 * @author Eric Keränen
 */
public class Iterator implements IIterator{

    private Stack stack;
    private int currentIndex;

    public Iterator (Stack stack) {
        this.stack = stack;
        currentIndex = stack.size();
    }

    /**
     * If the current index is more or equal to -1, it has contents
     * @return {boolean} true if the stack has more or is equal to -1, else return false
     */
    @Override
    public boolean hasNext() {
        return currentIndex >= 1;
    }

    /**
     * Return the next element from the list without modifying the original list
     * @return {String} currently indexed element from the list (stack)
     */
    @Override
    public String next() {
        String[] tempStack = stack.getStack();
        return tempStack[--currentIndex];
    }
}
