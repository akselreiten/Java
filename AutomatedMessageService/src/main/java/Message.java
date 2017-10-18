package main.java;

public class Message {

	private static int instanceCounter = 0; 
	public int counter = 0; 
	public String content; 
	public String category; 
	public boolean isSent; 
	
	public Message(String content, String category) {
		this.content = content; 
		this.category = category.toLowerCase(); 
		this.isSent = false;
		instanceCounter++; 
		counter = instanceCounter; 
	}
	
	public boolean hasBeenSent() {
		return isSent; 
	}
	
	public void setSendingStatus(boolean bol) {
		if (bol) { this.isSent = true; }
	}
	
	public int getInstanceCount() {
		return counter;
	}
	
	public String getContent(){
		return content; 
	}
	
	public String getCategory() {
		return category; 
	}
	
	
	@Override
	public String toString() {
		return "Message #" + getInstanceCount() +  
				"\nContent: " + getContent() + 
				", Category: " + getCategory() + "\n";
	}
	
}
