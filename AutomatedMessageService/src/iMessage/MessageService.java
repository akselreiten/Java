package iMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MessageService implements MessageListener{

	public String filepath; 
	public List<Message> messages; 
	
	public MessageService(String filepath){
		this.filepath = filepath; 
		
		try {
			messages = readMessagesFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// returns a list with the message-objects
	public List<Message> getMessages(){
		return messages; 
	}
	
	// returns all messages that have been sent
	public List<Message> getSentMessages(){
		return messages.stream()
				.filter(mess -> mess.hasBeenSent())
				.collect(Collectors.toList());	
	}
	
	// returns all messages that haven't been sent yet
	public List<Message> getUnsentMessages(){
		return messages.stream()
				.filter(mess -> !mess.hasBeenSent())
				.collect(Collectors.toList());	
	}
	
	public void addMessage(Message message) {
		if (!messages.contains(message)) {
			messages.add(message);
			messageHasChanged(message);
		}
	}
	
	public void removeMessage(Message message) {
		if (messages.contains(message)) {
			messages.remove(message);
			messageHasChanged(message);
		}
	}
	
	// returns a random, unsent message
	public Message getRandomUnsentMessage(String category){
		List<Message> unsentMessages = getUnsentMessages(); 
		if (unsentMessages.size() < 1) {
			return null; 
		}
		
		if (!category.equals("")) {
			unsentMessages = unsentMessages.stream()
					.filter(message -> message.getCategory().equals(category))
					.collect(Collectors.toList()); 
		}
		return unsentMessages.get(new Random().nextInt(unsentMessages.size()));
	}
	
	// read messages from file and make new Message-objects for each line
	public List<Message> readMessagesFromFile() throws FileNotFoundException {
		List<Message> messages = new ArrayList<Message>();
		
		Reader in = new FileReader(filepath);
		Scanner scanner = new Scanner(in); 
		
		while (scanner.hasNextLine()) {
			// messages has format: "MESSAGE","CATEGORY", "isSent"
			String line = scanner.nextLine();
			List<String> arr = splitString(line,",",true);
			
			String content = arr.get(0).substring(1,arr.get(0).length()-1);
			String category = arr.get(1);
			boolean isSent = Boolean.parseBoolean(arr.get(2));
			
			Message tempMessage = new Message(content, category); 
			tempMessage.setSendingStatus(isSent);
			messages.add(tempMessage);
		}
		
		scanner.close();
		return messages;
	}
	
	
	// send the message using iMessage (Apples Messages app) to recipient
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
			message.isSent = true;
			messageHasChanged(message); 
		} catch (ScriptException err) {
			err.printStackTrace();
		}
		
	}
	
	
	// whenever a message changes, then call this method to make sure that
	// the file is up to speed with the changes that's been made. 
	@Override
	public void messageHasChanged(Message message) {
		
		if (messages.contains(message)) {			
			List<String> fileContent;
			try {
				fileContent = new ArrayList<>(Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8));
				int messageIndex = messages.indexOf(message); 
				String messageString = "\"" + message.getContent() + "\", " + message.getCategory() + ", " + Boolean.toString(message.hasBeenSent()); 
				fileContent.set(messageIndex, messageString);
				
				Files.write(Paths.get(filepath), fileContent, StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			// then the message has to be removed from the file
		}
	}
	
	// returns tokenized string, split by "seperator" and whether or not everything within
	// two double quotes should be counted as one token.
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
		Message messageToBeSent = getRandomUnsentMessage(""); 
		if (!(messageToBeSent == null)) {
			sendMessage(messageToBeSent, "ha.reiten@gmail.com");
		} else {
			System.out.println("No more messages to send");
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String messagesPath = new File("").getAbsolutePath() + "/messages/messages.txt";
		
		MessageService ms = new MessageService(messagesPath);
		
		ms.run();
		
	}
	
}
