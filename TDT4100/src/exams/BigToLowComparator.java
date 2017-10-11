package exams;

import java.util.Comparator;

public class BigToLowComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer int1, Integer int2) {
		return -int1.compareTo(int2);
	}
	
}
