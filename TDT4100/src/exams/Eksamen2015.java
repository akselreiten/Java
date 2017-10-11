package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eksamen2015 implements Comparable<Eksamen2015>{

	static List<String> list = new ArrayList<String>();
	static List<Integer> list1 = Arrays.asList(1,2,3,4);
	static List<String> list2 = new ArrayList<String>(); 
	
	
	public static void main(String[] args) {
		
		String number = "171231203"; 
		
		
		char c = '4';
		int a = 4; 
		System.out.println(a % 2);
		System.out.println(list1.size());
		
		list2.add("h"); 
		list2.add("E"); 
		list2.add("O"); 
		
		list.addAll(list2);
		System.out.println(list);
		
		
		
		
	}

	@Override
	public int compareTo(Eksamen2015 o) {
		return 0;
	}
	
}
