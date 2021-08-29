package assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the number of integers to be inserted in the list:");
		int listSize = sc.nextInt();

		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<listSize; i++) {
			System.out.println("Please enter element number " + i + " of the list:");
			al.add(sc.nextInt());
		}
		
		System.out.println(sumOfEvenIndexes(al));
		sc.close();
	}

	public static int sumOfEvenIndexes(ArrayList<Integer> al) {
		
		Iterator<Integer> itr = al.iterator();
		int sum=0;
		while(itr.hasNext()) {
			int num = itr.next();
			if(al.indexOf(num) % 2 == 0)
				sum += num;
		}
		return sum;
	}
}
