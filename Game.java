import java.util.Random;

import java.util.Scanner;

public class Game {

	static int moveCounter = 0;


	public static void main(String[] args) {
		
		int[][] theBoard = new int[4][4];

		Random newNum = new Random();

		Scanner scan = new Scanner(System.in);

		int numRows = 4;

		int numColumns = 4;

		int counter = 0;

		String movement = new String();

		String restart = new String();

		String quit = new String();

		for (int row = 0; row < theBoard.length; row++) {

			for (int col = 0; col < theBoard[row].length; col++) {

				theBoard[row][col] = 0;

			}

		}
		//create new variables to create randoms for the row and column location
		int x = newNum.nextInt(100) + 1;
		int y = newNum.nextInt(100) + 1;
		int randRow = newNum.nextInt(4);
		int randCol = newNum.nextInt(4);
		int randRow2 = newNum.nextInt(4);
		int randCol2 = newNum.nextInt(4);

		while (theBoard[randRow] == theBoard[randRow2] && theBoard[randCol] == theBoard[randCol2]) {

			randRow2 = newNum.nextInt(4);

			randCol2 = newNum.nextInt(4);

		}

		if (x < 80) {

			theBoard[randRow][randCol] = 2;

		} else {

			theBoard[randRow][randCol] = 4;

		}

		if (counter == 0) {

			if (y < 80) {

				theBoard[randRow2][randCol2] = 2;

			} else {

				theBoard[randRow2][randCol2] = 4;

			}

		}

		for (int row = 0; row < theBoard.length; row++) {

			for (int col = 0; col < theBoard[row].length; col++) {

				System.out.print(theBoard[row][col] + " ");

			}

			System.out.println(" ");

		}

		char typed;

		do {

			System.out.println("w = up; a = left; s = down; d = right; q = quit; r = restart: ");

			typed = scan.next().charAt(0);

			if (typed == 'w') {

				moveUp(theBoard);

			}

			else if (typed == 'a') {

				moveLeft(theBoard);

			}

			else if (typed == 's') {

				moveDown(theBoard);

			}

			else if (typed == 'd') {

				moveRight(theBoard);

			}

			else if (typed == 'r') {

				System.out.print("Are you sure? Enter r again to restart or w to keep playing: ");
				typed = scan.next().charAt(0);
				if (typed == 'r') {

					restart();
				}
			}

			else if (typed == 'q') {

				System.out.print("Are you sure? Enter q again to quit or w to keep playing: ");

				typed = scan.next().charAt(0);

				if (typed == 'q') {

					quit();

				}

			}

			else {

				System.out.println("That is not a valid input. Please enter w,a,s,d,r or q");

			}
			System.out.println("Number of moves made: "+moveCounter);
		} while (typed != 'q'); // Deleted r because this still needs to run when program restarts.

	}

	public static void newRandomNumber(int[][] board) {

		Random newNum = null;

		int a = newNum.nextInt(100) + 1;

		int b = newNum.nextInt(100) + 1;

		int randRow = newNum.nextInt(4);

		int randCol = newNum.nextInt(4);

		// we need to put this in some sort of loop to check every value of the array

		if (a < 80) {

			// we need to test if the randomly selected location is empty or not, else we
			// need to run again

			if (board[randRow][randCol] == 0) {

				board[randRow][randCol] = 2;

			}

		} else {

			if (board[randRow][randCol] == 0) {

				board[randRow][randCol] = 4;

			}

		}

		// print out the new board again

		for (int row = 0; row < board.length; row++) {

			for (int col = 0; col < board[row].length; col++) {

				System.out.print(board[row][col] + " ");

			}

			System.out.println(" ");

		}

	}

	public static void moveUp(int [][] theBoard) {

		System.out.println("up");

		// Need an if statement with a boolean here to check if move can happen

		for (int i = theBoard.length - 1; i > 0; i--) {

			for (int j = 0; j < theBoard.length; j++) {

				theBoard[i - 1][j] = theBoard[j][theBoard[i - 1][j] + theBoard[i][j]];

			}

		}

		moveCounter++;

	}

	public static void moveLeft(int [][] theBoard) {

		System.out.println("left");

		// Need an if statement with a boolean here to check if move can happen

		for (int i = 0; i > theBoard.length; i++) {

			for (int j = theBoard.length - 1; j > 0; j--) {

			}

		}

		moveCounter++;

	}

	public static void moveDown(int [][] theBoard) {

		System.out.println("down");

		// Need an if statement with a boolean here to check if move can happen

		for (int i = 0; i > theBoard.length - 1; i++) {

			for (int j = 0; j < theBoard.length; j++) {

			}

		}

		moveCounter++;

	}

	public static void moveRight(int [][] theBoard) {

		System.out.println("right");

		// Need an if statement with a boolean here to check if move can happen

		for (int i = 0; i > theBoard.length; i++) {

			for (int j = 0; j < theBoard.length - 1; j++) {

			}

		}

		moveCounter++;

	}

	public static void restart() {

		System.out.println("Restarting...");

		String[] argument = new String[] { "1,2,3" };

		Game.main(argument);

	}

	public static void quit() {

		System.out.println("game over. Moves made: " + moveCounter);

	}

}