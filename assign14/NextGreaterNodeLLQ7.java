package in.ineuron.assign14;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public int[] nextLargerNodes(Node head) {
        if (head == null) {
            return new int[0];
        }

        // Step 1: Convert the linked list to an array
        int size = getSize(head);
        int[] arr = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.val;
            current = current.next;
        }

        // Step 2: Find the next greater element for each value in the array
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }

    private int getSize(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}

public class NextGreaterNodeLLQ7 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(5);

        Solution solution = new Solution();
        int[] result = solution.nextLargerNodes(head);

        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

	}

}
