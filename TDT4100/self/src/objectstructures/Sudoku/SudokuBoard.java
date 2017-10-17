package objectstructures.Sudoku;

public class SudokuBoard {

	private String strBoard;
	SudokuCell[][] board = new SudokuCell[9][9];
	String newChars=""; 

	public SudokuBoard(String strBoard) {
		if (strBoard.length() == 81) {
			this.strBoard = strBoard;
			createBoard(newChars);
		} else {
			throw new IllegalArgumentException("StringBoard needs to be 9*9 characters long");
		}
	}

	void createBoard(String newChars) {
		int counter = 0; 
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = strBoard.charAt(counter);

				if (c == '.') {
					board[i][j] = new SudokuCell(0);
				} else {
					int charToInt = Character.getNumericValue(c);
					board[i][j] = new SudokuCell(charToInt);
					
					board[i][j].editable = false;
				}
				counter++;
			}
		}
		
		
		if (!(newChars.isEmpty())) {
			int counter2 = 0; 
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					char c = newChars.charAt(counter2);

					if (!(c == '.')) {
						int charToInt = Character.getNumericValue(c);
						board[i][j] = new SudokuCell(charToInt);
					}
					counter2++;
				}
			}
		}
	}

	public String showBoard() {
		
		String outStr = "";
		outStr += ("y\t+-----------------------+-----------------------+------------------------+ \n");
		for (int i = 0; i < 9; i++) {
			outStr += (i + "\t|");

			for (int j = 0; j < 9; j++) {
				if (j == 3 || j == 6) {
					outStr += ('|');
				}
				if (board[i][j].getCellValue() == 0) {
					outStr += (" ~\t");
				} else {
					if (board[i][j].isEditable()) {
						if (board[i][j].isInConflict()) {
							outStr += (" " + board[i][j].getCellValue() + "*\t");
						}
						else {
							outStr += (" " + board[i][j].getCellValue() + "\t");
						}
					} else {
						outStr += (" (" + board[i][j].getCellValue() + ")\t");
					}
				}
			}
			outStr += (" | \n");
			if (i == 2 || i == 5) {
				outStr += ("\t+-----------------------+-----------------------+------------------------+ \n");
			}
		}
		outStr += ("\t+-----------------------+-----------------------+------------------------+ \n");
		outStr += ("x-->\t 0\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8 \n");
		
		return outStr;
	}
	
	public String findNewBoardString() {
		String newBoardString = "";
		for (int i = 0; i<9; i++) {
			for (int j = 0; j<9; j++) {
				if(board[i][j].getCellValue() == 0) {
					newBoardString += "."; 
				} else if (board[i][j].getCellValue() > 0) {
					newBoardString += board[i][j].getCellValue(); 
				}
			}
		}
		return newBoardString;
	}
	
	public int getCellValue(int i, int j) {
		return board[i][j].getCellValue();
	}

	public void insertCellValue(int x, int y, int newValue) {
		if (board[y][x].isEditable()) {
			board[y][x].setCellValue(newValue);
			checkIfConflict(x, y, newValue);
			updateConflictsOnBoard();
		}
	}

	public void updateConflictsOnBoard() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				int value = board[i][j].getCellValue();
				checkIfConflict(j, i, value);
				}
			}
	}
	
	private void checkIfConflict(int x, int y, int value) {

		board[y][x].inConflict = false; 
		
		// check rows
		for (int j = 0; j < 9; j++) {
			if (j == x) {
				continue;
			}
			if (board[y][j].getCellValue()==value) {
				board[y][x].inConflict = true;
				break;
			}
		}

		// check columns
		for (int i = 0; i < 9; i++) {
			if (i == y) {
				continue;
			}
			if (board[i][x].getCellValue()==value) {
				board[y][x].inConflict = true;
				break;
			}
		}

		// check inner 3x3 square
		if (x >= 0 && x < 3 && y >= 0 && y < 3) {
			int ylowLimit = 0;
			int yhighLimit = 3;
			int xlowLimit = 0;
			int xhighLimit = 3;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 3 && x < 6 && y >= 0 && y < 3) {
			int ylowLimit = 0;
			int yhighLimit = 3;
			int xlowLimit = 3;
			int xhighLimit = 6;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 6 && x < 9 && y >= 0 && y < 3) {
			int ylowLimit = 0;
			int yhighLimit = 3;
			int xlowLimit = 6;
			int xhighLimit = 9;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 0 && x < 3 && y >= 3 && y < 6) {
			int ylowLimit = 3;
			int yhighLimit = 6;
			int xlowLimit = 0;
			int xhighLimit = 3;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 0 && x < 3 && y >= 6 && y < 9) {
			int ylowLimit = 6;
			int yhighLimit = 9;
			int xlowLimit = 0;
			int xhighLimit = 3;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 3 && x < 6 && y >= 3 && y < 6) {
			int ylowLimit = 3;
			int yhighLimit = 6;
			int xlowLimit = 3;
			int xhighLimit = 6;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 3 && x < 6 && y >= 6 && y < 9) {
			int ylowLimit = 3;
			int yhighLimit = 6;
			int xlowLimit = 3;
			int xhighLimit = 6;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 6 && x < 9 && y >= 3 && y < 6) {
			int ylowLimit = 3;
			int yhighLimit = 6;
			int xlowLimit = 6;
			int xhighLimit = 9;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		} else if (x >= 6 && x < 9 && y >= 6 && y < 9){
			int ylowLimit = 6;
			int yhighLimit = 9;
			int xlowLimit = 6;
			int xhighLimit = 9;

			for (int i = ylowLimit; i < yhighLimit; i++) {
				for (int j = xlowLimit; j < xhighLimit; j++) {
					if (i == y && j == x) {
						continue;
					}
					if (board[i][j].getCellValue()==value) {
						board[y][x].inConflict = true;
						break;
					}
				}
			}
		}
	}	
}
