package module1.test;

import java.util.Scanner;

class linkedlist {
	String data;
	linkedlist next;
	linkedlist(String value) 
	{
		this.data = value;
	}
	void display() {
		System.out.print(data);
		System.out.print(" ");
	}
}

class linked {

	public linkedlist fstnode, lastnode;
	linked() {
		fstnode = null;
		lastnode = null;
	}	

	/* Insert node or create linked list */
	void insertnode(String value) 
	{
		linkedlist node = new linkedlist(value);
		node.next = null;
		if(fstnode == null) {
			fstnode = lastnode = node;
			System.out.println("Linked list created successfully!");
		}
		else 
		{
			lastnode.next = node;
			lastnode = node;
			System.out.println("Node inserted successfully!");
		}
	}

	public void reverseLinkedList() {

		linkedlist prev = null, current = fstnode, next = null; 
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		fstnode = prev;
	}

	/* Display linked list */
	void display() 
	{
		linkedlist node = fstnode;
		while(node != null) 
		{
			node.display();
			node = node.next;
		}
	}

}

public class Question3 {

	static int numberOfNodes;

	public static void main(String[] args) {

		linked list = new linked();
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter the number of nodes in the linked list:");
		numberOfNodes = sc.nextInt();

		for(int i=1; i<=numberOfNodes; i++) {
			System.out.print("Please enter the " + i + " string value:");
			list.insertnode(sc.next());
		}

		list.reverseLinkedList();
		list.display();
		sc.close();
	}

}

