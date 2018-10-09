import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class runGame {
	// create a static int to increment the number of moves throughout
	static int moveCounter = 0;
	static char typed = 'e';

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
		// as long as there is a vaild move to be made, enter the move choice loop
		do {
			// if (endGame()) {
			System.out.println("w = up; a = left; s = down; d = right; q = quit; r = restart: ");
			typed = scan.next().charAt(0);
			//if the user enetered w, move up
			if (typed == 'w') {

				moveUp(theBoard);
			//if they enter a, move left
			} else if (typed == 'a') {

				moveLeft(theBoard);
			//if they enter s, move down
			} else if (typed == 's') {

				moveDown(theBoard);
			//if they enter d, move right
			} else if (typed == 'd') {

				moveRight(theBoard);
			//if they enter r, ask them to restart and if they confirm, restart the game
			} else if (typed == 'r') {

				System.out.print("Are you sure? Enter r again to restart or w to keep playing: ");
				typed = scan.next().charAt(0);
				if (typed == 'r') {

					restart();
				}
			//if they enter q, confirm they want to quit and then call the quit method
			} else if (typed == 'q') {

				System.out.print("Are you sure? Enter q again to quit or w to keep playing: ");
				typed = scan.next().charAt(0);

				if (typed == 'q') {

					quit();

				}
			// if the user did not type any of the letters that serve a function, tell them to enter another
			} else {
				System.out.println("That is not a valid input. Please enter w,a,s,d,r or q");
			}

			// print out the number of moves made and the max value on the board after each
			// move
			System.out.println("Number of moves made: " + moveCounter);
			printMax(theBoard);
			counter++;
			if (youWin(theBoard)) {
				System.out.println("You made it to 2048! Congrats! You WIN!!!");
				endGame();
			}

		} while (typed != 'q');
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
			// error when board is full
			newInt(theBoard);
		}
	}
	//move up method which calls move and then smush and then move again
	public static void moveUp(int[][] theBoard) {

		movement.moveUp(theBoard);
		movement.moveUp(theBoard);
		movement.moveUp(theBoard);

		movement.smushUp(theBoard);

		movement.moveUp(theBoard);
		movement.moveUp(theBoard);
		movement.moveUp(theBoard);

		moveCounter++;
		newInt(theBoard);

		printBoard(theBoard);

	}

	public static void moveLeft(int[][] theBoard) {

		// move everything to the left
		// need to call the method 3 times because it only moves things over 1 element
		// at a time
		movement.moveLeft(theBoard);
		movement.moveLeft(theBoard);
		movement.moveLeft(theBoard);
		// smush everything that is equal to the thing on its left
		// make the one on the left double, and set the one on the right to 0
		movement.smushLeft(theBoard);
		// then move everything over to the left again
		movement.moveLeft(theBoard);
		movement.moveLeft(theBoard);
		movement.moveLeft(theBoard);

		moveCounter++;
		newInt(theBoard);

		// we need a method if (boardNew = boardCopy after the movement, then counter
		// does not go up and
		// print that you cannot move that direction

		// test method might still be useful but completely chnage the process
		// still use booleans

		printBoard(theBoard);
	}

	public static void moveDown(int[][] theBoard) {
		// shift everything down (3x because it only moves one at a time)
		movement.moveDown(theBoard);
		movement.moveDown(theBoard);
		movement.moveDown(theBoard);
		// add everything that is equal to each other in the same column downwards to
		// one another
		movement.smushDown(theBoard);
		// shift everything down (3x because it only moves one at a time)
		movement.moveDown(theBoard);
		movement.moveDown(theBoard);
		movement.moveDown(theBoard);

		moveCounter++;
		newInt(theBoard);
		printBoard(theBoard);
	}

	public static void moveRight(int[][] theBoard) {
		// shift everything Right (3x because it only moves one at a time)
		movement.moveRight(theBoard);
		movement.moveRight(theBoard);
		movement.moveRight(theBoard);
		// add everything next to each other in the same row to one another
		movement.smushRight(theBoard);
		// shift everything right (3x because it only moves one at a time)
		movement.moveRight(theBoard);
		movement.moveRight(theBoard);
		movement.moveRight(theBoard);

		moveCounter++;
		newInt(theBoard);
		printBoard(theBoard);
	}

	public static void restart() {
		// print out the game is restarting with some extra spaces
		System.out.println("Restarting...");
		System.out.println(" ");
		System.out.println(" ");
		moveCounter = 0;
		// recall the main method to start again
		String[] argument = new String[] { "1,2,3" };
		// run the main
		runGame.main(argument);

	}

	// quit method that runs when the person enters q
	public static void quit() {
		// create a boolean method win/ no moves left
		// call them both here and use if statments to print out the correct term
		// at the end of all the methods set typed = q so the for loop exits
		System.out.println("Game Over. Moves made: " + moveCounter);
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
		// set a variable = 2
		int max = 2;
		// iterate through the array
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				// if the element you are on is greater than the current max, the leement
				// becimes current max
				if (board[row][col] > max) {
					max = board[row][col];
				}
			}
		}
		// print out what the current maximum is
		System.out.println("The maximum value on the Board is: " + max);
	}

	// youwin method for when you get 2048
	public static boolean youWin(int[][] board) {
		boolean youWin = false;
		// same loop as print max to find the maximum
		int max = 2;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {

				if (board[row][col] > max) {
					max = board[row][col];
				}
			}
		}
		// if the maximum is 2048, you win and the boolean changes to true
		if (max == 2048) {
			youWin = true;
		}
		return youWin;
	}
	// create boolean to end the game when you get 2048 or have no moves left to make
	public static void endGame() {
		System.out.println("The game is over. Thanks for playing");

		typed = 'q';

	}
}