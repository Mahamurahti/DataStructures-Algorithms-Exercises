package exercise8to10;

/**
 * @author Eric Keränen
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree(){
        root = null;
    }

    /**
     * Exercise 8:
     * Insert data into the tree with the following rules:
     *
     * 1. If the tree is empty, set the value as the root
     * 2. If the tree is not empty and the value is lower than the root, set it to the left side
     * 3. If the tree is not empty and the value is greater than the root, set it to the right side
     * 4. If a value that is already present in the tree, don't do anything
     * @param data {int} value that is to be inserted into the tree
     */
    public void insert(int data){
        if(root == null){                           // If there are no elements in the tree ->
            root = new Node(data);                  // Create new node.

        }else if(root.getData() > data){            // If the data is less than current data
            if(root.left() != null)                 // and the left position is not free ->
                root.left().insert(data);           // Continue searching for the next vacant spot. (Recursion)
            else                                    // If the left position is free ->
                root.setLeft(new BinaryTree(data)); // Set the data to the position.

        }else if(root.getData() < data){            // If the data is more than current data
            if(root.right() != null)                // and the right position is not free ->
                root.right().insert(data);          // Continue searching for the next vacant spot. (Recursion)
            else                                    // If the  right position is free ->
                root.setRight(new BinaryTree(data));// Set the data to the position.

        }

        root.setHeight(heightOfANode(this));   // Set the height of the node
    }

    /**
     * Exercise 10:
     * Return the height of a tree
     *
     * @param root {BinaryTree} the tree which height is to be measured
     * @return {int} height of the tree in the parameter
     */
    private int heightOfANode(BinaryTree root) {
        if(root == null || isLeaf(root))            // If the are no nodes or the node is a leaf ->
            return 0;                               // Set the height to be zero
        return Math.max(heightOfANode(root.getLeft()), heightOfANode(root.getRight())) + 1; // Get the max height from
    }                                                                                       // either side and add one

    /**
     * Exercise 10:
     * Determine is the tree's node a leaf or not
     *
     * @param root {BinaryTree} the tree which is to be determined
     * @return true if tree has no child nodes, return false if the tree has at least one child node
     */
    private boolean isLeaf(BinaryTree root) {
        return root.getRight() == null && root.getLeft() == null;
    }

    /**
     * Exercise 8:
     * Find data from the tree
     *
     * @param data {int} data that need to be found
     * @return {BinaryTree} root which holds information about itself and its sides
     */
    public BinaryTree find(int data){
        if(root == null){                           // If there are no elements in the tree ->
            return null;                            // Return null.

        }else if(root.getData() == data){           // If the data is the current data ->
            return this;                            // Return it.

        }else if(root.getData() > data){            // If the data is less than current data
            if(root.left() != null)                 // and the left spot is not vacant ->
                return root.left().find(data);      // Continue searching for the matching data. (Recursion)

        }else if(root.getData() < data){            // If the data is more than current data
            if(root.right() != null)                // and the right spot is not vacant ->
                return root.right().find(data);     // Continue searching for the matching data. (Recursion)

        }
        return null;                                // Return null if no matching data was found.
    }

    /**
     * Exercise 9:
     * Delete information form the tree and also modify the tree to keep its binary form (balance)
     *
     * @see "https://www.java2novice.com/java-interview-programs/delete-node-binary-search-tree-bst/"
     *
     * @param root {BinaryTree} tree that will be traversed through
     * @param data {int} information that needs to be deleted
     * @return {BinaryTree} that is found and will replace the value that needs to be deleted
     */
    public BinaryTree delete(BinaryTree root, int data) {
        if(root == null)                                            // If there are no elements in the tree ->
            return root;                                            // Return the root.

        if(root.getData() > data) {                                 // If the data is less than current data ->
            root.setLeft(delete(root.getLeft(), data));             // Traverse left on the tree. (Recursion)

        }else if(root.getData() < data) {                           // If the data is more than current data ->
            root.setRight(delete(root.getRight(), data));           // Traverse right on the tree. (Recursion)

        }else{                                                      // If the correct value was found
            if(root.getLeft() == null && root.getRight() == null) { // and both left and right side are vacant (leaf) ->
                return null;                                        // Return null (which is inserted into the parent (on row 83 or 86)).

            }else if(root.getLeft() == null) {                      // If only the left side is vacant ->
                return root.getRight();                             // Return the right side (and insert it into the parent).

            }else if(root.getRight() == null){                      // If only the right side is vacant ->
                return root.getLeft();                              // Return the left side (and insert it into the parent).

            }else{                                                  // If the node has both of its sides filled ->
                int minValue = minValue(root.getRight());           // Search the lowest value from the right side of the tree
                root.setData(minValue);                             // and set the lowest value as the new value to the node that is being deleted
                root.setRight(delete(root.getRight(), minValue));   // and also delete the lowest value node on the right side.
            }
        }
        return root;                                                // Return the root if no matches were found (same as when tree is empty)
    }

    /**
     * Exercise 9:
     * Find the lowest value from a tree
     *
     * @param root {BinaryTree} tree that will be traversed through
     * @return {int} the lowest value
     */
    private int minValue(BinaryTree root) {
        if(root.getLeft() != null)                  // If the left side is not empty ->
            return minValue(root.getLeft());        // Return the value of the left side. (Recursion)
        return root.getData();                      // Return the leftmost value (which is the lowest value)
    }

    /*
    // First attempt
    public boolean delete(int data){
        if(root == null) {
            return false;
        }else if(root.getData() == data){
            if(root.left() == null && root.right() == null){
                root = null;
                return true;
            }else if(root.right() == null && root.left() != null){
                if(root.parent() == null){
                    root = root.left().root;
                    root.setLeft(null);
                    return true;
                }
                root.parent().setLeft(root.left());
                root.setLeft(null);
                root = null;
                return true;
            }else if(root.left() == null && root.right() != null){
                if(root.parent() == null){
                    root = root.right().root;
                    root.setRight(null);
                    return true;
                }
                root.parent().setRight(root.right());
                root.setRight(null);
                root = null;
                return true;
            }else if(root.left() != null && root.right() != null){
                root.setData(minValue(root.right().root));
                return root.right().delete(root.getData());
            }
        }else if(root.getData() > data){
            if(root.left() != null){
                root.left().setParent(this);
                return root.left().delete(data);
            }
        }else if(root.getData() < data){
            if(root.right() != null){
                root.right().setParent(this);
                return root.right().delete(data);
            }
        }
        return false;
    }

    private int minValue(Node root)
    {
        int minVal = root.getData();
        while (root.left() != null) {
            minVal = root.left().getData();
            root = root.left().root;
        }
        return minVal;
    }
    */

    public void preOrder() {
        if (root != null) {
            System.out.print(root.getData() + ", ");
            if(root.left() != null)
                root.left().preOrder();
            if(root.right() != null)
                root.right().preOrder();
        }

    }

    public int getData(){
        return root.getData();
    }

    public void setData(int data){
        root.setData(data);
    }

    public BinaryTree getLeft(){
        return root.left();
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public BinaryTree getRight(){
        return root.right();
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

    public BinaryTree getParent(){
        return root.parent();
    }

    public void setParent(BinaryTree tree) {
        root.setParent(tree);
    }

    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public String toString(){
        return String.valueOf(this.root);
    }
}
