import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	// create a static int to increment the number of moves throughout
	static int moveCounter = 0;

	// main method
	public static void main(String[] args) {
		// create the board and set the dimensions to 4x4
		int[][] theBoard = new int[4][4];
		Random newNum = new Random();
		Scanner scan = new Scanner(System.in);
		int counter = 0;

		// set the board to all 0's to begin with
		for (int row = 0; row < theBoard.length; row++) {
			for (int col = 0; col < theBoard[row].length; col++) {
				theBoard[row][col] = 0;
			}
		}
		// create new variables to create randoms for the row and column location
		int x = newNum.nextInt(100) + 1;
		int y = newNum.nextInt(100) + 1;
		int randRow = newNum.nextInt(4);
		int randCol = newNum.nextInt(4);
		int randRow2 = newNum.nextInt(4);
		int randCol2 = newNum.nextInt(4);
		// run while the random rows are not the same in case the random location is the
		// same
		while (theBoard[randRow] == theBoard[randRow2] && theBoard[randCol] == theBoard[randCol2]) {
			randRow2 = newNum.nextInt(4);
			randCol2 = newNum.nextInt(4);
		}
		// set the probability to 80% for x and 20% for 4 being randomly generated
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
				System.out.print(theBoard[row][col] + "\t");
			}
			System.out.println(" ");
		}
		char typed = 'e';
		// as long as there is a vaild move to be made, enter the move choice loop
		do {
			// if (endGame()) {
			System.out.println("w = up; a = left; s = down; d = right; q = quit; r = restart: ");
			typed = scan.next().charAt(0);
			if (typed == 'w') {

				moveUp(theBoard);

			} else if (typed == 'a') {

				moveLeft(theBoard);

			} else if (typed == 's') {

				moveDown(theBoard);

			} else if (typed == 'd') {

				moveRight(theBoard);

			} else if (typed == 'r') {

				System.out.print("Are you sure? Enter r again to restart or w to keep playing: ");
				typed = scan.next().charAt(0);
				if (typed == 'r') {

					restart();

				}
			} else if (typed == 'q') {

				System.out.print("Are you sure? Enter q again to quit or w to keep playing: ");
				typed = scan.next().charAt(0);
				if (typed == 'q') {

					quit();

				}
				// if the user did not type any of the letters that serve a function, tell them
				// to enter another
			} else {
				System.out.println("That is not a valid input. Please enter w,a,s,d,r or q");
			}

			// print out the number of moves made and the max value on the board after each move
			System.out.println("Number of moves made: " + moveCounter);
			printMax(theBoard);
			counter++;
			
			
		} while (typed != 'q' && endGame());
	}

	public static void newInt(int[][] theBoard) {
		Random gen = new Random();
		int x = gen.nextInt(100) + 1;
		int randRow = gen.nextInt(4);
		int randCol = gen.nextInt(4);
		// set the probability to 80% for x and 20% for 4 being randomly generated
		if (theBoard[randRow][randCol] == 0) {
			if (x < 80) {
				theBoard[randRow][randCol] = 2;
			} else {
				theBoard[randRow][randCol] = 4;
			}
		} else { 
			newInt(theBoard);
		}
	}

	public static void moveUp(int[][] theBoard) {

		if (createBoard.testUp(theBoard)) {
			System.out.println("test is true");
			createBoard.movementUp(theBoard);
			createBoard.movementUp(theBoard);
			createBoard.movementUp(theBoard);
			moveCounter++;
			newInt(theBoard);
		} else {
			System.out.println("Cannot move up");
		}

		printBoard(theBoard);

	}

	//2 apart for moveMent left didnt work (didnt add)
	
	public static void moveLeft(int[][] theBoard) {

		if (createBoard.testLeft(theBoard)) {
			System.out.println("test is true");
			createBoard.movementLeft(theBoard);
			createBoard.movementLeft(theBoard);
			createBoard.movementLeft(theBoard);
			moveCounter++;
			newInt(theBoard);
		} else {
			System.out.println("Cannot move left");
		}
		printBoard(theBoard);
	}

	public static void moveDown(int[][] theBoard) {

		if (createBoard.testDown(theBoard)) {
			System.out.println("test is true");
			createBoard.movementDown(theBoard);
			createBoard.movementDown(theBoard);
			createBoard.movementDown(theBoard);
			moveCounter++;
			newInt(theBoard);
		} else {
			System.out.println("Cannot move down");
		}
		printBoard(theBoard);
	}

	public static void moveRight(int[][] theBoard) {

		if (createBoard.testRight(theBoard)) {
			System.out.println("test right works");
			// call move right 3 times because it only moves one position at a time
			createBoard.movementRight(theBoard);
			createBoard.movementRight(theBoard);
			createBoard.movementRight(theBoard);
			// createBoard.movementRight(theBoard);
			moveCounter++;
			newInt(theBoard);
		} else {
			System.out.println("Test false");
			// theBoard[0][1] = theBoard [0][0];
			// theBoard[0][0] = 0;
		}
		printBoard(theBoard);
	}

	public static void restart() {

		System.out.println("Restarting...");
		System.out.println(" ");
		System.out.println(" ");

		String[] argument = new String[] { "1,2,3" };

		Game.main(argument);

	}

	public static void quit() {
		// create a boolen method win/ no moves left
		// call them both here and use if statments to print out the correct term
		// at the end of all the methods set typed = q so the for loop exits
		System.out.println("game over. Moves made: " + moveCounter);
	}

	// create method print 2d Array that takes in a 2d array as a parameter
	public static void printBoard(int[][] theBoard) {
		// create a nested for loop to go through all elements of the array
		for (int i = 0; i < theBoard.length; i++) {
			for (int j = 0; j < theBoard.length; j++) {
				// print out each element with formatting
				// the \t auto-formats the array when added
				System.out.print(theBoard[i][j] + "\t");
			}
			// print out to go to the next line once you go through the whole row each time
			System.out.println(" ");
		}
	}

	// create method to print the current maximum of the array (needs to be called
	// every time)
	public static void printMax(int[][] board) {
		int max = 2;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {

				if (board[row][col] > max) {
					max = board[row][col];
				}

			}
		}
		System.out.println("The maximum value on the Board is: " + max);
	}

	// create boolean method to test if game is ended
	public static boolean endGame() {
		boolean endGame = true;
		return endGame;

	}

}