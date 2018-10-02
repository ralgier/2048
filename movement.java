import java.util.Random;
import java.util.Scanner;

public class movement {

	static int counter = 2;

	public static void main(String[] args) {
		
		board.main(args);

		Scanner scan = new Scanner(System.in);

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
	
	

	public static void moveUp() {
		System.out.println("up");
		board.newRandomNumber(theBoard);
	}

	public static void moveLeft() {
		System.out.println("left");
	}

	public static void moveDown() {
		System.out.println("down");
	}

	public static void moveRight() {
		System.out.println("right");
		
//		for (int q = 0; q < myArray.length; q++) {
//			for (int w = 0; w < myArray[0].length - 1; w++) {
//				myArray[q][w + 1] = myArray[q][w + 1] + myArray[q][w];
//
//			}
//
//		}
//		lab3.print2dArray(myArray);
	}

	public static void restart() {
		System.out.println("Restarting...");

	}

	public static void quit() {

		System.out.println("game over. Moves made: " + counter);
	}

}