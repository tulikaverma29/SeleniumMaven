package JavaTrainingPractice;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<String> list = new ArrayList<String>();
	list.add("Tulika");
	list.add("Kunal");
	list.add("Kairav");
	list.add(null);
	list.add("Kairav2");
	System.out.println(list);
	Iterator<String> itr = list.iterator();
	
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	for(String i :list) {
		
		System.out.println(i);
	}
	
	System.out.println(1 + 1 + 1 + 1 + 1 == 6);
	
	}

}
