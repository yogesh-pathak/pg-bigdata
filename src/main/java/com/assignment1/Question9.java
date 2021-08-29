//Program to remove duplicates from Linke List
package assignment1;

import java.util.Scanner;

class linkedlist {
	String data;
	linkedlist next;
	linkedlist(String value) 
	{
		this.data = value;
	}
	void display() {
		System.out.println(data);
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

	//removeDuplicate() will remove duplicate nodes from the list  
	public void removeDuplicate() {  
		
		//Node current will point to head  
		linkedlist current = fstnode, index = null, temp = null;  

		if(fstnode == null) {  
			return;  
		}  
		else {  
			while(current != null){  
				//Node temp will point to previous node to index.  
				temp = current;  
				//Index will point to node next to current  
				index = current.next;  

				while(index != null) {  
					//If current node's data is equal to index node's data  
					if(current.data.equals(index.data)) {  
						//Here, index node is pointing to the node which is duplicate of current node  
						//Skips the duplicate node by pointing to next node  
						temp.next = index.next;  
					}  
					else {  
						//Temp will point to previous node of index.  
						temp = index;  
					}  
					index = index.next;  
				}  
				current = current.next;  
			}          
		}  
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

public class Question9 {

	static int numberOfNodes;

	public static void main(String[] args) {

		linked list = new linked();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the number of nodes in the linked list:");
		numberOfNodes = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=numberOfNodes; i++) {
			System.out.println("Please enter the " + i + " string value:");
			list.insertnode(sc.nextLine());
		}

		list.display();
		System.out.println();
		list.removeDuplicate();
		System.out.println("List after removing duplicates:");
		list.display();
		sc.close();
	}

}
