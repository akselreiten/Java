package patterns.delegation.office;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	
	private Map<Employee, List<String>> printHistory;
	
	public Printer(){
		printHistory = new HashMap<Employee, List<String>>();
	}
	

	public List<String> getPrintHistory(Employee employee){
		if (!printHistory.containsKey(employee)){
			return Collections.emptyList(); 
		}
		return printHistory.get(employee);
	}
	
	public void printDocument(String document, Employee employee){
		System.out.println(document); 
		if (!printHistory.containsKey(employee)){
			printHistory.put(employee, new ArrayList<String>());
		}
		printHistory.get(employee).add(document); 
	}
	
}
