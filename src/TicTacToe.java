import javax.swing.*;
import java.util.Scanner;
/**
 * Tic-Tac-Toe: Exercise for Test-Driven Development
 * Develop hasWon, validate3inDiagonal, backwardDiagonal, forwardDiagonal, validate3inColumn in TDD methodology
 */
public class TicTacToe {
    // Name-constants to represent the seeds and cell contents
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int CIRCLE = 2;

    // Name-constants to represent the various states of the game
    public static final int PLAYING = 0;
    public static final int DRAW = 1;
    public static final int CROSS_WON = 2;
    public static final int CIRCLE_WON = 3;

    // The game board and the game status
    public static final int ROWS = 3, COLS = 3; // number of rows and columns
    public static int[][] board = new int[ROWS][COLS]; // game board in 2D array
    //  containing (EMPTY, CROSS, CIRCLE)
    public static int currentState;  // the current state of the game
    // (PLAYING, DRAW, CROSS_WON, CIRCLE_WON)
    public static int currentPlayer; // the current player (CROSS or CIRCLE)
    public static int currntRow, currentCol; // current seed's row and column

    public static Scanner in = new Scanner(System.in); // the input Scanner

    /** The entry main method (the program starts here) */
    public static void main(String[] args) {
        // Initialize the game-board and current status
        initGame();
        // Play the game once
        do {
            playerMove(currentPlayer); // update currentRow and currentCol
            updateGame(currentPlayer, currntRow, currentCol); // update currentState
            printBoard();
            // Print message if game-over
            if (currentState == CROSS_WON) {
                System.out.println("'X' won! Bye!");
            } else if (currentState == CIRCLE_WON) {
                System.out.println("'O' won! Bye!");
            } else if (currentState == DRAW) {
                System.out.println("It's a Draw! Bye!");
            }
            // Switch player
            currentPlayer = (currentPlayer == CROSS) ? CIRCLE : CROSS;
        } while (currentState == PLAYING); // repeat if not game-over
    }

