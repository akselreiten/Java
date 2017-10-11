package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee{

	private int resourceCount = 0, taskCount = 0; 
	private List<Employee> employees;
	
	public Manager(Collection<Employee> employees){
		if (employees.isEmpty()){
			throw new IllegalArgumentException(); 
		}
		this.employees = new ArrayList<Employee>(employees);
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return getEmployee().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String doc) {
		taskCount++;
		getEmployee().printDocument(doc);
	}

	@Override
	public int getTaskCount() {
		return 0;
	}

	@Override
	public int getResourceCount() {
		int sum = 0; 
		for (int i = 0; i < employees.size();i++){
			sum += employees.get(i).getResourceCount();
		}
		return sum;
	}
	
	public Employee getEmployee(){
		int num = 1000000;
		Employee chosen = null;
		for (Employee e : employees){
			if (e.getResourceCount() < num){
				num = e.getResourceCount(); 
				chosen = e;
			}
		}
		return chosen; 
	}
	
}
