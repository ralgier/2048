
public class createBoard {
	//method to test if the board is full, returns value of boolean
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
	
	public static boolean Test() {
		
		int x = 5;
		int y = 5;
		
		boolean Test = false;
		
		if (x == y) {
			Test = true;
		}
		
		return Test;
	}
	
	public static void main (String[] args) {
		System.out.println(Test());
		Test();
	}
	

}
