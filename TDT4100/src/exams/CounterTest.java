package exams;

import junit.framework.TestCase;

public class CounterTest extends TestCase {
	
	public void testConstructor() {
		
		Counter counter = new Counter(5);
		
		assertEquals(counter.getCount(),0); 
		assertEquals(counter.isMax(),false);
	}
	
	public void testGetCount() {
		Counter counter = new Counter(10);
		int i; 
		
		for (i=0; i<10; i++){
			assertEquals(counter.getCount(),i);
			counter.count();
		}
		i++;
		counter.count();
		assertFalse(counter.getCount() == i);
	}
	
}
