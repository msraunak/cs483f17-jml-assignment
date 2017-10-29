package tictactoe;

import java.util.*;

/**
 * Create objects of type TicTacToeBoard and runs a game. 
 * 
 * @version 1.0 3/13/15
 */

public class TicTacToeGame {
	

	
	/** The main method */
	public static void main(String[] args) {
		playGame();
	}

	/**
	 * The playGame method is used to manipulate Board objects and play a game
	 * of TicTacToe
	 */
	public static void playGame() {
		
		// The game must be played at least once, so the default answer to play again is "Y" for "yes".
		char answer = 'Y';

		// Keep playing the Game as long as the user wants to keep playing.
		while (answer == 'Y' || answer == 'y') {
			
			// Declare variables, initialize default values.
			boolean isWinner = false;
			boolean validMove = false;
			int row = 0;
			int col = 0;
			char gameTurnChar = TicTacToeBoard.EMPTY_SQUARE;
			int moveCount = 0;

			// Print the introductory message for the user
			printIntroMessage();
			
			// Create a Scanner object for user to input positions
			Scanner userInput = new Scanner(System.in);
			TicTacToeBoard myBoard = new TicTacToeBoard();

			// Loop until Board is full or someone wins.
			while ( moveCount < TicTacToeBoard.SIZE*TicTacToeBoard.SIZE ) {

				gameTurnChar = whoseTurn(moveCount);
		
				// Use loop to make sure a move is valid before continuing.
				while (!validMove) {
					System.out.println("Player " + gameTurnChar
										+ ", please enter a position using row column format.");
					// Use Scanner created above to allow user input.
					row = userInput.nextInt();
					col = userInput.nextInt();

					// Call setMove method from Board object,
					validMove = myBoard.setMove(row, col, gameTurnChar);

					// If valid move is true, continue. If not, continue while loop.
					if (!validMove)
						System.out.println("This was not a valid move! Please enter another.");
				}

				// Print the Board after each move is made.
				System.out.println("The Board: \n" + myBoard);

				// Call hasWinner method from Board object
				isWinner = myBoard.hasWinner();

				if (isWinner ) {
					gameTurnChar = myBoard.whoWon();
					System.out.println("Player " + gameTurnChar + " has won the game! Congratulations!");
					break;// Exit the loop if the Game is over.
				} else
					System.out.println("No one has won yet!");

				// Continue the loop if no one has one.
				System.out.println("");
				moveCount++;// Increase moveCount
				validMove = false;// Reset validMove for the next move.
			}

			// Game is over, use new Scanner to ask user to play again.
			Scanner playAgain = new Scanner(System.in);
			System.out.println("Would you like to play another round? (Y/N)");
			String again = playAgain.nextLine();
			answer = again.charAt(0);

		}
		System.out.println("Thank you for playing!");
	}

	public static void printIntroMessage(){
		// Print introductory statements.
		System.out.println("TicTacToe. All moves will be entered using row column format.");
		System.out.println("For example, the upper left corner of the Board would be 1 1. ");
		System.out.println("The middle of the Board would be 2 2");
		System.out.println("");


	}
	
	public static char whoseTurn(int moveCount){

		// alternate which X's turn and O's turn.
		if (moveCount % 2 == 0)
			return 'X';
		else
			return 'O';

	}
}