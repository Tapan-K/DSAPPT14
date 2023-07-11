package in.ineuron.assign14;


class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
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

    Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node result;
        if (list1.data < list2.data) {
            result = list1;
            result.bottom = merge(list1.bottom, list2);
        } else {
            result = list2;
            result.bottom = merge(list1, list2.bottom);
        }

        result.next = null;
        return result;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.bottom;
        }
        System.out.println();
    }
}

public class FlattenLinkedListQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LinkedList ll = new LinkedList();
	        ll.insert(5);
	        ll.insert(7);
	        ll.insert(8);
	        ll.insert(30);

	        ll.head.bottom = new Node(10);
	        ll.head.bottom.bottom = new Node(20);

	        ll.head.next = new Node(19);
	        ll.head.next.bottom = new Node(22);
	        ll.head.next.bottom.bottom = new Node(50);

	        ll.head.next.next = new Node(28);
	        ll.head.next.next.bottom = new Node(35);
	        ll.head.next.next.bottom.bottom = new Node(40);
	        ll.head.next.next.bottom.bottom.bottom = new Node(45);

	        System.out.print("Original Linked list: ");
	        ll.display();

	        ll.head = ll.flatten(ll.head);

	        System.out.print("Flattened Linked list: ");
	        ll.display();

	}

}
