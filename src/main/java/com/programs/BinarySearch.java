import java.util.Scanner;

public class BinarySearch {
	
	// Applying quicksort to sort the array as binary search can be implemented only on sorted arrays
	int partition(int arr[], int low, int high) 
	 { 
    	     int pivot = arr[high];  
    	     int i = (low-1); // index of smaller element 
    	     for (int j=low; j<high; j++) 
    	     { 
    	         // If current element is smaller than or 
    	         // equal to pivot 
    	         if (arr[j] <= pivot) 
    	         { 
    	             i++; 
    
    	             // swap arr[i] and arr[j] 
    	             int temp = arr[i]; 
    	             arr[i] = arr[j]; 
    	             arr[j] = temp; 
    	         } 
    	     } 
    
    	     // swap arr[i+1] and arr[high] (or pivot) 
    	     int temp = arr[i+1]; 
    	     arr[i+1] = arr[high]; 
    	     arr[high] = temp; 
      	     return i+1; 
	 } 
	 
	 
	void sort(int arr[], int low, int high) 
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
    	BinarySearch ob = new BinarySearch(); 
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
        System.out.println("Your array in sorted order looks like");
	    for(int i=0; i<n; i++)
	   	 {
	    	 System.out.println(arr[i]+"");
	   	 }
    	System.out.println("Insert the element which you want to search from the given array"); 
        int x = sc.nextInt(); 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element is found at index " + result); 
        sc.close();
    } 
} 