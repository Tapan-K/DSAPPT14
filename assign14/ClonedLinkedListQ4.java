package in.ineuron.assign14;


class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class LinkedListSpecial {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void setRandomPointers(Node head) {
        Node current = head;
        while (current != null) {
            Node randomNode = current.random;
            if (randomNode != null) {
                Node newNode = getNewNode(head, randomNode);
                current.random = newNode;
            }
            current = current.next;
        }
    }

    Node getNewNode(Node head, Node randomNode) {
        Node current = head;
        while (current != null) {
            if (current == randomNode) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Node cloneList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node clonedHead = null;
        Node clonedCurrent = null;

        // Create a copy of the original list, connecting only the next pointers
        while (current != null) {
            Node newNode = new Node(current.data);
            if (clonedHead == null) {
                clonedHead = newNode;
                clonedCurrent = newNode;
            } else {
                clonedCurrent.next = newNode;
                clonedCurrent = clonedCurrent.next;
            }
            current = current.next;
        }

        // Set the random pointers in the cloned list
        setRandomPointers(head);

        // Fix the next pointers of the cloned list
        current = head;
        clonedCurrent = clonedHead;
        while (current != null && clonedCurrent != null) {
            Node randomNode = current.random;
            if (randomNode != null) {
                Node clonedRandomNode = randomNode.random;
                clonedCurrent.random = clonedRandomNode;
            }
            current = current.next;
            clonedCurrent = clonedCurrent.next;
        }

        return clonedHead;
    }

    void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + ", ");
            if (current.random != null) {
                System.out.print(current.random.data + "]");
            } else {
                System.out.print("null]");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class ClonedLinkedListQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LinkedListSpecial ll = new LinkedListSpecial();
	        ll.insert(1);
	        ll.insert(2);
	        ll.insert(3);
	        ll.insert(4);
	        ll.insert(5);

	        // Setting random pointers
	        ll.head.random = ll.head.next.next;
	        ll.head.next.random = ll.head;
	        ll.head.next.next.random = ll.head.next.next.next.next;
	        ll.head.next.next.next.random = ll.head.next;
	        ll.head.next.next.next.next.random = ll.head.next.next;

	        System.out.print("Original Linked list: ");
	        ll.display(ll.head);

	        Node clonedHead = ll.cloneList(ll.head);

	        System.out.print("Cloned Linked list: ");
	        ll.display(clonedHead);

	}

}
