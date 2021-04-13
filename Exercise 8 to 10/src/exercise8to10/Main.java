package exercise8to10;

class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        BinaryTree tree = new BinaryTree();
        char select;
        do {
            System.out.println("\n\t\t\t1. Add an element.");
            System.out.println("\t\t\t2. Remove an element.");
            System.out.println("\t\t\t3. BinaryTree content.");
            System.out.println("\t\t\t4. Find content.");
            System.out.println("\t\t\t5. Exit ");
            System.out.print("\n\n");
            select = Read.character();
            int value;
            switch (select) {
                case '1':
                    System.out.println("Give a value to add (int):");
                    value = Read.readInt();
                    tree.insert(value);
                    break;
                case '2':
                    System.out.println("Give a value to delete (int):");
                    value = Read.readInt();
                    tree.delete(tree, value);
                    break;
                case '3':
                    tree.preOrder();
                    break;
                case '4':
                    System.out.println("Give a value to find (int):");
                    value = Read.readInt();
                    BinaryTree found = tree.find(value);
                    if(found != null){
                        System.out.println("Found: " + found.getData() + " with a height of " + found.getHeight() +
                                           ", left: " + found.getLeft() +
                                           ", right: " + found.getRight());
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