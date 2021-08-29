package module1.test;


import java.io.*;
import java.util.*;               // for Stack class
class Node
{
	public int iData;              // data item (key)
	public double dData;           // data item
	public Node leftChild;         // this node's left child
	public Node rightChild;        // this node's right child
	public void displayNode()      // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}  // end class Node
////////////////////////////////////////////////////////////////

class Tree
{
	public Node root;            // first node of tree

	// -------------------------------------------------------------

	public Tree()                  // constructor
	{
		root = null;               // no nodes in tree yet
	}            

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


	public void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}


	// -------------------------------------------------------------
}  // end class Tree

public class Question5
{
	public static void main(String[] args) throws IOException
	{
		Tree theTree = new Tree();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number of integers n to be inserted in the binary search tree:");
		int numOfIntegers = sc.nextInt();
		
		for(int i=0; i<numOfIntegers; i++) {
			System.out.println("Please enter the integer " + i + " to be included in binary tree:");
			theTree.insert(sc.nextInt(), i);
		}
		
		theTree.inOrder(theTree.root);
		sc.close();
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

}  // end class TreeApp  
