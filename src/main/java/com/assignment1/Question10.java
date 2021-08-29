// program to move the last element of the linked list in the front and rest of the
//element by one position, and then print the modified linked list.
package assignment1_1;

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

	public void moveLastElementToFront() {

		linkedlist current = null, previousToLast = null;
		
		if(fstnode != null) {
			current = fstnode;
			previousToLast = fstnode;
		}
		else return;
		
		//Finding out previous to next node
		while(current.next != null) {
			previousToLast = current;
			current = current.next;
		}
		
		previousToLast.next = null;
		lastnode.next = fstnode;
		fstnode = lastnode;
		lastnode = previousToLast;
	}

	/* Display linked list */
	void display() 
	{
		linkedlist node = fstnode;
		System.out.println("List of node:");
		while(node != null) 
		{
			node.display();
			node = node.next;
		}
	}

}

public class Question10 {

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

		list.display();
		System.out.println();
		list.moveLastElementToFront();
		System.out.println("List after moving last node to first:");
		list.display();
		sc.close();
	}

}
