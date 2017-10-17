package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
	List<Person> people = new ArrayList<Person>(); 
	people.add(new Person("Halvor","Reiten",40)); 
	people.add(new Person("Gudrun","Colo",24)); 
	people.add(new Person("Ingeborg","Crita",12)); 
	people.add(new Person("Fredrik","Cangen",91)); 
	people.add(new Person("Håkon","Drønnebekk",22));
	
	List<Person> cPeople = people.stream()
			.filter((p) -> p.getLastName().startsWith("C"))
			.collect(Collectors.toList());
	
	Collections.sort(cPeople, (p1,p2) -> p1.getAge() - p2.getAge());
	cPeople.stream().forEach((p) -> System.out.println(p));
	
	//System.out.println(people.stream().anyMatch((p) -> p.getFirstName().equals("Halvor")));
	
	
	//.forEach((p) -> System.out.println(p.getAge()));
	
	
	}
}