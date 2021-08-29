package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Node
{
	public int iData;              // data item (key)
	public double dData;           // data item
	public Node leftChild;         // this node's left child
	public Node rightChild;        // this node's right child
	public void displayNode()      // display ourself
	{
		System.out.print(iData);
	}
}  // end class Node
////////////////////////////////////////////////////////////////


class Tree
{
	private Node root;            // first node of tree

	// -------------------------------------------------------------

	public Tree()                  // constructor
	{
		root = null;               // no nodes in tree yet
	}            

	// -------------------------------------------------------------

	public Node find(int key)      // find node with given key
	{                           // (assumes non-empty tree)
		Node current = root, prevToPrev = null, prev = null;               // start at root
		
		if(root.iData == key) {
			return root;
		}
		while(current.iData != key)        // while no match,
		{
			if(key < current.iData) {
				current = current.leftChild;// go left?
				prevToPrev = prev;
				prev = current;
			}
			else {
				current = current.rightChild;
				prevToPrev = prev;
				prev = current;
			}
			if(current == null)             // if no child,
				return null;                 // didn't find it
		}
		return prevToPrev;                    // found it
	}   // end find()

	// -------------------------------------------------------------

	public void insert(int id, double dd)
	{
		Node newNode = new Node();    // make new node
		newNode.iData = id;           // insert data
		newNode.dData = dd;
		if(root==null)                // no node in root
			root = newNode;
		else                          // root occupied
		{
			Node current = root;       // start at root
			Node parent;
			while(true)                // (exits internally)
			{
				parent = current;
				if(id < current.iData)  // go left?
				{
					current = current.leftChild;
					if(current == null)  // if end of the line,
					{                 // insert on left
						parent.leftChild = newNode;
						return;
					}
				}                    // end if go left
				else                    // or go right?
				{
					current = current.rightChild;
					if(current == null)  // if end of the line
					{                 // insert on right
						parent.rightChild = newNode;
						return;
					}
				}                    // end else go right
			}                       // end while
		}                          // end else not root
	}        // end insert()
}  // end class Tree


public class Question2
{
	static int counter=1;
	public static void main(String[] args) throws IOException
	{
		Tree theTree = new Tree();

		//insert values
		System.out.println("Enter the total number of employees:");
		int totalEmp = 0, x = 0;
		while(x < 3) {
			totalEmp = getInt();
			if(totalEmp <= 0 || totalEmp >= 100) {
				System.out.println("Please enter employee id between 0 to 100:");
				continue;
			}
			break;
		}

		System.out.println("Enter the employee id for which we need to find the immediate reporting manager:");
		int managerForempId = getInt();

		for(int i=0; i<totalEmp; i++) {
			System.out.println("Enter the employee id " + i + " to form the binary searh tree:");
			theTree.insert(getInt(), counter++);
		}

		Node found = theTree.find(managerForempId);
		if(found != null)
		{
			System.out.print("Found: ");
			found.displayNode();
			System.out.print("\n");
		}
		else
			System.out.println("Employee Not Found.");

	}  // end main()

	// -------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}

	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}

	// -------------------------------------------------------------

}   