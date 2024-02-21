package hw3;


public class Board {
	// TODO
	char[][] GameBoard;
	int rows = 6;
	int columns = 8;
	int moveCounter = 0;
	char GameStatus;
	char CurrentPlayer;
	boolean isPlaying;
	// Add whatever private fields you need here.
	// Remember, only variables of type int, char, boolean, and 1D and 2D arrays
	// of these types are allowed.
	//
	// As always, you may also add private helper methods to the class.  That will
	// likely be very useful on this assignment.

	/**
	 * Constructs a new empty connect 4 game board with player X being the first player
	 * and player 'O' being the second player.
	 */
	
	
	public Board() {
		CurrentPlayer = 'X';
		GameBoard = new char[columns][rows];
		isPlaying = true;
		for (int i = 0; i < GameBoard.length; i++) {
			for (int j = 0; j < GameBoard[i].length; j++) {
				GameBoard[i][j] = '+';
			}
		}
	}


	/**
	 * Gets the current player (either 'X' or 'O')
	 * 
	 * @return the current player
	 */
	public char currentPlayer() {
		return CurrentPlayer;
	}

	/**
	 * The current player makes a move in a given column if it is a valid move.
	 * Throws an exception if the game is already over.
	 * 
	 * @param column the column in which to make a move.  For the move to be valid,
	 * the column value must an {@code int} between 1 and 7 inclusive, and
	 * there must have been fewer than 6 moves already made in the given column.
	 * @return {@code true} if the move is valid and false if it is not valid.
	 * @throws RuntimeException if the game is already over.
	 */
	public boolean play(int column) {
		if (gameStatus() == 'X' || gameStatus() == 'O' || gameStatus() == 'D') {
			throw new RuntimeException("Game already finished!");
			}
		if (column <= 0) {
			return false;
		}
		if (column > 7) {
			return false;
		}
		if (CurrentPlayer == 'O') {
		for (int i = 0; i < GameBoard[column].length; i++) {
			if (GameBoard[column][i] == '+') {
				GameBoard[column][i] = CurrentPlayer;
				moveCounter++;
				CurrentPlayer = 'X';
				return true;
			}
		}
	}	if (CurrentPlayer == 'X') {
		for (int i = 0; i < GameBoard[column].length; i++) {
			if (GameBoard[column][i] == '+') {
				GameBoard[column][i] = CurrentPlayer;
				moveCounter++;
				CurrentPlayer = 'O';
				return true;
			}
		}
	}
		return false;
	}

