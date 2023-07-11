package in.ineuron.assign14;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class Solution {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode oddHead = head;
		ListNode evenHead = head.next;
		ListNode odd = oddHead;
		ListNode even = evenHead;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}

		odd.next = evenHead;

		return oddHead;
	}
}

public class EvenOddLinkedListQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Solution solution = new Solution();
		ListNode reorderedList = solution.oddEvenList(head);

		// Print the reordered list
		ListNode current = reorderedList;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();

	}

}
