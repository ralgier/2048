
public class movement {

	// NEED TO CHANGE ALL THE METHOD TO MOVE IN THEIR RESPECTIVE DIRECTION< LEFT
	// ALREADY WRK CORRECTLY

	public static void moveLeft(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				if (board[i][j - 1] == 0) {
					board[i][j - 1] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}

	public static void smushLeft(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j++) {
				if (board[i][j + 1] == board[i][j]) {
					board[i][j] = 2 * board[i][j];
					board[i][j + 1] = 0;
				}

			}
		}
	}

	public static void moveRight(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = board.length - 1; j > 0; j--) {
				if (board[i][j] == 0) {
					board[i][j] = board[i][j - 1];
					board[i][j - 1] = 0;
				}
			}
		}

	}

	public static void smushRight(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = board.length - 1; j > 0; j--) {
				if (board[i][j - 1] == board[i][j]) {
					board[i][j] = 2 * board[i][j];
					board[i][j - 1] = 0;
				}
			}
		}
	}

	public static void moveUp(int[][] board) {
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					board[i][j] = board[i + 1][j];
					board[i + 1][j] = 0;
				}
			}
		}
	}

	public static void smushUp(int[][] board) {
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i + 1][j] == board[i][j]) {
					board[i][j] = 2 * board[i][j];
					board[i + 1][j] = 0;
				}
			}
		}
	}

	public static void moveDown(int[][] board) {
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					board[i][j] = board[i - 1][j];
					board[i - 1][j] = 0;
				}
			}
		}
	}

	public static void smushDown(int[][] board) {
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == board[i - 1][j]) {
					board[i][j] = 2 * board[i][j];
					board[i - 1][j] = 0;
				}

			}
		}
	}
	
	public static boolean testMovement(int[][] board) {
		boolean testMovement = false;
		
		int[][] tempBoard = board;
		
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; i < board.length; i++) {
				if(tempBoard[i][j] != board[i][j]) { 
					testMovement = true;
				}
			}
		}
			return testMovement;	
	}

	//we need to create a temporary array for each movement and if the temporary array is the same as the array after moving
	//then you cant move that direction...4 methods maybe 
	//if you cant move anydirection, the game is over and call the end game method
	
	
	//cant quish and board is gull,, game is over
	
}
