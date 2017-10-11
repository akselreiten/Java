package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TimeSlot implements Comparable<TimeSlot>{

	private final int startMin;
	private final String description; 
	private final int duration;
	
	public TimeSlot(String description, int hours, int minutes, int duration){
		if (hours<0 || minutes <0){
			throw new IllegalArgumentException("hours and minutes must be positive"); 
		}
		this.description = description;
		this.duration = duration; 
		this.startMin = hours * 60 + minutes; 
	}
	
	public DayTime calculateTime(int minutes){
		int hours = minutes / 60; 
		int min = minutes - hours*60; 
		return new DayTime(hours,min);
	}
	
	public DayTime getStartTime(){
		return calculateTime(startMin);
	}
	
	public DayTime getEndTime(){
		return calculateTime(startMin+duration);
	}
	
	public String toString(){
		return description + "@" + getStartTime() + "-"+ getEndTime();
	}
	
	//if comparable
	
	
	
	public static void main(String[] args) {
		
		TimeSlot ts = new TimeSlot("TDT4100",10,15,105);
		System.out.println(ts);
		
		String text = "124153242"; 
		System.out.println(text.chars().allMatch(Character::isDigit));
		System.out.println('F'-'A');
		
		List<String> str = new ArrayList<String>(Arrays.asList("hei","Hei")); 
		
		/*Collections.sort(str, new Comparator<Integer>(){
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		System.out.println(str);
		*/
		
		String str1 = "hei"; 
		String str2 = "Hei";
		
		System.out.println(str1.compareTo(str2));
		
		str1.compareTo(str2);
		
		System.out.println(str);
		Collections.sort(str);
		System.out.println(str);
		
		
		
	}

	@Override
	public int compareTo(TimeSlot o) {
		return 0;
	}
}
