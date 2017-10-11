package interfaces;

public class Person2 extends Person1{

	public Person2(String fullName) {
		super(fullName.split(" ")[0].trim(),fullName.split(" ")[1].trim());
	}
	
}
