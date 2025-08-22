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

        /* 
        // Doubly linked list test
        Node currNode = list.head;
        currNode = currNode.next;
        currNode = currNode.next;
        // currNode = currNode.prev;
        currNode = currNode.next;
        currNode = currNode.prev;

        System.out.println("Value of current node: " + currNode.data);
        */

        
        // Test printing forward
        Node currNode = list.head;
        while(currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
        

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
