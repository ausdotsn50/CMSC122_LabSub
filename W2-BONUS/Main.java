import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        String word;

        System.out.print("Enter a word: ");
        word = scn.next();

        for(int i = 0, n = word.length(); i < n; i++) {
            list.tailInsert(word.charAt(i));
        }

        list.display();
        System.out.println(" - " + (list.isPalindrome() ? "is a Palindrome!" : "is not a Palindrome!"));
        
        scn.close();
    }
}