    /** Initialize the game-board contents and the current states */
    public static void initGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                board[row][col] = EMPTY;  // all cells empty
            }
        }
        currentState = PLAYING; // ready to play
        currentPlayer = CROSS;  // cross plays first
    }

    /** Player with the "current" makes one move, with input validation.
     Update global variables "currentRow" and "currentCol". */
    public static void playerMove(int current) {
        boolean validInput = false;  // for input validation
        do {
            if (current == CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }
            int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
            int col = in.nextInt() - 1;
            validInput = isValidMove(row, col, current);
            if (!validInput)
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
        } while (!validInput);  // repeat until input is valid
    }

    private static boolean isValidMove(int row, int col, int current) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
            currntRow = row;
            currentCol = col;
            board[currntRow][currentCol] = current;  // update game-board content
            return true;
        }
        else
            return false;
    }

    /** Update the "currentState" after the player with "current" has placed on
     (currentRow, currentCol). */
    public static void updateGame(int current, int currentRow, int currentCol) {
        if (hasWon(current, currentRow, currentCol)) {  // check if winning move
            currentState = (current == CROSS) ? CROSS_WON : CIRCLE_WON;
        } else if (isDraw()) {  // check for draw
            currentState = DRAW;
        }
        // Otherwise, no change to currentState (still PLAYING).
    }

    /** Return true if it is a draw (no more empty cell)
     Shall declare draw if no player can "possibly" win
     **/
    public static boolean isDraw() {
        boolean draw = true;
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (board[row][col] == EMPTY){ // if there is empty cell
                    draw = false;
                    break;
                }
            }
        }
        return draw;
    }


    /** Return true if the player with "current" has won after placing at
     (currentRow, currentCol) */
    public static boolean hasWon(int current, int currentRow, int currentCol) {
   /*
   version 1
       if(validate3inRow(currentRow,current) && validate3inColumn(currentCol,current) && validate3inDiagonal(currentRow,currentCol,current))
         {
            return true;
         }

    */
   /*veriosn 2

   if(validate3inDiagonal(currentRow,currentCol,current))
   {
      return  true;
   }
   else
   {
      if(validate3inColumn(currentCol,current))
      {
         return true;
      }
      else
      {
         if(validate3inRow(currentRow,current))
         {
            return true;
         }
         else
         {
            return false;
         }


   }
   }
   */

        if(validate3inRow(currentRow,current) || validate3inColumn(currentCol,current) || validate3inDiagonal(currentRow,currentCol,current))
        {
            return true;
        }

        return false;
    }

    /** Return true if the player with "current" has marked at least one diagonal after placing at
     (currentRow, currentCol) */
    public static boolean validate3inDiagonal(int currentRow, int currentCol, int current) {
       /*
       version 1
       if(currentCol == 1 && currentRow == 1 ) {

          if (board[currentRow][currentCol] == board[currentRow - 1][currentCol - 1] && board[currentRow][currentCol] == board[currentCol + 1][currentRow + 1]) {
             return true;
          }
       }
       */
       /*
       version 2
       return (backwardDiagonal(currentRow,currentCol,current) && forwardDiagonal(currentRow,currentCol,current));

        /*
       verios 3


       if(backwardDiagonal(currentRow,currentCol,current))
       {
          return true;
       }
       else
       {
          if(forwardDiagonal(currentRow,currentCol,current))
          {
             return true;
          }
          else
          {
             return false;
          }
       }

       */
        /*verison 4
         */

        return (backwardDiagonal(currentRow,currentCol,current) || forwardDiagonal(currentRow,currentCol,current));


    }

    /** Return true if the player with "current" has marked all backward diagonal after placing at
     (currentRow, currentCol) */
    public static boolean backwardDiagonal(int currentRow, int currentCol, int current) {
	/*version 1
	return false;

	 */
	/* version 2
	return true ;
	 */
	/*version 3

        if((currentRow == 2 && currentCol == 0 ) || (currentRow == 0 && currentCol == 2 )|| (currentRow == 1 && currentCol == 1 ))
   {
      return true;
   }
   else
   {
   return false;
   }

	 */
	/*version 4*

	if((currentRow == 2 && currentCol == 0 ) || (currentRow == 0 && currentCol == 2 )|| (currentRow == 1 && currentCol == 1 ))
   {



      if(currentCol == 0)
      {
         return(board[currentRow][currentCol] == board[currentRow+1][currentCol+1] && board[currentRow][currentCol] == board[currentRow+2][currentCol+2] );
      }
      if(currentCol == 2)
      {
         return(board[currentRow][currentCol] == board[currentRow-1][currentCol-1] && board[currentRow][currentCol] == board[currentRow-2][currentCol-2] );
      }
      if(currentCol == 1)
      {
         return(board[currentRow][currentCol] == board[currentRow-1][currentCol-1] && board[currentRow][currentCol] == board[currentRow+1][currentCol+1] );
      }

   }
      return  false;
*/
        /*version 5*/
        if((currentRow == 2 && currentCol == 0 ) || (currentRow == 0 && currentCol == 2 )|| (currentRow == 1 && currentCol == 1 )){


            if (currentCol == 0) {
                return (current == board[currentRow - 1][currentCol + 1] && current == board[currentRow - 2][currentCol + 2] && board[currentRow][currentCol] == current);
            }
            if (currentCol == 2) {
                return (current == board[currentRow - 1][currentCol -1] && current == board[currentRow - 2][currentCol - 2] && board[currentRow][currentCol] == current);
            }
            if (currentCol == 1) {
                return (current == board[currentRow +1][currentCol -1] && current == board[currentRow - 1][currentCol + 1] && board[currentRow][currentCol] == current);
            }



        }
        return false;
    }

    /** Return true if the player with "current" has marked all forward diagonal after placing at
     (currentRow, currentCol) */
    public static boolean forwardDiagonal(int currentRow, int currentCol, int current) {

  /*version 1
	return false;

	 */
	/* version 2
	return true ;
	 */
	/*version 3

        if((currentRow == 0 && currentCol == 0 ) || (currentRow == 2 && currentCol == 2 ) || (currentRow == 1 && currentCol == 1 ))
   {
      return true;
   }
   else
   {
   return false;
   }

	 */
	/*version 4*

	if((currentRow == 0 && currentCol == 0 ) || (currentRow == 2 && currentCol == 2 ) || (currentRow == 1 && currentCol == 1 ))
   {



      if(currentCol == 0)
      {
         return(board[currentRow][currentCol] == board[currentRow+1][currentCol+1] && board[currentRow][currentCol] == board[currentRow+2][currentCol+2] );
      }
      if(currentCol == 2)
      {
         return(board[currentRow][currentCol] == board[currentRow-1][currentCol-1] && board[currentRow][currentCol] == board[currentRow-2][currentCol-2] );
      }
      if(currentCol == 1)
      {
         return(board[currentRow][currentCol] == board[currentRow-1][currentCol-1] && board[currentRow][currentCol] == board[currentRow+1][currentCol+1] );
      }

   }
      return  false;
*/
        /*version 5*/
        if((currentRow == 0 && currentCol == 0 ) || (currentRow == 2 && currentCol == 2 ) || (currentRow == 1 && currentCol == 1 ))
        {


            if (currentCol == 0) {
                return (current == board[currentRow + 1][currentCol + 1] && current == board[currentRow + 2][currentCol + 2] && board[currentRow][currentCol] == current);
            }
            if (currentCol == 2) {
                return (current == board[currentRow -1][currentCol -1] && current == board[currentRow - 2][currentCol - 2] && board[currentRow][currentCol] == current);
            }
            if (currentCol == 1) {
                return (current == board[currentRow -1][currentCol -1] && current == board[currentRow + 1][currentCol + 1] && board[currentRow][currentCol] == current);
            }


        }
        return false;
    }


    /** Return true if the player with "current" has marked some column after placing at
     (currentRow, currentCol) */

    /**

     */
    public static boolean validate3inColumn(int currentCol, int current) {

    /* version 1
    return false ;
     */
    /*version 2
    return true ;
     */
    /* version 3
    return (board[0][currentCol] == board[1][currentCol] && board[0][currentCol] == board[2][currentCol] && board[1][currentCol] == board[2][currentCol])
     */
    /* version 4
    if (board[0][currentCol] == current ) {


       if (board[1][currentCol] == current) {

          if (board[2][currentCol] == current) {
             return true;

          }
          else
          {
             return  false;
          }
       }
       else
       {
          return  false;
       }
    }
    else{
       return  false;
    }
    */
        // version 5
        return board[0][currentCol] == current
                && board[1][currentCol] == current
                && board[2][currentCol] == current;



    }

    /** Return true if the player with "current" has marked some row after placing at
     (currentRow, currentCol) */
    public static boolean validate3inRow(int currentRow, int current) {
        return board[currentRow][0] == current
                && board[currentRow][1] == current
                && board[currentRow][2] == current;

    }

    /** Print the game board */
    public static void printBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }

    /** Print a cell with the specified "content" */
    public static void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case CIRCLE: System.out.print(" O "); break;
            case CROSS:  System.out.print(" X "); break;
        }
    }
}