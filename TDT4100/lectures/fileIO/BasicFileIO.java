package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasicFileIO {
	
	public BasicFileIO(){
		
	}
	
	public void write(PrintWriter writer) throws IOException{
		String text = "Halvor Reiten\n 23 år\n\nMarie Nordal\n 2 år\n\nEndre Aspen\n 35 år";
		writer.println(text);
		writer.close();
	}
	
	public void read(File file) throws IOException {
		Scanner scanner = new Scanner(file);
		int num = 0;
		while (scanner.hasNextLine()){
			String line1 = scanner.nextLine();
			if (line1.isEmpty()){
				continue;
			}
			String[] split1 = line1.split(" ");
			String firstName = split1[0]; String lastName = split1[1];
			String line2 = scanner.nextLine();
			String a = line2.substring(0,line2.indexOf("å")).trim();
			int age = Integer.parseInt(a);
			
			System.out.printf("First name: %s\nLast name: %s\nAge: %d\n\n", firstName, lastName, age);
			
		}
		scanner.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BasicFileIO obj = new BasicFileIO(); 
		File file = new File("JavaTest.txt");
		obj.write(new PrintWriter(file));
		obj.read(file);
	}
	
}
