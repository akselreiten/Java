package objectstructures.Sudoku;

public class SudokuCell {

	private int cellValue; 
	public boolean editable = true; 
	public boolean inConflict = false;
	
	public SudokuCell(int cellValue) {
		this.cellValue = cellValue; 
	}
	
	public int getCellValue() {
		return cellValue; 
	}
	
	public void setCellValue(int newCellValue) {
		if (editable == true) {
			this.cellValue = newCellValue; 
		}
	}
	
	/*private boolean isValidInput(int value) {
		if (value < 0 || value > 9 || editable == false) {
			return false; 
		}
		return true; 
			
	}*/
	
	public boolean isEditable() {
		return editable;
	}
	
	public boolean isInConflict() {
		return inConflict; 
	}
	
	public boolean setInConflict() {
		return inConflict = true; 
	}
	
}
