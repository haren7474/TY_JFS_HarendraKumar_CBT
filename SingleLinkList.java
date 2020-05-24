package com.tyss.ds;

public class SingleLinkList {

	    class Node{    
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
	            
	        if(head == null) {    
	            head = newNode;    
	            tail = newNode;    
	        }    
	        else {    
	            tail.next = newNode;    
	            tail = newNode;    
	        }    
	    }    
	        
	    public void display() {    
	        Node current = head;    
	            
	        if(head == null) {    
	            System.out.println("List is empty");    
	            return;    
	        }    
	        System.out.println("My Single Link list: ");    
	        while(current != null) {    
	            System.out.print(current.data + " ");    
	            current = current.next;    
	        }    
	        System.out.println();    
	    }    
	        
	    public static void main(String[] args) {    
	            
	    	SingleLinkList ssl = new SingleLinkList();    
	            
	        ssl.addNode(10);    
	        ssl.addNode(20);    
	        ssl.addNode(30);    
	        ssl.addNode(40);  
	        ssl.addNode(50); 
	            
	        ssl.display();    
	    }    
	

}
