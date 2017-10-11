package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class FileManager2 {

	public static char[] readChars(String address) {
		Reader reader = null; //Leser chars
		char[] buffer = null;
		
		try {
			reader = new FileReader(new File(address)); 
			buffer = new char[1000];
			int charCount = reader.read(buffer);
		} catch (FileNotFoundException e1) {
			System.err.println("Fant ikke filen..");
		} catch (IOException e2) {
			System.err.println("Error skjedde ved lesing fra fil.");
		} finally {
			try {
				reader.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
		return buffer;
	}
	
	public static void writeChars(char[] content, String address) throws IOException {
		FileWriter writer = new FileWriter(new File(address));
		writer.write(content);
		writer.flush();//Viktig å ta med. Forsikre oss om at all data i bufferet content skrives til fil 
		writer.close(); 
		
	}
	
	public static void main(String[] args) throws IOException {
		String poemPath = new File("").getAbsolutePath(); 
		poemPath += "/src/of9/file.txt"; 
		char[] buffer = readChars(poemPath); 
		
		
		//for (int i = 0; i < buffer.length; i++) {
		//	System.out.println(buffer[i]);
		//}
		
		String poem = String.valueOf(buffer);
		System.out.println(poem);
		
		String newPoemPath = new File("").getAbsolutePath();
		newPoemPath += "/src/of9/newPoem.txt";
		String newPoem = "Hei Sveis"; 
		char[] content = newPoem.toCharArray(); 
		writeChars(content, newPoemPath);
		
	}
		
}
