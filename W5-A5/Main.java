/* 
 * CMSC 122: Data Structures and Algorithms I
 * OTP Generator with Stacks and Queues
 * Submitted by: Angela Denise Almazan
 * 
 * Limitations: 
 * - Currently does not support negative numbers e.g. (-3)
 * - Non-robust user input validation
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        MenuOptions mo = new MenuOptions(scn);

        boolean running = true;
        
        // Main Menu
        int choice;
        while(running) {
            try {
                System.out.println("\nWelcome to OTP Generator!" +
                    "\nTo continue, please select an option below: " +
                    "\n1. Generate OTP" + 
                    "\n2. Add expressions to the OTP Queue" +
                    "\n3. Display OTP queue" +
                    "\n4. Exit program");
                
                System.out.print("\nEnter choice here: ");
                choice = scn.nextInt();
                switch (choice) {
                    case 1:
                        mo.generateOTP();
                        break;
                    case 2:                
                        mo.addExpressions();
                        break;
                    case 3:
                        mo.displayQueue();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    default:
                        break;
                }
            } catch(InputMismatchException e) {
                scn.nextLine(); // Consumes invalid input
                System.out.println("Invalid input. Please try again.");
                continue;
            }
        }
        
        scn.close();
    }
}
