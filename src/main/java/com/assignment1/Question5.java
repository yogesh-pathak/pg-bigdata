package assignment1;

import java.util.Scanner;

public class Question5 {

	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller to left of pivot and all greater elements to right 
    of pivot */
	int partition(String arr[], int low, int high) 
	{ 
		String pivot = arr[high];  
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j].length() <= pivot.length()) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				String temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		String temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 

	/* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
	void sort(String arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is  
           now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(String arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.println(arr[i]); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		System.out.println("Insert the size of your array");
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		String arr[]=new String[n];
		System.out.println("Insert the elements of your array");
		for(int i=0; i<n; i++)
		{
			arr[i]= sc.next(); 
		}

		Question5 ob = new Question5(); 
		ob.sort(arr, 0, n-1); 

		printArray(arr); 
		sc.close();
	} 
} 

