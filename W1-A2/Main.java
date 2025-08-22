/* 
 * CMSC 122: Data Structures and Algorithms I
 * Submitted by: Angela Denise Almazan
 * 
 * Week 1, Activity 2: Building Abstract Data Types
 *      This program partially simulates Problem 1: Managing My Confectionary Shop where, as a shop manager, 
 *      you assign trainees/helpers a set of instructions to store ice cream tubs in a freezer arranged in ascending order by their expiry date.
 * 
 *      Note that this only simulates a one stack-part, whereas a full simulation requires a multidimensional stack or so.
*/

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Hello, Trainee. What should we call you? ");
        String trainee = scn.next();
        
        System.out.print("Okay, " + trainee + ". Welcome to the Confectionary Shop!\n\n");

        int maxTubs = 10;
        int preFillSize = rand.nextInt(maxTubs - 1); // Pre-filling the freezer

        String[] flavors = {"Chocolate", "Vanilla", "Strawberry"};

        int[] expYears = IntStream.rangeClosed(2025, 2027).toArray();
        int[] expMos = IntStream.rangeClosed(1, 12).toArray();
        int[] expDays = IntStream.rangeClosed(1, 30).toArray(); // With the assumption that all months have 30 days for simplicity

        int action;
        int challengeAction;
        do {
            System.out.print(
                "1. Start training\n" +
                "2. Leave the confectionary shop\n" +
                "\nSelect an action: ");    
            action = scn.nextInt();

            switch (action) {
                case 1:
                    Freezer freezer = new Freezer();
                    System.out.println("\nOpening the freezer...");
                    System.out.println("Note: Freezer stack size is " + maxTubs + " tubs. Currently at " + preFillSize + (preFillSize > 1 ? " tubs." : " tub.")); // Freezer is pre-filled for this problem
                    
                    for (int i = 0; i < preFillSize; i++) {
                        freezer.pushIceCreamTub(new IceCreamTub(flavors[rand.nextInt(flavors.length)], new ExpiryDate(expYears[rand.nextInt(expYears.length)], expMos[rand.nextInt(expMos.length)], expDays[rand.nextInt(expDays.length)])));
                    }
                    
                    freezer.showContents();
                    
                    // Instructions for the trainee/helper
                    System.out.println("\nTo formally start your training, you will be given a tub of ice cream.\n"
                    + "Your job is to sort the tubs in the freezer and the one in your possession\nsuch that they are arranged in an ascending order of their expiry date.\n"
                    + "And by ascending, we mean the earliest expiry date comes first.\n");

                    boolean continueChallenge = true;
                    while(continueChallenge) {
                        System.out.print("Are you up for the challenge, " + trainee + "?"
                        + "\n1. Yes, I am ready to start!\n"
                        + "2. No, I need to leave the shop.\n"
                        + "\nSelect an action: ");    
                        challengeAction = scn.nextInt();
                        
                        if(challengeAction == 1) {
                            String flavorOfNew = flavors[rand.nextInt(flavors.length)];
                            ExpiryDate expiryOfNew = new ExpiryDate(expYears[rand.nextInt(expYears.length)], expMos[rand.nextInt(expMos.length)], expDays[rand.nextInt(expDays.length)]);
                            
                            System.out.println("\nGreat! You have been given a tub of " + flavorOfNew + " ice cream with expiry date " + expiryOfNew.getExpiryDate() + ".");
                            System.out.println("Sorting the tubs in the freezer...");

                            freezer.pushIceCreamTub(new IceCreamTub(flavorOfNew, expiryOfNew));
                            freezer.sortTubStack();


                            System.out.println("\nClosing the freezer...");
                            System.out.println("You have successfully sorted the tubs in the freezer. Congratulations, " + trainee + "! ");
                            break;
                        }
                        else if(challengeAction == 2) {
                            System.out.println("Training session ended early. Ice cream tubs remain unsorted.");
                            continueChallenge = false;
                        }
                        else {
                            System.out.println("Invalid action. Select only within choices.\n");
                            continue;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Thank you for visiting the confectionary shop, " + trainee + ". Come back anytime you're ready!");
                    break;
                default:
                    System.out.println("Invalid action. Select only within choices.\n");
                    break;
            }
        } while(action < 1 || action > 2);

        scn.close();
    }
}