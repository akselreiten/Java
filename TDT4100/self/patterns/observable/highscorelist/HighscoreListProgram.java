package patterns.observable.highscorelist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener{

	HighscoreList hs; 
	
	public HighscoreListProgram(){
		init();
		run();
	}
	
	public void init(){
		hs = new HighscoreList(10);
		hs.addHighscoreListListener(this);
	}

	public void run(){
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.print("Register new result: ");
			int res = scanner.nextInt();
			try{
				hs.addResult(res);
			} catch (InputMismatchException e){
				System.out.printf("Program ended because of %s", e);
			} 
		}
	}
	
	@Override
	public void listChanged(HighscoreList list, int value) {
		System.out.println(value + " has been inserted in the highscore list.\nHs now looks like this: " + list);
	}
	
	public static void main(String[] args) {
		HighscoreListProgram p1 = new HighscoreListProgram();
	}
}
