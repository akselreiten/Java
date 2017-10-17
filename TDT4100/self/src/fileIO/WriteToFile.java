package fileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

public class WriteToFile {

	public static void writeToFile(String address) throws IOException{
		PrintWriter writer = new PrintWriter(new FileWriter(address));
		
		writer.println("Dette er den første linjen");
		writer.println("Dette er den andre linejn");
		writer.println("Tredje linjen, det er denne");
		writer.println("Å, hvor skal så dette ende");
		
		writer.close();
	}
	
	public static void writeToFile2(OutputStream out) throws IOException{
		PrintWriter writer = new PrintWriter(out);
		
		writer.println("Dette er den første linjen");
		writer.println("Dette er den andre linjen");
		writer.println("Tredje linjen, det er denne");
		writer.println("Å, hvor skal så dette ende");
		
		writer.close();
	}
	
	public static void readLinesFromFile(Reader in) throws IOException{
		Scanner scanner = new Scanner(in); 
		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			System.out.println(line);
		}
		
	}
	
	public static void readLinesFromFile2(InputStream in) throws IOException{
		Scanner scanner = new Scanner(in); 
		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			System.out.println(line);
		}
		
	}
	
	public static void readWordsFromFile(Reader in) throws IOException{
		Scanner scanner = new Scanner(in); 
		int counter = 0;
		while (scanner.hasNext()){
			if (counter == 5){
				counter = 0;
				System.out.println();
				continue;
			}
			
			String word = scanner.next() + " ";
			System.out.print(word);
			counter++;
		}
		
	}
	
	public static void lambdaReadLines(Reader in) throws IOException{
		
	}
	
	
	public static void main(String[] args) throws IOException {
		String address = new File("").getAbsolutePath() + "/src/fileIO/file.txt";
		
		Reader in = new FileReader(address);
		
		//writeToFile(address2);
		//writeToFile2(System.out);
		//readLinesFromFile(in);
		readWordsFromFile(in);
	}
	
}
