public class createBoard {

	// method to test if the board is full, returns value of boolean

	public static boolean boardFull(int[][] theBoard) {
		int rows = theBoard.length;
		int columns = theBoard[1].length;
		// create a counter
		int counter = 0;
		// make a boolean to set to true if the board is full
		boolean boardFull = false;
		// create a nested for loop to go through every element of the 2d array
		for (int row = 0; row < theBoard.length; row++) {
			for (int col = 0; col < theBoard[row].length; col++) {
				// if the specific location is not 0, there is a value there and that spot is
				// full
				if (theBoard[row][col] != 0) {
					// increment counter every time a spot is not full
					counter++;
				}
				// if the counter has gone up 16 times, then the board is full
				if (counter == (rows) * (columns)) {
					boardFull = true;
				}
			}
		}
		return boardFull;
	}

	// create method to print the current maximum of the array (needs to be called

	// every time)

	public static void printMax(int[][] board) {
		int max = 2;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] > max) {
					max = board[row][max];
				}
			}
		}
		System.out.println(max);
	}

	// method to test if you can make a move to the right
	public static boolean testRight(int[][] board) {
		boolean testRight = false;
		// test if there is a location where there are two spaces in the same row next
		// to each other that are equal
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[i][j] == board[i][j + 1] && board[i][j] != 0) {
					testRight = true;
					board[i][j + 1] = 2 * board[i][j];
					board[i][j] = 0;

				}
			}
		}
		// test if there are any equal values in the same row 2 apart with a 0 in the
		// middle
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 2; j++) {
				if (board[i][j] == board[i][j + 2] && board[i][j + 1] == 0 && board[i][j] != 0) {
					testRight = true;

					board[i][j + 2] = 2 * board[i][j];
					board[i][j] = 0;

				}

			}

		}

		// test if there are any equal values in the same row 3 apart with two 0's in
		// the middle
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 3; j++) {
				if (board[i][j] == board[i][j + 3] && board[i][j + 1] == 0 && board[i][j + 2] == 0
						&& board[i][j] != 0) {

					testRight = true;
					board[i][j + 3] = 2 * board[i][j];
					board[i][j] = 0;

				}
			}
		}

		// test if there is a 0 directly to the right of any element, if there is then
		// moving to the right is possible
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[i][j + 1] == 0 && board[i][j] != 0) {
					testRight = true;

				}
			}
		}

		return testRight;
	}

	public static boolean testLeft(int[][] board) {
		boolean testLeft = false;
		// test if there is a location where there are one spaces in the same row to the
		// left
		// to each other that are equal
		for (int i = 0; i < board.length; i++) {
			for (int j = board.length - 1; j > 0; j--) {
				if (board[i][j] == board[i][j - 1] && board[i][j] != 0) {
					testLeft = true;
					board[i][j - 1] = 2 * board[i][j];
					board[i][j] = 0;

				}
			}
		}
		// test if there are any equal values in the same row 2 apart with a 0 in the
		// middle
		for (int i = 0; i < board.length; i++) {
			for (int j = board[i].length - 2; j > 1; j--) {
				if (board[i][j] == board[i][j - 2] && board[i][j - 1] == 0 && board[i][j] != 0) {
					testLeft = true;
					board[i][j - 2] = 2 * board[i][j];
					board[i][j] = 0;
				}

			}

		}

		// test if there are any equal values in the same row 3 apart with two 0's in
		// the middle
		for (int i = 0; i < board.length; i++) {
			for (int j = board[i].length - 3; j > 2; j--) {
				if (board[i][j] == board[i][j - 3] && board[i][j - 2] == 0 && board[i][j - 1] == 0
						&& board[i][j] != 0) {
					testLeft = true;
					board[i][j - 3] = 2 * board[i][j];
					board[i][j] = 0;
				}
			}
		}
		// test if there is a 0 directly to the left of any element, if there is then
		// moving to the left is possible
		for (int i = 0; i < board.length; i++) {
			for (int j = board[i].length - 1; j > 0; j--) {
				if (board[i][j - 1] == 0 && board[i][j] != 0) {
					testLeft = true;
				}
			}
		}
		return testLeft;
	}

	public static boolean testUp(int[][] board) {

		boolean testUp = false;
		// test if there is a location where there are one spaces above
		// each other that are equal
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i - 1][j] && board[i][j] != 0) {
					testUp = true;

					board[i - 1][j] = 2 * board[i][j];
					board[i][j] = 0;

				}
			}
		}

		for (int i = board.length - 1; i > 1; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i - 2][j] && board[i - 1][j] == 0 && board[i - 2][j] != 0) {
					testUp = true;
					board[i - 2][j] = 2 * board[i - 2][j];
					board[i][j] = 0;

				}
			}
		}
		for (int i = board.length - 1; i > 2; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i - 3][j] && board[i - 1][j] == 0 && board[i - 2][j] == 0
						&& board[i - 3][j] != 0) {
					testUp = true;
					board[i - 3][j] = 2 * board[i - 3][j];
					board[i][j] = 0;

				}
			}
		}
		// this loop needs to test if there is a 0 above any point that isnt 0
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != 0 && board[i - 1][j] == 0) {
					testUp = true;
				}
			}
		}
		return testUp;
	}

	public static boolean testDown(int[][] board) {

		boolean testDown = false;
		// test if there is a location where there are one spaces above
		// each other that are equal
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i + 1][j] && board[i][j] != 0) {
					testDown = true;
					board[i + 1][j] = 2 * board[i][j];
					board[i][j] = 0;
				}
			}
		}
		// test if there are any equal values in the same column 2 apart with a 0 in the
		// middle
		for (int i = 0; i < board.length - 2; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i + 2][j] && board[i + 1][j] == 0 && board[i][j] != 0) {
					testDown = true;
					board[i + 2][j] = 2 * board[i][j];
					board[i][j] = 0;
				}
			}
		}
		// test if there are any equal values in the same column 3 apart with two 0's in
		// the middle
		for (int i = 0; i < board.length - 3; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i + 3][j] && board[i + 2][j] == 0 && board[i + 1][j] == 0
						&& board[i][j] != 0) {
					testDown = true;
					board[i + 3][j] = 2 * board[i][j];
					board[i][j] = 0;
				}
			}
		}
		// test if there is a 0 directly above any element, if there is then moving to
		// the left is possible
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i + 1][j] == 0 && board[i][j] != 0) {
					testDown = true;
				}
			}
		}
		return testDown;
	}

	public static void movementRight(int[][] board) {
		for (int i = 0; i < board.length-1; i++) {
			for (int j = board.length-2; j>0; j--) {
				
			if (board[i][j+1] == 0) {	
				board[i][j+1]= board[i][j];
				board[i][j] = 0;
			}
				
			}
		}
	}
	public static void movementLeft(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				while (board[i][j] > 0 && board[i][j - 1] == 0) {
					board[i][j - 1] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}
	public static void movementUp(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				while (board[i][j] > 0 && board[i - 1][j] == 0) {
					board[i - 1][j] = board[i][j];
					board[i][j] = 0;
				}

			}

		}

	}

	public static void movementDown(int[][] board) {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board.length; j++) {

				while (board[i][j] > 0 && board[i + 1][j] == 0) {

					board[i + 1][j] = board[i][j];

					board[i][j] = 0;

				}

			}

		}

	}

	public static void main(String[] args) {
	}
}
// new columns than what he started with
//
// need to use array list to get the values where there are o and put that in
// the list and only randomize from that list