	/**
	 * Determine the status of the game.
	 * 
	 * @return {@code 'X'} or {@code 'O'} if either player has won, {@code 'D'} if
	 * the game is a draw, and {@code 'U'} if the game is still undecided.
	 */
	public char gameStatus() {
		if (moveCounter == 42) {
			return 'D';
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the Right direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (i+1 <= 7)
					if (GameBoard[i+1][j] == 'X') {
						if (i+2 <= 7)
						if (GameBoard[i+2][j] == 'X') {
							if (i+3 <= 7)
							if (GameBoard[i+3][j] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the Left direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (i-1 >= 1)
					if (GameBoard[i-1][j] == 'X') {
						if (i-2 >= 1)
						if (GameBoard[i-2][j] == 'X') {
							if (i-3 >= 1)
							if (GameBoard[i-3][j] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the Up direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j+1 < 6)
					if (GameBoard[i][j+1] == 'X') {
						if (j+2 < 6)
						if (GameBoard[i][j+2] == 'X') {
							if (j+3 < 6)
							if (GameBoard[i][j+3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the Down direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j-1 >= 1)
					if (GameBoard[i][j-1] == 'X') {
						if (j-2 >= 1)
						if (GameBoard[i][j-2] == 'X') {
							if (j-3 >= 1)
							if (GameBoard[i][j-3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the UpRight direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j+1 < 6 && i+1 <= 7)
					if (GameBoard[i+1][j+1] == 'X') {
						if (j+2 < 6 && i+2 <= 7)
						if (GameBoard[i+2][j+2] == 'X') {
							if (j+3 < 6 && i+3 <=7)
							if (GameBoard[i+3][j+3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the DownRight direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j-1 > 0 && i+1 <= 7)
					if (GameBoard[i+1][j-1] == 'X') {
						if (j-2 > 0 && i+2 <= 7)
						if (GameBoard[i+2][j-2] == 'X') {
							if (j-3 > 0 && i+3 <= 7)
							if (GameBoard[i+3][j-3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the DownLeft direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j-1 > 0  && i-1 > 0)
					if (GameBoard[i-1][j-1] == 'X') {
						if (j-2 > 0 && i-2 > 0)
						if (GameBoard[i-2][j-2] == 'X') {
							if (j-3 > 0 && i-3 > 0)
							if (GameBoard[i-3][j-3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for X wins in the UpLeft direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'X') { 
					if (j+1 < 6 && i-1 > 0)
					if (GameBoard[i-1][j+1] == 'X') {
						if (j+2 < 6 && i-2 > 0)
						if (GameBoard[i-2][j+2] == 'X') {
							if (j+3 < 6 && i-3 > 0)
							if (GameBoard[i-3][j+3] == 'X') {
								GameStatus = 'x';
								isPlaying = false;
								return 'X';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the Right direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (i+1 <= 7)
					if (GameBoard[i+1][j] == 'O') {
						if (i+2 <= 7)
						if (GameBoard[i+2][j] == 'O') {
							if (i+3 <= 7)
							if (GameBoard[i+3][j] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the Left direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (i-1 >= 1)
					if (GameBoard[i-1][j] == 'O') {
						if (i-2 >= 1)
						if (GameBoard[i-2][j] == 'O') {
							if (i-3 >= 1)
							if (GameBoard[i-3][j] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the Up direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j+1 < 6)
					if (GameBoard[i][j+1] == 'O') {
						if (j+2 < 6)
						if (GameBoard[i][j+2] == 'O') {
							if (j+3 < 6)
							if (GameBoard[i][j+3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the Down direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j-1 >= 1)
					if (GameBoard[i][j-1] == 'O') {
						if (j-2 >= 1)
						if (GameBoard[i][j-2] == 'O') {
							if (j-3 >= 1)
							if (GameBoard[i][j-3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the UpRight direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j+1 < 6 && i+1 <= 7)
					if (GameBoard[i+1][j+1] == 'O') {
						if (j+2 < 6 && i+2 <= 7)
						if (GameBoard[i+2][j+2] == 'O') {
							if (j+3 < 6 && i+3 <=7)
							if (GameBoard[i+3][j+3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the DownRight direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j-1 > 0 && i+1 <= 7)
					if (GameBoard[i+1][j-1] == 'O') {
						if (j-2 > 0 && i+2 <= 7)
						if (GameBoard[i+2][j-2] == 'O') {
							if (j-3 > 0 && i+3 <=7)
							if (GameBoard[i+3][j-3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the DownLeft direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j-1 > 0  && i-1 > 0)
					if (GameBoard[i-1][j-1] == 'O') {
						if (j-2 > 0 && i-2 > 0)
						if (GameBoard[i-2][j-2] == 'O') {
							if (j-3 > 0 && i-3 > 0)
							if (GameBoard[i-3][j-3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}
		for (int i = 0; i < GameBoard.length; i++) { //Checks for O wins in the UpLeft direction. 
			for (int j = 0; j < GameBoard[i].length; j++) {
				if (GameBoard[i][j] == 'O') { 
					if (j+1 < 6 && i-1 > 0)
					if (GameBoard[i-1][j+1] == 'O') {
						if (j+2 < 6 && i-2 > 0)
						if (GameBoard[i-2][j+2] == 'O') {
							if (j+3 < 6 && i-3 > 0)
							if (GameBoard[i-3][j+3] == 'O') {
								GameStatus = 'o';
								isPlaying = false;
								return 'O';
							}
						}
					}
				}
				
			}
		}

		return 'U';
	}

	/**
	 * Construct a string that depicts the sate of the game.
	 * (See the writeup for what that string should look like.)
	 * 
	 * @return a string depicting the game board
	 */
	public String toString() {
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][5] + " ");
	}
	System.out.println();
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][4] + " ");
	}
	System.out.println();
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][3] + " ");
	}
	System.out.println();
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][2] + " ");
	}
	System.out.println();
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][1] + " ");
	}
	System.out.println();
	for (int i = 1; i < GameBoard.length; i++) {
		System.out.print(GameBoard[i][0] + " ");
	}
	
	System.out.println(" ");
	System.out.println("1 2 3 4 5 6 7");
	gameStatus();
	return " ";

	}

}
