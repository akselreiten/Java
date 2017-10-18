package patterns.delegation.office;

import java.io.FileNotFoundException;
import java.util.function.BinaryOperator;

public class Clerk implements Employee{
	private int taskCount = 0; 
	private Printer printer; 
	
	public Clerk(Printer printer){
		this.printer = printer;
	}
	
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String doc) {
		taskCount++;
		printer.printDocument(doc, this);
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}

}
