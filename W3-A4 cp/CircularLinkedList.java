public class CircularLinkedList {
    Node head;
    Node tail;

    public void tailInsert(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void display() {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
    }

    public void sort() {
        // My modified insertion list using circular linked list
        System.out.println("\n\nSorting the list using Modified Insertion Sort\n");

        // We assume that head is sorted, move to the next
        Node traverse = head;
        Node insert = traverse.next;

        while(insert != head) {
            System.out.print("Insert " + insert.data + "--> ");
            while(traverse != insert) {
                if(traverse.data > insert.data) {
                    int temp = traverse.data;
                    traverse.data = insert.data;
                    insert.data = temp;
                }
                traverse = traverse.next;
            }
            traverse = head;
            insert = insert.next;
            display();
            System.out.println();
        }
    }
}
