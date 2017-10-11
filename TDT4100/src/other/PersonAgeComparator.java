package other;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

	public int compare(Person o1, Person o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
