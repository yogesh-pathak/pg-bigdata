package assignment1;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the value for string 1:");
		String str1 = sc.next();
		if(str1.length() >=100 ) {
			System.out.println("Please enter a string value of less than 100 characters:");
			str1 = sc.next();
		}
		
		System.out.println("Please enter the string 2:");
		String str2 = sc.next();
		if(str2.length() >=100 ) {
			System.out.println("Please enter a string value of less than 100 characters:");
			str2 = sc.next();
		}
		
		System.out.println(getLengthOfCommonString(str1, str2));
		sc.close();
	}
	
	public static int getLengthOfCommonString(String str1, String str2) {
		
		int i=0, j=0, lengthOfCommonStr=0;
		while(i<str1.length() && j<str2.length()) {
			if(str1.charAt(i++) == str2.charAt(j++)) {
				lengthOfCommonStr++;
			}
		}
		return lengthOfCommonStr;
	}

}
