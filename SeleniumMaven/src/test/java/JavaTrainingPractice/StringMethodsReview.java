package JavaTrainingPractice;

public class StringMethodsReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "My@name@is@Tulika@";
		String str2 = "My name1";
		
		StringMethodsReview obj = new StringMethodsReview();
		
		obj.charAT(str1); // 	Returns the character at the specified index (position)
		obj.compareTo(str1, str2); // compares two strings lexicographically.
		obj.concat(str1, str2); //Appends a string to the end of another string
		obj.contains(str1, str2); //Checks whether a string contains a sequence of characters
		obj.length(str1); //Returns the length of a specified string
		obj.toUpperCase(str1); //Converts a string to upper case letters
		obj.split(str1, "@"); //Splits a string into an array of substrings
		
	}
	
	void charAT(String str) {
		char result =str.charAt(4);
		System.out.println("Verified String Function charAT() : " + result );
	}
	
	void compareTo(String str1,String str2) {

		System.out.println("Verified String Function compareTo() : " + str1.compareTo(str2)  );
	}
	
	void concat(String str1,String str2) {

		System.out.println("Verified String Function concat() : " + str1.concat(str2)  );
	}

	void contains(String str1,String str2) {

		System.out.println("Verified String Function contains() : " + str1.contains(str2)  );
	}
	
	void length(String str1) {

		System.out.println("Verified String Function length() : " + str1.length()  );
	}
	
	void toUpperCase(String str1) {

		System.out.println("Verified String Function toUpperCase() : " + str1.toUpperCase()  );
	}
	
	void split(String str1, String splitchar) {
		String[] arrOfStr = str1.split(splitchar, 0);
		for(String a:arrOfStr) {

		System.out.println("Verified String Function split() : " + a );
		}
	}
	
}
