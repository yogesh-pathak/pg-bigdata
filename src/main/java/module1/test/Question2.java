package module1.test;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class Question2 
{ 
	// Function to print all pairs 
	// with equal sum 
	static void pairWithEqualSum(int A[], int n, int target) 
	{ 
		Map<Integer, HashSet<Point> > mp = new HashMap<Integer, HashSet<Point>>(); 

		// Insert all unique pairs and their 
		// corresponding sum in the map 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = i + 1; j < n; j++) { 
				Point p = new Point(A[i], A[j]); 
				HashSet<Point> pp = new HashSet<Point>(); 
				if(mp.containsKey(A[i] + A[j])) 
					pp.addAll(mp.get(A[i] + A[j])); 
				pp.add(p); 
				mp.put(A[i] + A[j],pp); 
			} 
		} 

		// Traverse the map mp, and for sum 
		// with more than one pair, print all pairs 
		// and the corresponding sum 
		for (Map.Entry<Integer,HashSet<Point>> itr : mp.entrySet()){ 
			if (itr.getKey() == target) { 
				System.out.println(itr.getValue().size());
				break;
			} 
			else { 
				System.out.println("0"); 
				break;
			}
		} 
	} 

	// Driver Code 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the number of integers to be inserted in the array:");
		int listSize = sc.nextInt();
		if(listSize<0 || listSize>100) {
			System.out.println("Please enter a value between 0 and 100:");
			listSize = sc.nextInt();
		}
		

		int arr[] = new int[listSize];
		for(int i=0; i<listSize; i++) {
			System.out.println("Please enter element number " + i + " of the array:");
			arr[i] = sc.nextInt();
		}

		System.out.println("Please enter the target sum:");
		int target = sc.nextInt();

		pairWithEqualSum(arr, listSize, target); 
		sc.close();
	}

} 