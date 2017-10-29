package tictactoe;

/**
 * This class contains methods to manipulate objects created by the McNabb_Game
 * class. Code formatted with Eclipse defaults.
 *
 * @version 1.1 10/13/17
 */

public class TicTacToeBoard {
	// Declare variables.
	public static final char EMPTY_SQUARE = '_';
	public static final int SIZE = 3;
	
	private char[][] board;
	private char winningChar; 
	private boolean isThereAWinner;
	
	/**
	 * Instantiates the array representing the TicTacToeBoard
	 * with characters to represent empty spaces
	 */
	public TicTacToeBoard() {
		
		// Create the TicTacToe 3x3 board, fill with empty spaces
		board = new char[SIZE][SIZE];
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = EMPTY_SQUARE;
			} // end inner for
		} // end outer for
		
		isThereAWinner = false;
		winningChar = EMPTY_SQUARE;
	}

	/**
	 * Overloaded constructor to instantiate the board with a preset 
	 * TicTacToeBoard
	 *
	 * @param boardArray a preset TicTacToeBoard
	 */
	public TicTacToeBoard(char[][] boardArray) {
		board = boardArray;
		winningChar = EMPTY_SQUARE;
	}

	/**
	 * Creates and returns a String representation of the current state of the
	 * TicTacToeBoard
	 *
	 * @return the String representation of the board. 
	 */
	@Override
	public String toString() {
		String str = "";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				// walk through the array elements and construct a String str
				str += " " + board[row][col];
			}
			// Make sure each row is on a new line
			str = str + "\n";
		}
		// retun the String
		return str;
	}

	/**
	 * Sets the move for a particular player in a particular row, col 
	 * 
	 * @param row the row of the move
	 * @param col the col of the move
	 * @paper player the character to be placed in the row, col position
	 * @return true if the setting of the move was successful, false otherwise
	 */
	public boolean setMove(int row, int col, char player) {

		// Assume false until proven true.
		boolean validMove = false;

		// Determine if row and col values are valid, and that that space isempty.
		if ( row >= 1 && row <= SIZE && 
				col >= 1 &&	col <= SIZE && 
					board[row - 1][col - 1] == EMPTY_SQUARE ) {
			board[row - 1][col - 1] = player;
			validMove = true;
		}
		return validMove;
	}

	/**
	 * Determine if the current state of the game has a winner or not
	 * @return true if the current board has a winner, false otherwise
	 */
	public boolean hasWinner() {

		// Assume no winner until winner proven.
		boolean hasSomeoneWon = false;

		/* If any of the below criteria is met, isThereAWinner will be true and
		 * winningChar will be set to the winner, X or O */
		if (hasHorizontalWinner() || hasVerticalWinner() || hasDiagonalWinner() ){
			hasSomeoneWon = true;
		}
		
		return hasSomeoneWon;
	}
	
	/**
	 * Checks if there is a winner in any of the rows
	 * @return true if there is a winning row, false otherwise
	 */
	public boolean hasHorizontalWinner(){

		// loop to check if either char has 3 horizontal.
		for (int col = 0; col < board[2].length; col++) {
			if (board[0][col] == board[1][col]
					&& board[1][col] == board[2][col]
						&& board[1][col] != EMPTY_SQUARE) {
				
							winningChar = board[1][col];
							return true;
			} // end if
		} // end for
		return false;
	}

	/**
	 * @return true iff there is a winner in one of the columns, false otherwise
	 */
	public boolean hasVerticalWinner(){
		
		boolean isWinner = false;
		
		// Use this loop to check if either char has 3 vertical.
		for (int row = 0; row < board.length; row++) {
			if ( board[row][0] == board[row][1]
					&& board[row][1] == board[row][2]
					&& board[row][1] != EMPTY_SQUARE ) {
						
					winningChar = board[row][1];
					isWinner = true;
				} // end if
		} // end for loop
		return isWinner;
	}
	
	/**
	 * @return true iff there is a winner in left-to-right or right-to-left diagonal
	 */
	public boolean hasDiagonalWinner(){
		
		boolean isWinner = false;
		// Use this statement to check if a char wins diagonally from top left.
		if (board[0][0] == board[1][1]
				&& board[1][1] == board[2][2]
				&& board[1][1] != EMPTY_SQUARE) {
			isWinner = true;
			winningChar = board[1][1];
		} else
			isWinner = false;

		// Use this statement to check if a char wins diagonally from bottom left.
		if (board[0][2] == board[1][1]
				&& board[1][1] == board[2][0]
				&& board[1][1] != EMPTY_SQUARE) {
			isWinner = true;
			winningChar = board[1][1];
		} else
			isWinner = false;
		
		return isWinner;

	}
	
	
	/**
	 * Returns the character representing the winning player
	 * @return the winning player 'X' or 'O'; When there is no winner, returns '_'
	 */
	public char whoWon() {
		return winningChar;
	}

}
