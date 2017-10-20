package main.java;

import java.util.Date;
import java.util.List;

public class Message {

	public String content; 
	public List<String> categories; 
	public boolean isSent; 
	public Date datelimit; // sets the date that the message has to be sent before
	
	public Message(String content, List<String> categories, Date datelimit) {
		this.content = content; 
		this.categories = categories;
		this.isSent = false;
		this.datelimit = datelimit;
	}
	
	public boolean hasBeenSent() {
		return isSent; 
	}
	
	public void setSentStatus(boolean bol) {
		if (bol) { this.isSent = true; }
	}
	
	public String getContent(){
		return content; 
	}
	
	public List<String> getCategories() {
		return categories; 
	}
	
	public Date getDatelimit() {
		return datelimit; 
	}
	
	@Override
	public String toString() {
		return "Content: " + getContent() + 
				"; Categories: " + getCategories() + "\n";
	}
	
}
