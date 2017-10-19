package main.java;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class JSONwriter {
	
	public String path; 
	public List<Message> messages = new ArrayList<Message>();
	
	public JSONwriter(String path){		
		this.path = path;
		Message m1 = new Message("Test 1", Arrays.asList("morning", "night"), new Date());
		Message m2 = new Message("Test 2", Arrays.asList("morning"), new Date());
		messages.add(m1); messages.add(m2);
	}
	
	public List<Message> readJSON() throws IOException {
		JsonReader reader = new JsonReader(new FileReader(path)); 
		Message[] arr = new Gson().fromJson(reader, Message[].class);
		reader.close();
		
		return Arrays.asList(arr);
	}
	
	public void writeJSON() throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(path, false), "UTF-8"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		gson.toJson(messages, writer);
		
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		String path = "/Users/halvorreiten/Documents/Programming/Java/AutomatedMessageService/src/main/resources/messagesTEST.json";
		
		JSONwriter mpj = new JSONwriter(path);
		
		//System.out.println(mpj.readJSON());
		mpj.writeJSON();
		
		
		Gson gson = new GsonBuilder().create(); 
		gson.toJson("Hello", System.out);
		
		
	}


	
	
}
