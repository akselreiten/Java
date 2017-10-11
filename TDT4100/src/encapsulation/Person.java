package encapsulation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Person {

	private String fullName, firstName, lastName, email;
	private char gender; 
	
	public Person(){
	}
	
	/*public Person(String fullName, String email, Date birthday, char gender) throws IllegalArgumentException{
		if (isNameValid(fullName) && isEmailValid(email) && isGenderValid(gender)) {
			this.fullName = fullName;
			this.email = email;
			this.gender = gender; 
		}
		else {
			throw new IllegalArgumentException("Wrong, try again");
		}
	} */
	
	private boolean isNameValid(String fullName) {
		String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
		
		for (int i = 0; i < specialChars.length(); i++){
		    String c = "" + specialChars.charAt(i);  
		    if (fullName.contains(c)){
		    	return false; 
		    }
		}
		
		if (fullName.contains(" ")) {
			String parts[] = fullName.split(" ");
			if (parts.length > 2){
				return false; 
			}
			
			firstName = parts[0];
			lastName = parts[1];
			
			if (firstName.length() >= 2 && lastName.length() >= 2) {
				return true; 
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private boolean isEmailValid(String email) {
		
		//List<String> validCountryCode = Arrays.asList("af", "no", "us");
		List<String> validCountryCode = Arrays.asList("ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"); 
		
		String emailSplit[] = email.split("@");
		String emailSplitFirst[] = emailSplit[0].split(Pattern.quote("."));
		String emailSplitLast[] = emailSplit[1].split(Pattern.quote("."));
		
		if (emailSplitFirst.length == 2 && emailSplitLast.length == 2 && email.contains("@")) {
	
			for (int i=0; i<validCountryCode.size(); i++){
				if (emailSplitLast[1].equals(validCountryCode.get(i))){
					if (emailSplitFirst[0].equals(firstName.toLowerCase())	&& emailSplitFirst[1].equals(lastName.toLowerCase())) {
						return true;
					}; 
				}
			}
		}
		return false;
	}
	
	private boolean isGenderValid(char gender) {
		if(gender == 'M' || gender == 'F' || gender == '\0'){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setName(String fullName) {
		if (!isNameValid(fullName)) {
			throw new IllegalArgumentException("Illegal name.");
		}
		
		this.fullName = fullName; 
	}
	
	public void setEmail(String email) {
		if (!isEmailValid(email)) {
			throw new IllegalArgumentException("Not valid email. Try again.");
		}
		
		this.email = email;
	}
	
	public void setGender(char gender) {
		if (!isGenderValid(gender)) {
			throw new IllegalArgumentException("Illegal gender.");
		}
		
		this.gender = gender;
	}
	
	public String getName() {
		return fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public char getGender(){
		return gender; 
	}
	
	public static void main(String[] args) {
		
		/*String email = "halvor.reiten@teknologiporten.no";
		
		String emailSplit[] = email.split("@");
		String emailSplitFirst[] = emailSplit[0].split(Pattern.quote("."));
		String emailSplitLast[] = emailSplit[1].split(Pattern.quote("."));
		
		Person person = new Person(); 
		person.setGender('M');
		person.setName("Halvor Reiten");
		System.out.println(person.getName());
		person.setEmail("halvor.reiten@ntnu.no");
		
		System.out.println(person.getEmail());
		
		System.out.println(person.email); */
		
		List<Character> validGrades = Arrays.asList('A','B','C');
		List<String> validGrades2 = new ArrayList<String>();
		
		int year = 2; 
		char c = 'F'; 
		char d = 'E';
		
		System.out.println(c > d);
		System.out.println("java" + "eksamen");
		
		String a = String.valueOf(c); 
		String C = "F2016";
		String yar = C.substring(1,C.length());
		int foo = Integer.parseInt(yar);
		int foo1 = Integer.parseInt("1");
		
		System.out.println(C.charAt(0));
		System.out.println(foo1);
		
		
	}
	
}

