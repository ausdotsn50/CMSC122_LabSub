public class DoublyLinkedList {
    protected Node head = null; // Access head in Main
    protected Node tail = null; // Access tail in Main

    // Inserting at the tail
    public void tailInsert(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if(head == null) {
            // By default prev and next are pointing to null
            // Set both head and tail to point to the newNode (only node in the list)
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Pointing to a new tail for quick insertion
        }
    }

    // Method to unsort the doubly linked list
    public void unsort() {
        Node current = head;

        // Checks for an empty list
        if(current == null) {
            System.out.print("[ Cannot unsort an empty list ]");
            return;
        }

        if(head.data == tail.data) {
            System.out.println("[ Cannot unsort list with all identical elements ]");
            return;
        }

        // While not pointing to null
        while(current != null && current.next != null) {
            // Ignores swapping duplicates
            if(current.data != current.next.data) {
                int temp = current.next.data;
                current.next.data = current.data;
                current.data = temp;
            }
            // Skip one node
            current = current.next.next;
        }

        // Applies to odd list length
        if(current != null && current.next == null && current.prev != null) {
            int temp = current.prev.data;
            current.prev.data = current.data;
            current.data = temp;
        }

        display();
    }

    public void display() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }
}
