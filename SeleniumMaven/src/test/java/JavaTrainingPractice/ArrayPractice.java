package JavaTrainingPractice;

import org.apache.commons.lang3.ArraySorter;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		
		int arrSum =0;

		String[] arrObj = { "Tulika", "Kunal" ,null};

		int b[] = { 10, 2, 0, 5, 9 };

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}
		System.out.println("");
		for (int j : b) { // enhanced for loop
			System.out.println(j);
			arrSum=arrSum+j;
		}
		
		System.out.println("Sum of array 'b'" + arrSum);

		for (String k : arrObj) { // sum of data in array
			if (k!=null){
			System.out.println("Length of " + k + " is: " + k.length());
			}
		}
		
		int x[] = ArraySorter.sort(b) ;

		System.out.println("Sorting a "+ x);
		for (int z : x) { // sum of data in array
			System.out.println("Sorting a "  + z);
		}
		

	}

}
