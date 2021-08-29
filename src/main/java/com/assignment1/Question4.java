package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question4 {

	public static void main(String[] args) {

		int numberOfManagers = 0, numberOfSubordinates = 0;
		Scanner sc = new Scanner(System.in);

		/*
		 * Get number of managers(N) and subordinates(M) with below constraints
		 * 1<= N<=1000
		 * 1<= M < 107
		 */

		System.out.println("Please enter the number of managers and number of subordinates seperated by space:");
		int x=0;
		while(x<3) {
			numberOfManagers = sc.nextInt();
			numberOfSubordinates = sc.nextInt();

			if(numberOfManagers < 1 || numberOfManagers > 1000 || numberOfSubordinates < 1 || numberOfSubordinates >= 10000000) {
				System.out.println("Please enter the number of managers ranging from 1 to 1000 and number of subordinates ranging from 1 to 10000000 separated by space");
				x++;
				continue;
			}
			break;
		}

		/*
		 * Getting the names of all managers with below constraints
		 * 1<= length of subordinate & manager name <=35
		 * The Name of each manager and subordinate will consist of lower-case alphabets only.
		 */

		String managersArr[] = new String[numberOfManagers];
		for(int i=0; i<numberOfManagers; i++) {
			System.out.println("Please enter the manager's name:");

			int y=0; 
			while(y<3) {
				managersArr[i] = sc.next().toLowerCase();
				if(managersArr[i].length() < 1 || managersArr[i].length() > 35) {
					System.out.println("Please enter the managers name between 1 and 35 characters:");
					y++;
					continue;
				}
				break;
			}

		}

		/*
		 * Getting the names of all subordinates with below constraints
		 * 1<= length of subordinate & manager name <=35
		 * The Name of each manager and subordinate will consist of lower-case alphabets only.
		 * It is guaranteed that no two subordinates of the same age shall appear in the same manager's List.
		 */

		HashMap<String,List<SubOrdinate>> subordinatesMap = new HashMap<String,List<SubOrdinate>>();
		for(int i=0; i<numberOfSubordinates; i++)  {
			System.out.println("Please enter the subordinate's details as two strings and one integer:");
			String key=null, subordinateName=null;
			int subordinateAge=0;

			int z=0;
			while(z<3) {
				key = sc.next().toLowerCase();
				subordinateName = sc.next();
				subordinateAge = sc.nextInt();
				if(key.length() < 1 || key.length() > 35 || subordinateAge < 1 || subordinateAge > 1000000) {
					System.out.println("Please enter the subordinate name of length greater then 1 character:");
					z++;
					continue;
				}
				break;
			}

			if(subordinatesMap.get(key) != null) {
				subordinatesMap.get(key).add(new SubOrdinate(subordinateName, subordinateAge));
			}
			else {
				subordinatesMap.put(key, new ArrayList<SubOrdinate>());
				subordinatesMap.get(key).add(new SubOrdinate(subordinateName, subordinateAge));
			}
			//sorting subordinates for a manager on the basis of their age
			List<SubOrdinate> updatedList = removeDuplicatesFromList(subordinatesMap.get(key));
			subordinatesMap.put(key, updatedList);
			Collections.sort(subordinatesMap.get(key));
		}

		sortManagersArray(managersArr);
		printResults(managersArr, subordinatesMap);
		sc.close();
	}

	/*
	 * Remove subordinates with same age for a manager 
	 */
	public static List<SubOrdinate> removeDuplicatesFromList(List<SubOrdinate> list) {

		Set<SubOrdinate> set = new TreeSet<SubOrdinate>(list);
		return new ArrayList<SubOrdinate>(set);
	}

	/*
	 * Printing the results in desired form
	 */
	public static void printResults(String managersArr[], Map<String, List<SubOrdinate>> subordinatesMap) {

		for(int i=0; i<managersArr.length; i++) {
			System.out.println(managersArr[i]);
			for(SubOrdinate obj : subordinatesMap.get(managersArr[i])) {
				System.out.println(obj.name + " " + obj.age);
			}
		}
	}

	/*
	 * Sorting managers list lexicographically
	 */
	public static void sortManagersArray(String managersArr[]) {
		String tmp;
		for(int i=0; i<managersArr.length; i++) {
			for(int j=i+1; j<managersArr.length; j++) {
				if(managersArr[i].compareTo(managersArr[j]) > 0) {
					tmp = managersArr[j];
					managersArr[j] = managersArr[i];
					managersArr[i] = tmp;
				}
			}
		}
	}
}



//Class implementing Comparable interface for sorting subordinates on basis of age
class SubOrdinate implements Comparable<SubOrdinate>{

	String name;
	int age;

	public SubOrdinate(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int compareTo(SubOrdinate arg0) {
		if(age == arg0.age)
			return 0;
		else if(age > arg0.age)
			return 1;
		else
			return -1;
	}

}