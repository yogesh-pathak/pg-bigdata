package module1.test;

import java.util.HashMap;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of items in the price list:");
		int totalItems = sc.nextInt();
		
		HashMap<String, Integer> productPrices = new HashMap<String, Integer>();
		System.out.println("Please enter the product name followed by price:");
		sc.nextLine();
		for(int i=0; i<totalItems; i++) {
			String []str = sc.nextLine().split("\\s+");
			productPrices.put(str[0], Integer.parseInt(str[1]));
		}
		
		System.out.println("Please enter the number of products purchased:");
		int totalProductsPurchased = sc.nextInt();
		
		int totalBill = 0;
		System.out.println("Please enter the products purchased by the customer:");
		for(int i=0; i<totalProductsPurchased; i++) {
			totalBill += productPrices.get(sc.next());
		}
		
		System.out.println(totalBill);
		
		sc.close();	
	}
}
