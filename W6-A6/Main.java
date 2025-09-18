import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringGenerator newString = new StringGenerator();
        Scanner scn = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        
        int length = 0, choice;
        boolean validInput = false, running = true;

        while(running) {
            System.out.print("Problem-solving with Binary Search Trees\n" +   // temporarily no input handling
                "1. Create BST\n" + 
                "2. Exit\n" +
                "Enter choice: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    // Handling user input for strLength
                    while (!validInput) {
                        System.out.print("\nChoose length for the random String X: ");
                        try {
                            length = scn.nextInt();
                            if (length > 0) {
                                validInput = true; // Input is a positive integer, exit loop
                            } else {
                                System.out.println("Error: Please enter a positive number.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a whole number.");
                            scn.next(); // Consume the invalid input to prevent an infinite loop
                        }
                    }

                    String btString = newString.getSaltString(length);
                    System.out.println("\nString X: " + btString + "\n" +
                        "Length n: " + btString.length());

                    // Insertion of indiv chars of the generated string
                    for(int i = 0; i < btString.length(); i++) {
                        bst.insert(btString.charAt(i));
                    }

                    bst.inorder();

                    bst.clear();
                    validInput = false;
                    break;
                case 2:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    break;
            }

            
        }

        scn.close();
    }
}