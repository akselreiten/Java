package interfaces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double>{

	Iterator<Double> iterator1, iterator2;
	BinaryOperator<Double> operator;
	Double default1, default2;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator){
		this.iterator1 = iterator1;
		this.iterator2 = iterator2; 
		this.operator = operator;
		default1 = default2 = null; 
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, 
			Double default1, Double default2, BinaryOperator<Double> operator){
		this.iterator1 = iterator1;
		this.iterator2 = iterator2; 
		this.operator = operator;
		this.default1 = default1;
		this.default2 = default2;
	}

	@Override
	public boolean hasNext() {
		return iterator1.hasNext() || iterator2.hasNext(); 
	}

	@Override
	public Double next() {
		/*if (iterator1.hasNext()){
			if (iterator2.hasNext()){
				return operator.apply(iterator1.next(), iterator2.next());
			} else {
				return operator.apply(iterator1.next(),default2);
			}
		} else {
			if (iterator2.hasNext()){
				return operator.apply(default1, iterator2.next());
			} else {
				return operator.apply(default1, default2);
			}
		}*/
		
		Double next1 = (iterator1.hasNext() ? iterator1.next() : default1);
		Double next2 = (iterator2.hasNext() ? iterator2.next() : default2); 
		return operator.apply(next1, next2);
	}
	
	public static void main(String[] args) {
		Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
		Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();
		BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, (x, y) -> x+y);
		
		System.out.println(binaryIterator.hasNext());
		System.out.println(binaryIterator.next());
		System.out.println(binaryIterator.hasNext());
		System.out.println(binaryIterator.next());
		System.out.println(binaryIterator.hasNext());
	}
	
}
