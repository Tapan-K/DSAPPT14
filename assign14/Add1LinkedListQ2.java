package in.ineuron.assign14;

import java.util.*;
import java.io.*;

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

	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	void addOne() {
		head = reverse(head);

		Node current = head;
		int carry = 1;

		while (current != null) {
			int sum = current.data + carry;
			current.data = sum % 10;
			carry = sum / 10;

			if (carry == 0) {
				break;
			}

			current = current.next;
		}

		head = reverse(head);
	}

	void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data);
			current = current.next;
		}
		System.out.println();
	}
}

public class Add1LinkedListQ2 {

	public static void main(String[] args) {
		// Question 2
		LinkedList ll = new LinkedList();
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);

		System.out.print("Original Linked list: ");
		ll.display();

		ll.addOne();

		System.out.print("Updated Linked list: ");
		ll.display();

	}

}
