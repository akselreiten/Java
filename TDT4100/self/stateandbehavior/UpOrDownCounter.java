package stateandbehavior;

public class UpOrDownCounter {

	private int start;
	private int end; 
	private int counter; 
	
	public UpOrDownCounter(int start, int end) throws IllegalArgumentException {
		if (start == end) {
			throw new IllegalArgumentException("Start cannot be equal to end.");
		}
		this.start = start;
		this.end = end;
		counter = start; 
	}
	
	public int getCounter() {
		return counter;
	}
	
	boolean count() {
		if(counter < end) {
			counter++;
		}
		else {
			counter--;
		}
		
		if(counter == end) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		UpOrDownCounter timer1 = new UpOrDownCounter(0,5); 
		
		timer1.getCounter();
		timer1.count();
		
		for (int i = 0; i <= timer1.end; i++) {
			System.out.println(timer1.getCounter());
		}
		
	}
	
}
