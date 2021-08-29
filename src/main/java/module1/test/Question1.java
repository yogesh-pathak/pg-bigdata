package module1.test;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		System.out.println("Enter the number of integers n to be inserted in the array:");
		Scanner sc = new Scanner(System.in);
		int totalIntegers = sc.nextInt();
		
		int arr[] = new int[totalIntegers];
		for(int i=0; i<totalIntegers; i++) {
			System.out.println("Enter the " + i + " elements to be included in the array:");
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(getIndexValue(arr, i));
		}
		sc.close();
	}
	
	public static int getIndexValue(int arr[], int idx) {
		int val = 1;
		for(int i=0; i<arr.length; i++) {
			if(idx == i) {
				continue;
			}
			val = val * arr[i];
		}
		return val;
	}

}



//import java.util.HashSet;

//public class BinarySearch {
//public static void main (String [] args){
//      int count = 2;
//      int [] input = {1,2,3,4,5};
//      for(int i=1;i<=count;i++)
//            testarray (input);
//      for(int i=0;i<input.length; i++)
//            System.out.print(input[i]+" ");
//}
//
//public static void testarray (int[] input) {
//      int temp = input[0];
//      for(int i=0;i<input.length-1;i++)
//            input[i] = input[i+1];
//      input[input.length-1] = temp;
//}
//}
//===================================================
//public class BinarySearch {
// public static void main(String[] args) {
//      int[] arr = { 1, 3, 5, 7, 14, 18, 24, 26, 32 };
//      int low = 0, high = arr.length - 1;
//      int element = 26;
//      int result = BinarySearch(arr, low, high, element);
//     }
//
// public static int BinarySearch(int[] arr, int low, int high, int element) {
//           while (low <= high) {
//                 int middle = (low + high) / 2;
//                 System.out.print(middle + " ");
//                 if (arr[middle] > element) {
//                        high = middle;
//                  } 
//                 else if (arr[middle] < element) {
//                        low = middle;
//                  } 
//                 else if (arr[middle] == element) {
//                        return 1;
//                  }
//             }
//           return 0;
//       } 
//}
//======================================================
//public class BinarySearch {
//
//public static void main(String[] args) {
//     int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
//     int low = 0, high = arr.length - 1;
//     int search = 3;
//     if (BinarySearch(arr, low, high, search) == 0) 
//        {
//          System.out.println("Element does not exist");
//         }
//     else
//        {
//          System.out.println("Element exists");
//         }
// }
//
//public static int BinarySearch(int[] arr, int low, int high, int search) {
//     while (low < high) {
//            int middle = (low + high) / 2;
//            if (arr[middle] > search) {
//                       high = middle;
//              } 
//            else if (arr[middle] < search) {
//                       low = middle;
//              }
//            else if (arr[middle] == search) {
//                        return 1;
//              }
//        }
//     return 0;
// }
//}
//========================================================
//public class BinarySearch{
//   public static void main(String [] args){
//         int [] arr = {1,5,2,7,0,12,-5};
//         int low = 0, high = arr.length-1;
//         int element = 0;
//         if(BinarySearch(arr,low,high,element)==0){
//                 System.out.println("Element does not exist");
//         }
//         else
//          {
//                System.out.println("Element exists");
//           }
//    }
//
//   public static int BinarySearch(int [] arr, int low, int high, int element){
//         while(low<high){
//                int middle = (low+high)/2;
//                if(arr[middle]>element){
//                            high = middle; 
//                 }
//                else if(arr[middle]<element){
//                            low = middle;
//                 }
//                else if(arr[middle]==element){
//                            return 1;
//                 }
//          }
//         return 0;
//    }
//}
