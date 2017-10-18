package other;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
	Set<String> set1 = new HashSet<String>(); 
	set1.add("Halvor");
	set1.add("August");
	set1.add("Ida");
	set1.add("Lunsj");
	
	System.out.println(set1);
	
	//Does set contain given item? 
	
	set1.contains("Halvor");
	set1.isEmpty();
	set1.size();
	
	
	}
	
}
