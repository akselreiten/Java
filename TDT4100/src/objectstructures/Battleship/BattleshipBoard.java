package objectstructures.Battleship;

import java.util.Random;
import java.util.Scanner;

public class BattleshipBoard {

	private int rows;
	private int columns;
	private Cell[][] board;
	private String chosenBoard;
	private String exampleBoard1 = ".XXX.......XXX....X.........X.........X....XX...X.............X..XXX....X.........X.................";
	private String exampleBoard2 = ".XXX.......XXX....X.........X.........X....XX...X.............X..XXX....X.........X.................";
	private String exampleBoard3 = "................................XX.........XXX........XXXX.....XXX.....XXX.......XXX................";
	public int hitCounter;
	public int missCounter;
	private int x;
	private int y;
	private int countX;
	private Scanner sc;

	public BattleshipBoard(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		createBoard();
	}

	private void createBoard() {

		board = new Cell[this.rows][this.columns];
		chooseRandomBoard();

		int counter = 0;

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				char c = chosenBoard.charAt(counter);
				if (c == 'X') {
					board[i][j] = new Cell(1);
					countX++;
				} else if (c == '.') {
					board[i][j] = new Cell(0);
				}
				counter++;
			}
		}
	}

	public void showBoard() {

		for (int i = 0; i < this.rows; i++) {
			System.out.print("|");
			for (int j = 0; j < this.columns; j++) {
				if (board[i][j].getCellValue() == 0) {
					System.out.print(" ~");
				} else if (board[i][j].getCellValue() == 1) {
					System.out.print(" ~");
				} else if (board[i][j].getCellValue() == 2) {
					System.out.print(" O");
				} else if (board[i][j].getCellValue() == 3) {
					System.out.print(" X");
				}
			}
			System.out.print(" |\n");
		}

	}

	//This method is currently not needed
	private String chooseRandomBoard() {

		Random rand = new Random();
		int randomNumber = rand.nextInt(3) + 1;

		if (randomNumber == 1) {
			chosenBoard = exampleBoard1;
		} else if (randomNumber == 2) {
			chosenBoard = exampleBoard2;
		} else if (randomNumber == 3) {
			chosenBoard = exampleBoard3;
		}

		return chosenBoard;
	}

	public void retryShot(int x, int y) {
		sc = new Scanner(System.in);
		
		if (isValidInput(x, y)) {
			while (board[y][x].isAlreadyHit()) {
				System.out.println("____________________________________\nAlready shot at this coordinate!\nTry again:");
				System.out.println("Enter x: ");
				x = sc.nextInt();
	
				System.out.println("Enter y: ");
				y = sc.nextInt();
	
				x = x - 1;
				y = y - 1;
				
				if (isValidInput(x,y)) {
									
					if (board[y][x].isAlreadyHit()) {
						continue;
					} 
					else {
						this.x = x;
						this.y = y;
						break;
					}
				}
				else {
					System.out.println("____________________________________\nInvalid input. 0 < x < "+this.columns+", 0 < y < "+this.rows);
					continue; 
				}
			}
		}
		
		while (!isValidInput(x,y)) {
			System.out.println("____________________________________\nInvalid input. 0 < x < "+this.columns+", 0 < y < "+this.rows);
			System.out.println("Enter x: ");
			x = sc.nextInt();

			System.out.println("Enter y: ");
			y = sc.nextInt();
			
			x = x - 1; 
			y = y - 1;
			if (isValidInput(x,y)) {
				this.x = x; 
				this.y = y; 
				break; 
			}
		}
	}

	public void fire(int x, int y) {

		this.x = x - 1;
		this.y = y - 1;
		
		if (!isValidInput(this.x, this.y)) {
			retryShot(this.x, this.y);
		}
		
			if (board[this.y][this.x].isAlreadyHit()) {
				retryShot(this.x, this.y);
			}
	
			if (board[this.y][this.x].isOcean()) {
				System.out.println("___________________________\nYou MISSED at coordinate ("+x+","+y+")\n___________________________");
				board[this.y][this.x].setValue(2);
				missCounter++;
			} else if (board[this.y][this.x].isShip()) {
				System.out.println("---------------------------\nYou HIT at coordinate ("+x+","+y+")\n---------------------------");
				board[this.y][this.x].setValue(3);
				hitCounter++;
			}
		}

	public boolean isGameOver() {
		return hitCounter == countX;

	}

	private boolean isValidInput(int x, int y) {
		return (x >= 0 && y >= 0 && x < this.columns && y < this.rows);
	}
}