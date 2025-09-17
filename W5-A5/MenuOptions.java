import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class MenuOptions {
    Scanner scn;
    InfixToPostfix itp = new InfixToPostfix();
    PFEvaluator pfe = new PFEvaluator();
    Queue<String> myQueue = new LinkedList<>();

    public MenuOptions(Scanner scn) {
        this.scn = scn;
    }

    public void addExpressions() {
        // Assuming an int would be entered
        int expNum;
        System.out.print("How many expressions? ");
        expNum = scn.nextInt();    

        scn.nextLine(); // Catches 'enter'
        String infix = null;
        String postfix = null;
        for(int i = 1; i <= expNum; i ++) {
            System.out.print("(Infix) Enter expression # " + i + ": ");
            
            // Infix to postfix
            infix = scn.nextLine();         
            postfix = itp.postfix(infix);
            
            myQueue.add(postfix); // Newly entered expression added to queue
        }
        // System.out.println(myQueue);
    }

    public void displayQueue() {
        System.out.println("\n=================\n" +
                           "Current OTP queue" + 
                           "\n=================\n");
        if(myQueue.isEmpty()) {
            System.out.println("Nothing to see here.");
        }
        else {
            System.out.println(myQueue);
        }
    }

    // Manipulate current queue
    public void generateOTP() {
        if(myQueue.isEmpty()) {
            System.out.println("OTP queue is empty. Please add expressions to the queue first.");
        } else {
            System.out.println("Postfix notation: " + myQueue.peek());

            System.out.println("\n=============\n" +
                                "Generated OTP" + 
                               "\n=============\n");
            
            int otp = pfe.evaluate(myQueue.poll());

            // Convert to string for easier length checking
            String strOTP = Integer.toString(otp);

            if (strOTP.length() < 4) {
                // Pad with leading zeros
                strOTP = String.format("%04d", otp);
            } else if (strOTP.length() > 4) {
                // Take last 4 digits
                strOTP = strOTP.substring(strOTP.length() - 4);
            }
            System.out.println(strOTP);
        }
    }
}   
