package in.ineuron.assign14;

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedListShift {
	ListNode head;

	void insert(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	int getLength() {
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	ListNode leftShift(int k) {
		if (head == null || k <= 0) {
			return head;
		}

		int length = getLength();
		k = k % length; // To handle cases where k > length

		if (k == 0) {
			return head;
		}

		ListNode newHead = head;
		ListNode tail = head;

		// Find the new head and tail positions
		for (int i = 1; i < k; i++) {
			newHead = newHead.next;
		}

		while (tail.next != null) {
			tail = tail.next;
		}

		// Perform the left shift
		tail.next = head;
		head = newHead.next;
		newHead.next = null;

		return head;
	}

	void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}

public class LeftShiftLinkedListByKNodesQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListShift list = new LinkedListShift();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);

		int k = 2;

		System.out.print("Original Linked list: ");
		list.display();

		ListNode shiftedHead = list.leftShift(k);

		System.out.print("Shifted Linked list: ");
		while (shiftedHead != null) {
			System.out.print(shiftedHead.data + " ");
			shiftedHead = shiftedHead.next;
		}
		System.out.println();

	}

}
