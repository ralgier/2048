import java.util.Random;
import java.util.Scanner;

public class board {

	public static void main(String[] args) {
		Random newNum = new Random();
		Scanner scan = new Scanner(System.in);
		int[][] theBoard = new int[4][4];
		int numRows = 4;
		int numColumns = 4;
		int counter = 0;
		String restart = new String();
		String quit = new String();

		for (int row = 0; row < theBoard.length; row++) {
			for (int col = 0; col < theBoard[row].length; col++) {

				theBoard[row][col] = 0;

			}
		}
		int x = newNum.nextInt(100) + 1;
		int y = newNum.nextInt(100) + 1;
		int randRow = newNum.nextInt(4);
		int randCol = newNum.nextInt(4);
		int randRow2 = newNum.nextInt(4);
		int randCol2 = newNum.nextInt(4);

		if (theBoard[randRow] == theBoard[randRow2] && theBoard[randCol] == theBoard[randCol2]) {
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
//STARTING HERE: get input from the user for movement direction
		char typed;
		do {
			System.out.println("w = up; a = left; s = down; d = right; q = quit; r = restart: ");

			typed = scan.next().charAt(0);

			if (typed == 'w') {
				moveUp();

			} else if (typed == 'a') {
				moveRight();

			} else if (typed == 's') {
				moveDown();

			} else if (typed == 'd') {
				moveRight();

			} else if (typed == 'r') {

				System.out.print("Are you sure? Enter r again to restart: ");
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

			} else {

				System.out.println("That is not a valid input. Please enter w,a,s,d,r or q");
			}
		} while (typed != 'q' && typed != 'r');

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

	public static void moveUp() {
		System.out.println("up");
		// board.newRandomNumber(theBoard);
	}

	public static void moveLeft() {
		System.out.println("left");
	}

	public static void moveDown() {
		System.out.println("down");
	}

	public static void moveRight() {
		System.out.println("right");

		// for (int q = 0; q < myArray.length; q++) {
		// for (int w = 0; w < myArray[0].length - 1; w++) {
		// myArray[q][w + 1] = myArray[q][w + 1] + myArray[q][w];
		//
		// }
		//
		// }
		// lab3.print2dArray(myArray);
	}

	public static void restart() {
		System.out.println("Restarting...");

	}

	public static void quit() {

		// System.out.println("game over. Moves made: " + counter);
	}

}
