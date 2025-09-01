import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        System.out.print("Enter a non-sorted sequence of integers [Enter 0 if finished]: ");
        int data;
        while ((data = scn.nextInt()) != 0) {
            list.tailInsert(data);
        }
        
        System.out.print("Unsorted List: ");
        list.display();

        list.sort();

        System.out.print("\nSorted List: ");
        list.display();
        System.out.println();

        scn.close();
    }
}
