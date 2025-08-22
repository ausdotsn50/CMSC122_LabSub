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

    public void unsort() {
        Node current = head;

        while(current != null && current.next != null) {
            if(current.data != current.next.data) {
                int temp = current.next.data;
                current.next.data = current.data;
                current.data = temp;
            }

            current = current.next.next;
        }

    }
}
