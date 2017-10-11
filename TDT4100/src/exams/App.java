package exams;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<String,Integer>(); 
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 10);
		
		for (String key: map.keySet()){
			System.out.println(key + ": " + map.get(key));
		}
		
		//Keys in a map are unique, so "one" won't show up twice. 
	}
	
}
