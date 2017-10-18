package objectstructures.Sudoku;

import java.util.Stack;

public class SudokuAction {

	private int x;
	public int y;
	public int newValue; 
	
	
	
	public SudokuAction(int x, int y, int newValue) {
			this.x = x; 
			this.y = y; 
			this.newValue = newValue; 
	}



	public int getX() {
		return x;
	}

	public void setValues(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y; 
	}
	
	public int getNewValue() {
		return newValue; 
	}
	
	
	
}//end class
