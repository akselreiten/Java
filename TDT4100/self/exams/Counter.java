package exams;

public class Counter {

	private int count, max; 
	
	public Counter(int max){
		count = 0; 
		this.max=max; 
	}
	
	public int getCount(){
		return count; 
	}
	
	public void count(){
		if (count < max){
			count++;
		}
	}
	
	public boolean isMax(){
		return count >= max;
	}
	 
	
	public static void main(String[] args) {
		
		
	}
}
