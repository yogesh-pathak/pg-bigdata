package module1.test;

import java.util.Scanner;

public class Question8 {
	
	void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	 
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) 
        { 
                int mid = l + (r - l) / 2; 
      
                // If the element is present at the 
                // middle itself 
                if (arr[mid] == x) 
                    return mid; 
      
                // If element is smaller than mid, then 
                // it can only be present in left subarray 
                if (arr[mid] > x) 
                    return binarySearch(arr, l, mid - 1, x); 
      
                // Else the element can only be present 
                // in right subarray 
                return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
    	Question8 ob = new Question8(); 
    	System.out.println("Insert the size of your array");
    	Scanner sc= new Scanner(System.in);
    	int n = sc.nextInt();
    	int arr[]=new int[n];
    	System.out.println("Insert the elements of your array");
    	for(int i=0; i<n; i++)
    	 {
    		 arr[i]= sc.nextInt(); 
    	 }
    	ob.sort(arr, 0, n-1); 
    	System.out.println("Insert the element which you want to search from the given array"); 
        int x = sc.nextInt(); 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not found"); 
        else
            System.out.println(result); 
        sc.close();
    } 
} 