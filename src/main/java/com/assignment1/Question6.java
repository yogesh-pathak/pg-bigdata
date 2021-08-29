package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

public class Question6 
{ 
	static class pair 
	{  
		int first, second;  
		public pair(int first, int second)   
		{  
			this.first = first;  
			this.second = second;  
		}     
	}  

	// Function to print all pairs 
	// with equal sum 
	static void pairWithEqualMultiplication(int A[], int n) 
	{ 
		Map<Integer, ArrayList<pair> > mp = new HashMap<Integer, ArrayList<pair>>(); 

		// Insert all unique pairs and their 
		// corresponding sum in the map 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = i + 1; j < n; j++) { 
				pair p = new pair(A[i], A[j]); 
				ArrayList<pair> pp = new ArrayList<pair>(); 
				if(mp.containsKey(A[i] * A[j])) 
					pp.addAll(mp.get(A[i] * A[j])); 
				pp.add(p); 
				mp.put(A[i] * A[j],pp); 
			} 
		} 

		// Traverse the map mp, and for multiplication 
		// with more than one pair, print all pairs 
		// and the corresponding sum 
		for (Map.Entry<Integer,ArrayList<pair>> itr : mp.entrySet()){ 
			if (itr.getValue().size() > 1) { 
				for (int i = 0; i < itr.getValue().size(); i++) { 
					System.out.print("( " +  itr.getValue().get(i).first+ ", "
							+ itr.getValue().get(i).second+ ") ");
					if(i<itr.getValue().size()-1)
						System.out.print("and ");
				} 
				break;
			} 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the number of integers to be inserted in the list:");
		int listSize = sc.nextInt();

		int arr[] = new int[listSize];
		for(int i=0; i<listSize; i++) {
			System.out.println("Please enter element number " + i + " of the list:");
			arr[i] = sc.nextInt();
		}
		pairWithEqualMultiplication(arr, listSize); 
		sc.close();
	}

} 