public class CircularLinkedList {
    Node head;
    Node tail;

    public void tailInsert(char letter) {
        Node newNode = new Node(letter);

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

    public boolean isPalindrome() {
        // Empty or single letter input
        if(head == null || head == tail) return true;
        
        // Temporary so the list wouldn't be modified for Palindrome checking
        Node tempHead = head;
        Node tempTail = tail;
        
        // Terminate on self loop
        while(tempHead != tempTail && tempHead == tempTail.next) {
            // Early exit for non-palindromes
            if(tempHead.letter != tempTail.letter) {
                return false;
            }

            // Condition failed
            tempHead = tempHead.next; // Remove head
            Node current = tempHead;
            while(current.next != tempTail) {
                current = current.next; // Traverse list until (n - 1) reached
            }
            tempTail = current; // Remove tail
        }
        return true;
    }

    public void display() {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.letter);
            current = current.next;
        }
        System.out.print(current.letter);
    }
}
