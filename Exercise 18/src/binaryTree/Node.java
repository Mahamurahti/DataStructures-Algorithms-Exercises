package binaryTree;

/**
 * @author Eric Keränen
 */
public class Node {

    private int data, height;
    private BinaryTree left, right, parent;

    public Node(int value) {
        data = value;
        left = right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public BinaryTree left() {
        return left;
    }

    public BinaryTree right() {
        return right;
    }

    public BinaryTree parent() {
        return parent;
    }

    public void setLeft(BinaryTree tree) {
        left = tree;
    }

    public void setRight(BinaryTree tree) {
        right = tree;
    }

    public void setParent(BinaryTree tree){
        parent = tree;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return  this.height;
    }

    @Override
    public String toString(){
        return String.valueOf(data);
    }

}
