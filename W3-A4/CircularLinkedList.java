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

    public void implementInsertionSort() {
        // No sorting for empty and single-node lists
        if (head == null || head.next == head) {
            return;
        }

        // Separating sorted and unsorted portions of a Circular Linked List
        Node sorted = null;
        Node unsorted = head;

        do {
            Node unsorted_next = unsorted.next; // Avoid detaching the rest of the unsorted list
            sorted = startInsertion(sorted, unsorted);
            unsorted = unsorted_next;
        } while(unsorted != head);

        head = sorted; // Replace old head with the new head of sorted list
    }

    public Node startInsertion(Node sorted, Node unsorted) {
        // Dealing with the first node
        if(sorted == null) {
            unsorted.next = unsorted; // Self loop
            return unsorted;
        }

        // Note that we have a sorted list and its sort.data is the head of the list
        // If unsorted.data is less than sorted.data --> it would be inserted before head
        if(unsorted.data < sorted.data) { 
            Node last = sorted; // End of list marker
            while (last.next != sorted) {
                last = last.next;
            }
            last.next = unsorted;
            unsorted.next = sorted;
            return unsorted;
        }

        Node current = sorted;
        while(current.next != sorted) { // End of list
            if(current.next.data > unsorted.data) {
                Node temp = current.next;
                current.next = unsorted;
                unsorted.next = temp;
                return sorted;
            }
            current = current.next;
        }
        
        // On a sorted list
        current.next = unsorted;
        unsorted.next = sorted;
        return sorted;
    }
}
