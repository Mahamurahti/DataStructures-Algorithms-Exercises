package binaryTree;

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

        BinaryTree found = find(data);              // Try to find if the value is already in the tree
        if(found != null)                           // If the value is not null, something was found ->
            return;                                 // Return and don't continue inserting

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
     * @see "https://www.baeldung.com/cs/binary-tree-height"
     *
     * @param root {BinaryTree} the tree which height is to be measured
     * @return {int} height of the tree in the parameter
     */
    private int heightOfANode(BinaryTree root) {
        if(root == null || isLeaf(root))            // If the are no nodes or the node is a leaf ->
            return 0;                               // Set the height to be zero
        // Traverse down the right side and the left side of the tree until a leaf is reached. Return the leaf's return
        // value (0) and add one to it. For every node there is on that side of the tree, one is added to the height.
        // When a split is reached, the max value of the subtrees is chosen (the side with more deeper "roots") and again
        // one is added to it. The height is updated automatically as the insert op traverses the tree. See example below.
        return Math.max(heightOfANode(root.getLeft()), heightOfANode(root.getRight())) + 1;
    }

    /*
     *       100 3                       100 4                      100 4            / In the example we see node '110'
     *      /   \                       /   \                      /   \             / in step 2 choosing its height
     *    90 0  110 2                90 0  110 3                 90     110 3        / from the height of its left sub-
     *         /   \        ->            /   \         ->->           /   \         / tree since its the max value
     *       105 1  120 0              105 2  120 0                  105 2  120 0    / between its subtrees (105 and 120).
     *       /                         /                            /   \            / In step 4 the node '105' chooses
     *      102 0                     102 1                       102 1  106 1       / either one of its subtrees, since
     *                                /                          /         \         / their height is the same.
     *                              101 0                      101 0        107 0    / Always after choosing a subtree,
     *       STEP 1                      STEP 2                      STEP 4          / one is added.
     */

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

    public void preOrder() {
        if (root != null) {
            System.out.print(root.getData() + ", ");
            if(root.left() != null)
                root.left().preOrder();
            if(root.right() != null)
                root.right().preOrder();
        }
    }

    public void inOrder(){
        if (root != null) {
            if(root.left() != null)
                root.left().inOrder();
            System.out.print(root.getData() + ", ");
            if(root.right() != null)
                root.right().inOrder();
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
