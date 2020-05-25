package com.tyss.ds;

public class SingleLinkList {

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void display() {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("\nMy Single Link list: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void addInMiddle(Node newNode, Node checkNode) {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			if (current.data == checkNode.data) {
				newNode.next = current.next;
				current.next = newNode;
				System.out.print(newNode.data + " has been inserted\n");
				return;
			}
			current = current.next;
		}
	}
	
	public void deleteInMiddle(Node nodeToDelete) {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			if (current.next.data == nodeToDelete.data) {
				current.next = nodeToDelete.next;
				nodeToDelete.next = null;
				System.out.print(nodeToDelete.data + " has been deleted\n");
				return;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {

		SingleLinkList ssl = new SingleLinkList();

		ssl.addNode(10);
		ssl.addNode(20);
		ssl.addNode(30);
		ssl.addNode(40);
		ssl.addNode(50);

		ssl.display();
		Node newNode = ssl.new Node(80);
		Node checkNode = ssl.new Node(20);
		ssl.addInMiddle(newNode, checkNode);

		ssl.display();
		
		ssl.deleteInMiddle(newNode);
		
		System.out.println("List after deletion: ");
		ssl.display();
	}

}
