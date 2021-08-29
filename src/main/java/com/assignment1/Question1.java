package assignment1;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("Please enter the number of elements n to be inserted in the first sorted array:");
		int numberOfElementsInFirstArray = 0, x = 0;
		while(x < 3) {
			numberOfElementsInFirstArray = sc.nextInt();
			if(numberOfElementsInFirstArray < 0 || numberOfElementsInFirstArray >= 100000) {
				System.out.println("Please enter the number of elements n to be inserted in the first sorted array greater "
						+ "than 0 and less than or equal to 100000:");
				continue;
			}
			break;
		}
		
		System.out.println("Please enter the number of elements to be inserted in the second sorted array:");
		int numberOfElementsInSecondArray = 0, y = 0;
		while(y < 3) {
			numberOfElementsInSecondArray = sc.nextInt();
			if(numberOfElementsInSecondArray < 0 || numberOfElementsInSecondArray >= 100000) {
				System.out.println("Please enter the number of elements n to be inserted in the second sorted array greater "
						+ "than 0 and less than or equal to 100000:");
				continue;
			}
			break;
		}
		
		int arr1[] = new int[numberOfElementsInFirstArray];
		for(int i=0; i<numberOfElementsInFirstArray; i++) {
			System.out.println("Please enter element number " + i + " of first array:");
			arr1[i] = sc.nextInt();
		}
		
		int arr2[] = new int[numberOfElementsInSecondArray];
		for(int i=0; i<numberOfElementsInSecondArray; i++) {
			System.out.println("Please enter element number " + i + " of second array:");
			arr2[i] = sc.nextInt();
		}
		
		int arr3[] = mergeTwoSortedArrays(arr1, arr2, numberOfElementsInFirstArray, numberOfElementsInSecondArray);
		
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		sc.close();
	}
	
	public static int[] mergeTwoSortedArrays(int arr1[], int arr2[], int n1, int n2) {
		int arr3 [] = new int[arr1.length + arr2.length];
		int i=n1-1, j=n2-1, k=0;
		
		while(i>=0 && j>=0) {
			if(arr1[i] > arr2[j]) {
				arr3[k++] = arr1[i--];
			}
			else {
				arr3[k++] = arr2[j--];
			}
		}
		
		while(i >= 0) {
			arr3[k++] = arr1[i--];
		}
		
		while(j >= 0) {
			arr3[k++] = arr1[j--];
		}
		return arr3;
	}
}
