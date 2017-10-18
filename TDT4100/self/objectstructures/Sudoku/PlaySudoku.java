package objectstructures.Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.Stack;

public class PlaySudoku {

	private String strBoard = ".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....";
	private SudokuBoard game = new SudokuBoard(strBoard);
	Stack<SudokuAction> redoStack = new Stack<SudokuAction>(); 
	Stack<SudokuAction> undoStack = new Stack<SudokuAction>(); 
	Stack<SudokuIntValue> prevValuesStack = new Stack<SudokuIntValue>(); 
	private Scanner input;
	private int counter; 
	String address = new File("").getAbsolutePath() + "/src/objectstructures/sudokuGame.txt";
	
	public PlaySudoku(String strBoard) throws FileNotFoundException {
		this.strBoard = strBoard; 
		playSudoku();
	}
	
	public void playSudoku() throws FileNotFoundException {
		input = new Scanner(System.in);
		System.out.println("Do you wish to load an existing game, or do you want to start a new game? Type Load or New.");
		String text = input.next(); 
		
		if (text.equals("Load")) {
			loadGame();
			game.updateConflictsOnBoard();
		}
		
		System.out.println(game.showBoard());
		
		while (!isGameOver()) {
			clearConsole();
			
			System.out.println("--Write a new coordinate--");
			System.out.println("Enter x: ");
			int x = input.nextInt();

			System.out.println("Enter y: ");
			int y = input.nextInt();
			
			System.out.println("Enter new Value: ");
			int newValue = input.nextInt();
			
			//Save the previous value in a stack as an object
			int prevValue = game.getCellValue(y, x);
			SudokuIntValue a = new SudokuIntValue(prevValue); 
			prevValuesStack.push(a);
			
			//Save the last action 
			SudokuAction lastAction = new SudokuAction(x, y, newValue); 
			undoStack.add(lastAction);
			
			
			game.insertCellValue(x, y,newValue); 
			System.out.println(game.showBoard());
			
			text = "test"; 
			
			while (!(text.equals("c"))) {
			
				System.out.println("Undo (u), Redo (r), Save (s), Load (l) or Continue (c)? Write either.");
				text = input.next(); 
					
				if (text.equals("u")) {
					undo(); 
				} else if (text.equals("r")){
					redo(); 
				} else if (text.equals("s")){
					saveGame();
					System.out.println("\n\nSHIT BROR DEN BLE SAVET BRO!\n");
				} else if (text.equals("l")){
					loadGame(); 
					System.out.println("\nSHIT DEN FILEN BLE BLÆSTA BROR, LOADING OVERLOAD!");
				}
				System.out.println(game.showBoard());
			}
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
		
	public void getInput(String input) {
		
	}
	
	private boolean isGameOver() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (game.board[i][j].inConflict || game.getCellValue(i, j) == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void undo() {
		if (!(undoStack.empty())) {
			SudokuAction lastElement = undoStack.pop();
			//Legg til i redo-stacken. 
			redoStack.push(lastElement); 
			
			//make changes
			int x = lastElement.getX(); 
			int y = lastElement.getY(); 
			
			int newValue = prevValuesStack.pop().getValue(); 
			
			game.insertCellValue(x, y,newValue); 
			
		} else {
			System.out.println("\n\nNothing to undo\n\n");
			return; 
		}
	}
	
	private void redo() {
		if (!(redoStack.empty())) {
			SudokuAction lastElement = redoStack.pop();
			undoStack.push(lastElement); 
			
			int x = lastElement.getX(); 
			int y = lastElement.getY(); 
			int newValue = lastElement.getNewValue(); 
			
			int prevValue = game.getCellValue(y, x);
			SudokuIntValue a = new SudokuIntValue(prevValue); 
			prevValuesStack.push(a);
			
			game.insertCellValue(x, y,newValue);
			
		} else {
			System.out.println("\n\nNothing to redo");
			return; 
		}
	}
	
	private void saveGame() throws FileNotFoundException {
				
		PrintWriter writer = new PrintWriter(address);
		writer.println(game.findNewBoardString());
		writer.flush();
		writer.close();
	}
	
	public void loadGame() throws FileNotFoundException {
		
		String newBoardString = "";
		Scanner boardInput = new Scanner(new FileReader(address));
		
		while (boardInput.hasNext()) {
			newBoardString += boardInput.next();
		}
		boardInput.close();
		
		String newChars = ""; 
		for (int i = 0; i < newBoardString.length(); i++) {
			
			char a = newBoardString.charAt(i); 
			char b = strBoard.charAt(i); 
			
			if (!(a == b)) {
				newChars += newBoardString.charAt(i); 
			} else {
				newChars += "."; 
			}
			
		}
		
		game.createBoard(newChars);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		PlaySudoku newgame = new PlaySudoku(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8....."); 
		
		
	}
}
