package exams;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Question {

	private String question, answer; 
	private List<String> options; 
	
	public Question(String question, String answer, String... options){
		this.question = question; 
		this.answer = answer; 
		this.options = new ArrayList<String>(Arrays.asList(options));
	}
	
	public static void main(String[] args) {
		List<String> opt = new ArrayList<String>();
		opt.add("ho"); opt.add("heu"); opt.add("fuck");
		
		List<String> newOpt;
		newOpt = new ArrayList<String>(opt);
		
		System.out.println(newOpt);
	}
	
}
