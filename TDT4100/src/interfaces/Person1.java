package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person1 implements Named{

	String givenName, familyName; 
	
	public Person1(String givenName, String familyName){
		setFullName(givenName + " " + familyName);
	}
	
	public void checkIfWordAlphabetic(String word){
		
		for (int i=0; i<word.length();i++){
			if(Character.isWhitespace(word.charAt(i))){
				continue;
			}
			
			if(!Character.isAlphabetic(word.charAt(i))){
				throw new IllegalArgumentException(word + " is not alphabetic");
			}
		}
	}
	
	@Override
	public void setGivenName(String name) {
		 checkIfWordAlphabetic(name); 
		 this.givenName = name;
		 
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public void setFamilyName(String name) {
		checkIfWordAlphabetic(name);
		this.familyName = name; 
	}

	@Override
	public String getFamilyName() {
		return familyName; 
	}

	@Override
	public void setFullName(String name) {
		String[] split = name.split(" "); 
		setGivenName(split[0].trim()); 
		setFamilyName(split[1].trim());
	}

	@Override
	public String getFullName() {
		return givenName + " " + familyName;
	}
	
	public String toString(){
		return getFullName();
	}
	
	public static void main(String[] args) {
		Person1 halvor = new Person1("Halvor","Reiten");
		Person1 other = new Person1("Annen", "Person");
		Person2 marie = new Person2("Marie Nordal");
		
		List<Person1> list = Arrays.asList(halvor, other, new Person1("Marie","Nordal"));
		
		Collections.sort(list, new NamedComparator());
		System.out.println(list);
		
		List<Person1> list2; 
		list2 = new ArrayList<Person1>(Arrays.asList());
		list2.add(halvor);
	}
	
}
