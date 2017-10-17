package objectstructures.Battleship;

import java.util.Scanner;

public class playBattleshipGame {

	private int turnCount;
	private int x;
	private int y;
	private Scanner input;

	public playBattleshipGame(int rows, int columns) {
		if (isValidRowCol(rows, columns)) {	
			playGame(rows, columns);
		}
		else {
			while (!isValidRowCol(rows, columns)) {
				System.out.println("Invalid input.");
				//......//
			}
		}
	}

	private void playGame(int rows, int columns) {

		BattleshipBoard board1 = new BattleshipBoard(rows, columns);
		BattleshipBoard board2 = new BattleshipBoard(rows, columns);
		input = new Scanner(System.in);

		while (!(board1.isGameOver() || board2.isGameOver())) {

			System.out.println("\nPlayer 1's board:");
			board1.showBoard();

			System.out.println("\nPlayer 2's board:");
			board2.showBoard();

			if (whosTurn()) {
				System.out.println("\nPlayer 1's turn: ");

				System.out.println("Enter x: ");
				this.x = input.nextInt();

				System.out.println("Enter y: ");
				this.y = input.nextInt();

				board1.fire(this.x, this.y);

			} else if (!whosTurn()) {
				System.out.println("\nPlayer 2's turn: ");

				System.out.println("Enter x: ");
				this.x = input.nextInt();

				System.out.println("Enter y: ");
				this.y = input.nextInt();

				board2.fire(this.x, this.y);
			}
			turnCount++;
		}

		if (board1.isGameOver()) {
			System.out.println("\n\nThe game is finished!\nThe winner is Player 1 with " + board1.hitCounter + " hits and "
					+ board1.missCounter + " misses");
			System.out.println("The loser is Player 2 with " + board2.hitCounter + " hits and "
					+ board2.missCounter + " misses");
			System.out.println("\nPlayer 1's final board:");
			board1.showBoard();

			System.out.println("\nPlayer 2's final board:");
			board2.showBoard();

		} else if (board2.isGameOver()) {
			System.out.println("\n\nThe game is finished!\nThe winner is Player 1 with " + board2.hitCounter + " hits and "
					+ board2.missCounter + " misses");
			System.out.println("The loser is Player 1 with " + board1.hitCounter + " hits and "
					+ board1.missCounter + " misses");
			System.out.println("\nPlayer 1's final board:");
			board1.showBoard();

			System.out.println("\nPlayer 2's final board:");
			board2.showBoard();

		}

	}

	//Keeps track of who's turn it is.
	private boolean whosTurn() {
		if ((turnCount & 1) == 0) {
			return true; // PLayer 1's turn
		} else {
			return false; // Player 2's turn
		}
	}

	private boolean isValidRowCol(int rows, int columns) {
		return true; //NEEDS TO EDIT THIS. SETTING IT TO TRUE TEMPORARILY.
	}
	
	public static void main(String[] args) {
		playBattleshipGame newGame = new playBattleshipGame(4,4); //String boards are already written, and are selected randomly.
	}

}
