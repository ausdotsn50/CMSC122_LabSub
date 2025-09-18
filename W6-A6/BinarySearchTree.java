public class BinarySearchTree {
    // Src code for BST data struct and in-order traversal: https://www.geeksforgeeks.org/java/java-program-to-construct-a-binary-search-tree/
    private Node root = null;   // Real root of the BST

    // Insertion operation
    public void insert(char key) {
        root = insertRec(root, key);    // Accesses the real root
    }

    // Returns new node for the BST
    public Node insertRec(Node root, char key) {
        // Base case for recursion
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (convertToAdjASCII(key) <= convertToAdjASCII(root.key)) // Less than or equal to based on readings
            root.left = insertRec(root.left, key);
        else if (convertToAdjASCII(key) > convertToAdjASCII(root.key))
            root.right = insertRec(root.right, key);

        return root;
    }

    // Checked: insertion algo for BST
    // Checked: char key conversion to int

    public int convertToAdjASCII(char ch) {
        if(ch == '+') {
            return 91;
        } else if(ch == '-') {
            return 92;
        } else if(ch == '*') {
            return 93;
        } else if(ch == '/') {
            return 94;
        } else if(Character.isDigit(ch)) {
            return (int) ch + 47;
        }
        return (int) ch;
    }

    // Inorder traversal
    public void inorder() {
        System.out.println("\nIn-order Traversal of String X" +
            "\n==============================");
        inorderRec(root);
        System.out.println("\n");
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Java garbage collector handles freeing memory
    public void clear() {
        root = null;
    }

}