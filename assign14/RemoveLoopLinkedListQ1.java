package in.ineuron.assign14;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
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

	void detectAndRemoveLoop() {
		if (head == null || head.next == null) {
			return;
		}

		Node slow = head;
		Node fast = head;

		// Move fast pointer by two steps and slow pointer by one step
		slow = slow.next;
		fast = fast.next.next;

		// Find the meeting point of the slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// If loop exists, move slow pointer to the head and start moving both slow and
		// fast pointers by one step
		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			// Unlink the last node from the loop
			fast.next = null;
		}
	}

	void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}

public class RemoveLoopLinkedListQ1 {

	public static void main(String[] args) {
		// Question 1
		LinkedList ll = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);

		// Create a loop by connecting the last node to the second node (position X = 2)
		ll.head.next.next.next.next.next = ll.head.next;

		System.out.print("Original Linked list: ");
		ll.display();

		ll.detectAndRemoveLoop();

		System.out.print("Linked list after removing the loop: ");
		ll.display();

	}

}
