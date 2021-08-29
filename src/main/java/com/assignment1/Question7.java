package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<6; i++) {
			System.out.println("Please enter integer " + i + " for the list:");
			al.add(sc.nextInt());
		}
		
		//Print the 3rd element from the beginning
		System.out.print(al.get(2));
		
		//Replace the 5th element from the beginning with integer 8
		al.set(4, 8);
		
		System.out.print(" ");
		
		//Print the 5th element from the beginning
		System.out.print(al.get(4));
		
		System.out.print(" ");
		
		//Print the index of the element 56
		System.out.print(al.indexOf(56));
		
		//Add the element 44 at index 2
		al.add(2, 44);
		
		System.out.print(" ");
		
		//Print the 5th element from the beginning
		System.out.print(al.get(4));
		
		//Remove the element at index 1
		al.remove(1);
		
		System.out.print(" ");
		
		//Print the index of the element 9
		System.out.print(al.indexOf(9));
		sc.close();
	}
	
}
