package in.ineuron.assign14;
import java.util.*;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class LinkedListSumRemoval {
	public ListNode removeZeroSumSublists(ListNode head) {
		// Create a dummy node to handle the case of deleting the head node
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// Create a prefix sum map
		Map<Integer, ListNode> prefixSumMap = new HashMap<>();
		int prefixSum = 0;
		ListNode current = dummy;

		while (current != null) {
			prefixSum += current.val;

			if (prefixSumMap.containsKey(prefixSum)) {
				ListNode prev = prefixSumMap.get(prefixSum).next;
				int sum = prefixSum + prev.val;

				while (prev != current) {
					sum += prev.val;
					prefixSumMap.remove(sum);
					prev = prev.next;
				}

				prefixSumMap.get(prefixSum).next = current.next;
			} else {
				prefixSumMap.put(prefixSum, current);
			}

			current = current.next;
		}

		return dummy.next;
	}
}

public class LinkedListSumRemovalQ8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);

		LinkedListSumRemoval solution = new LinkedListSumRemoval();
		ListNode result = solution.removeZeroSumSublists(head);

		// Print the resulting linked list
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();

	}

}
