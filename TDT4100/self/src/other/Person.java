package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Person implements Iterator{
	private String firstName, lastName; 
	private int age;
	private List<Person> people = new ArrayList<Person>(); 
	
	public Person(String firstName, String lastName, int age){
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.age = age; 
	}
	
	public String getFirstName(){
		return firstName; 
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String toString(){
		return ("\nPerson ["+firstName+" "+lastName+", "+age+" years old]"); 
	}
	
	public int getResult(int rowNum, int[] draw){
		int count = 0; 
		
		switch(rowNum){
		case 7: return 1;  
		case 6: return 2; 
		case 5: return 3;
		}
		
		return 0; 
		
	}
	
	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(new Person("Halvor","Reiten",90),new Person("Anne","Remmen",40),new Person("Heidi","Blankholm",60)));
		Collections.sort(people, (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		System.out.println(people);
		
		Person halvor = new Person("Halvor","Reiten", 22);
		int[] s = {1,2,3,4};
		System.out.println(halvor.getResult(6, s));
		
		Random randInt = new Random(); 
		System.out.println(randInt.nextInt(34));
		System.out.println(2.5%2);
		
	}

	@Override
	public boolean hasNext() {
		return people.iterator().hasNext();
	}

	@Override
	public Person next() {
		if (hasNext()){
			return people.iterator().next();
		}
		return null;
	}

	
}
