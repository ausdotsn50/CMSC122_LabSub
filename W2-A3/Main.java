import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.print("Enter a sorted sequence of integers [Enter 0 if finished]: ");
        int data;
        while ((data = scn.nextInt()) != 0) {
            list.tailInsert(data);
        }
        System.out.print("Sorted List: ");
        list.display();

        System.out.print("Unsorted List: ");
        list.unsort();

        /* 
        // Test printing backward
        Node currNode = list.tail;
        while(currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.prev;
        }
        */

        scn.close();
    }
}
