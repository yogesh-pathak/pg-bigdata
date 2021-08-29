package com.programs;

import java.util.Scanner;
public class BinarySearchExample1 {
    
	// Returns index of x if it is present in arr[l.. r], else return -1 
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) 
        { 
                int mid = l + (r - l) / 2; 
      
                // If the element is present at the 2
                // middle itself 
                if (arr[mid] == x) 
                    return mid;
      
                // If element is smaller than mid, then 
                // it can only be present in left subarray /
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
    	BinarySearchExample1 ob = new BinarySearchExample1(); 
    	int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length;
        System.out.println("Given array is ");
	    for(int i=0; i<n; i++)
	   	 	{
	    	 System.out.println(arr[i]+"");
	   	 	}
    	System.out.println("Insert the element which you want to search from the given array");
    	Scanner sc=new Scanner(System.in);
        int x = sc.nextInt(); 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
             System.out.println("Element not present"); 
        else
             System.out.println("Element is found at index " + result); 
        sc.close();  
    } 
} 