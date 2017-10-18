package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Unit1Excercise {

	private static void printConditionally(List<Person> people, Predicate<Person> predicate){
		for (Person p : people){
			if (predicate.test(p)){
				System.out.print(p);
			}
		}
	}
	
	public static void main(String[] args) {
		Unit1Excercise u1 = new Unit1Excercise();
		List<Person> people = new ArrayList<Person>(); 
		people.add(new Person("Halvor","Reiten",40)); 
		people.add(new Person("Gudrun","Solo",24)); 
		people.add(new Person("Ingeborg","Drita",12)); 
		people.add(new Person("Fredrik","Tangen",91)); 
		people.add(new Person("Håkon","Drønnebekk",22)); 
		
		Predicate<Person> pr = (Person p) -> p.getAge()>18 && p.getFirstName().charAt(0)=='F';
		
		List<Person> filteredList = people.stream().filter((p) -> p.getAge()>18).collect(Collectors.toList());
		System.out.println(filteredList);
		
		
		//printConditionally(people, pr);
		//printConditionally(people, (Person p) -> p.getLastName().charAt(0) == 'R');
		
		//Step1, sort this list by last name: 
		/*Insted of Collections.sort(people, new Comparator<Person>(){ 
				compare(Person p1, Person p2){
					return p1.getLastName().compareTo(p2.getLastName();
				}
			});
			
		We can use lambda notation! 
		Comparator is actually a functional interface wiht its only method compare(p1, p2); 
			
		*/
		//No need to specify p1 and p2 type since it already knows that people contains Person. 
		
		Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		System.out.println(people);
		
		System.out.println("HEIHEIEHIEHIE");
		System.out.println(people.stream()
		.anyMatch((p) -> p.getFirstName().equals("Halvor")));

	}

}
