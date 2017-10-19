package main.java;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MessageProgram implements MessageListener {

	public String messagesFilepath; // the absolute path of a text file with messages
	public String recipient; // the phone number or email of the recipient
	public List<Message> messages; // A list containing all message object
	
	public MessageProgram(String messagesFilepath, String recipient){		
		this.messagesFilepath = messagesFilepath;
		this.recipient = recipient;
		
		try {
			this.messages = readMessagesFromFile(messagesFilepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// get list with all messages
	public List<Message> getAllMessages(){
		return messages; 
	}
	
	// get list of all unsent messages
	public List<Message> getUnsentMessages(){
		return messages.stream()
				.filter(mess -> !mess.hasBeenSent())
				.collect(Collectors.toList());	
	}
	
	// get a list of filtered messages based on isSent and category
	// if category.equals(""), then all categories will be returned
	public List<Message> getFilteredMessages(boolean isSent, String category){
		return messages.stream()
				.filter(mess -> mess.hasBeenSent() == isSent)
				.filter(mess -> category.equals("") ? true : mess.getCategory().equals(category) 
						|| mess.getCategory().equals("all"))
				.collect(Collectors.toList());	
	}
	
	// returns a random, unsent message with given category
	// if category.equals(""), then all categories are evaluated
	public Message getRandomUnsentMessage(String category){
		List<Message> arr = getFilteredMessages(false,category);
		if (arr.size() > 0) {
			int randomint = new Random().nextInt(arr.size());
			return arr.get(randomint);
		} else {
			return null;
		}
	}
	
	// read in the messages from file, make messages objects and add them to messages list
	public List<Message> readMessagesFromFile(String filepath) throws FileNotFoundException {
		List<Message> messages = new ArrayList<Message>();
		Scanner scanner = new Scanner(new FileReader(filepath));
		
		while (scanner.hasNextLine()) {
			// messages has format: "MESSAGE","CATEGORY", "ISSENT"
			String line = scanner.nextLine();
			if (line.length() > 0) {
				List<String> arr = splitString(line,",",true);
				
				String content = arr.get(0).substring(1,arr.get(0).length()-1);
				String category = arr.get(1);
				boolean isSent = Boolean.parseBoolean(arr.get(2));
				
				Message tempMessage = new Message(content, category); 
				tempMessage.setSentStatus(isSent);
				messages.add(tempMessage);
			}
		}
		
		scanner.close();
		return messages;
	}
	
	// write messages objects to file
	public void writeMessagesToFile(List<Message> messages) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(messagesFilepath, false), "UTF-8"));
		for (Message m : messages) {
			// write the message to file
			String mString = "\"" + m.getContent() + "\", " + m.getCategory() + ", " + Boolean.toString(m.hasBeenSent());
			writer.write(mString);
			writer.newLine();
		}
		writer.close();
	}
	
	// add message to the messages list
	public void addMessage(Message message) {
		if (!messages.contains(message)) {
			messages.add(message);
			
			messageHasChanged(message);
		}
	}
	
	// remove message from messages list
	public void removeMessage(Message message) {
		if (messages.contains(message)) {
			messages.remove(message); 
			
			messageHasChanged(message); 
		}
	}
	
	// send a message via iMessage to recipient
	public void sendMessage(Message message, String recipient) {
		String script = "tell app \"Messages\"\n" + 
                "set iMessageService to 1st service whose service type = iMessage\n" +
                "set iMessageBuddy to buddy \"" + recipient + "\" of iMessageService\n" + 
                "send \"" + message.getContent() + "\" to iMessageBuddy\n" +
                "end tell";
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("AppleScriptEngine");
		
		try {
			engine.eval(script);
			message.setSentStatus(true);
			
			messageHasChanged(message); 
		} catch (ScriptException err) {
			err.printStackTrace();
		}
	}
	
	
	@Override
	// method to update the messages whenever there is a change to a message
	public void messageHasChanged(Message message) {
		
		// update the textfile containing messages
		try {
			writeMessagesToFile(messages);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> splitString (String text, String seperator, boolean inQuotes){

		String splitRegex = seperator; 
		
		// split on the comma only if that comma has zero, or an even number of quotes ahead of it.
		if (inQuotes && seperator == ",") {
			splitRegex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
		}
		
		List<String> tokens = Arrays.asList(text.split(splitRegex, -1)); 
		List<String> tokens_trimmed = new ArrayList<String>(); 
		for (int i = 0; i < tokens.size(); i++) {
			tokens_trimmed.add(tokens.get(i).trim()); 
		}
		
		return tokens_trimmed; 
	}

	
	public void run() {
		// find out what time it is of the day and set category accordingly
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String currCategory = (hour <= 10 ? "morning" : (hour <= 17 ? "midday" : "night"));
		
		// find random new message and send to recipient
		Message messageToBeSent = this.getRandomUnsentMessage(currCategory);
		if (!(messageToBeSent == null)) {
			sendMessage(messageToBeSent, recipient);
		} else {
			System.err.println("All messages of category \"" + currCategory + "\" and \"all\" have been sent already.");
		}
	}
	
	public static void main(String[] args) throws IOException {
		String path = "/Users/halvorreiten/Documents/Programming/Java/AutomatedMessageService/src/main/resources/messages.txt";
		String recipient = "ha.reiten@gmail.com";
		MessageProgram mp = new MessageProgram(path, recipient);
		
		mp.run();
		
	}
}
