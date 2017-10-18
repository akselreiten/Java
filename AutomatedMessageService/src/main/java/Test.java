package main.java;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

	// try to read in the file from the class path 
	
	//public File messagesFile = new File(getClass().getClassLoader().getResource("messages.txt").getFile());
	//public URL fileURL = this.getClass().getClassLoader().getResource("messages/messages.txt");
	
	public String readFileFromClasspath(String fileName) throws IOException, URISyntaxException {
	    return new String(Files.readAllBytes(
	                Paths.get(getClass().getClassLoader()
	                        .getResource(fileName)
	                        .toURI())));
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Test t = new Test(); 
		
		// method 1. absolute path, hardcoded. 
		String filepath = new File("").getAbsolutePath() + "/resources/messages.txt";
		System.out.println(filepath);
		
		ClassLoader classLoader = t.getClass().getClassLoader();
		InputStream in = t.getClass().getResourceAsStream("/text/messages.txt");
		System.out.println(in);
		
		//File file = new File(t.getClass().getResource("file/test.xml").getFile());
	}
	
}
