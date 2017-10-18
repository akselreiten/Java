package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Maps {

	public static void testMap(Map<Integer,String> map){
		
		map.put(9, "Fox"); 
		map.put(6, "Cat"); 
		map.put(3, "Snake"); 
		map.put(0, "Albatross"); 
		map.put(10, "Aliigator"); 
		
		for (Map.Entry<Integer, String> entry : map.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
	}
	
	public static int getInt(Map<Integer,Integer> map){
		return map.get(1);
	}
	
	public static void main(String[] args) {		
		
		Maps obj = new Maps(); 
		System.out.println("----HashMap does not guarantee any order----");
		obj.testMap(new HashMap<Integer,String>());
		System.out.println("----TreeMap sorting keys in natural order (natural order)----");
		obj.testMap(new TreeMap<Integer,String>());
		System.out.println("----LinkedHashMap maintains order that you put things in----");
		obj.testMap(new LinkedHashMap<Integer,String>());
		
		System.out.println("\n\n--------------\n\n");
		//HOW TO SORT A MAP@
		//1 - create the map. 
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("one", 1); map.put("ten", 10); map.put("four", 4); map.put("two", 2);
		
		//2 - create arraylist
		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet()); 
		
		//3 - use Collections.sort
		Collections.sort(list, new Comparator<Entry<String,Integer>>(){
			
			public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		
		list.stream().forEach((s) -> System.out.println(s.getKey() + s.getValue()));
		
	}
	
	
}
