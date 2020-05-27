package com.tyss.ds;

public class DLL {
	Node head;

	class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	public void push(int new_data) {
		Node new_Node = new Node(new_data);

		new_Node.next = head;
		new_Node.prev = null;

		if (head != null)
			head.prev = new_Node;

		head = new_Node;
	}

	public void InsertAfter(Node prev_Node, int new_data) {

		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}

		Node new_node = new Node(new_data);

		new_node.next = prev_Node.next;

		prev_Node.next = new_node;

		new_node.prev = prev_Node;

		if (new_node.next != null)
			new_node.next.prev = new_node;
	}

	void append(int new_data) {
		Node new_node = new Node(new_data);

		Node last = head; 

		new_node.next = null;

		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}

		while (last.next != null)
			last = last.next;

		last.next = new_node;

		new_node.prev = last;
	}
	
	void deleteLast() {
		Node last = head;

		while (last.next != null) {
		last = last.next;
	} 
		last.prev.next= null;
		last.prev= null;
		
	} 
	public void deleteAfter(Node prev_Node) {
		
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}
		System.out.println(prev_Node.next.data);
		prev_Node.next= prev_Node.next.next;
		prev_Node.next.prev= prev_Node;
	}

	public void printlist(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}
	
	public int addOneToSum(Node node) {
		Node last = null;
		int sum=0;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			sum= sum+ node.data; 
			last = node;
			node = node.next;
		}
		return sum+1;
	}

	public static void main(String[] args) {
		DLL dll = new DLL();

		dll.append(6);

		dll.push(7);

		dll.push(1);

		dll.append(4);

		dll.InsertAfter(dll.head.next, 8);

		System.out.println("Created DLL is: ");
		dll.printlist(dll.head);
		
		System.out.println("Add 1 to sum: " + dll.addOneToSum(dll.head));
		
		dll.deleteLast();
		dll.printlist(dll.head);
		
		System.out.println("Delete After"); 
		
		Node prev_Node= dll.new Node(7);
		dll.deleteAfter(prev_Node);
		dll.printlist(dll.head);
		
	}
}
