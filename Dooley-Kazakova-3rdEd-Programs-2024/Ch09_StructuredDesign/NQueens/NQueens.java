/*
 *  Nqueens.java
 *  N-Queens Program
 *  solved recursively, using backtracking.
 *  Produces a single solution to the problem.
 *
 *  October 5, 2009 jfd
 */
  
import java.util.*;
 
public class NQueens {
    static int totalcount = 0; 
	static int row = 0;
	static int col = 0;
  
    /** 
     *  the queen at (row, col) is safe, 
     *  so we have a partial solution.
     *  advance to the next column
     */
    public void advance (int[] board) {
        board[col] = row;
        col++;               
        row = 0;
    }
  
    /**
     *  could not find a safe row in current col
     *  so back up one col and move that queen
     *  up a row
     */
    public void retreat (int[] board) {
        // assert(col > 0);
        col--;
        row = board[col] + 1;  
    }
  
    /**
     *   check to see if queen at (row, col)  can be
     *   attacked
     */
    public boolean isSafe (int[] board) {
        totalcount++;
  
        boolean safe = true;
        /*
         *  check diagonals and row for attacks
         *  since we're just checking partial solutions
         *  only need to go up to current col
         */
        for (int i=0; i<col; i++)  {
            if (( (board[i] + i) == (row + col) ) ||    // up diagonal
                ( (board[i] - i) == (row - col) ) ||    // down diagonal
                (board[i]  == row) ) 
                safe = false;
        }
        return safe;
    }
  
    public static void main(String args[]) {
        int N = 8;      // default board size
        
		System.out.print("Enter the size of the board: ");
		Scanner stdin = new Scanner(System.in);
		N = stdin.nextInt();
		System.out.println();
        
		NQueens queen = new NQueens();
        /**
         *   index into board is a column number
         *   value stored in board is a row number
         *   so board[2] = 3; says put a queen on col 2, row 3
         */
        int[] board = new int [N]; 
 
        /**
         *   simple algorithm to build partial solutions
         *   for N-queens problem. Place a queen in the 
         *   next available column, test to see if it
         *   can be attacked. If not, then move to the next
         *   column. If it can be attacked, move the queen
         *   up a row and try again. 
         *   If we exhaust all the rows in a column, back up
         *   reset the previous column and try again.
         */
        do {
            while ((row < N) && (col < N))  {
                if (queen.isSafe(board))
                    queen.advance(board);
                else
                    row++;
            }
            if (row == N)
                queen.retreat(board);
                
        } while ((col < N) && (col >= 0));
 
        /* If we've placed all N queens, we've got a solution */
        if (col == N)
            {
                for (int i = 0; i < N; i++)
                    System.out.print(board[i] + " ");
            }
        else
            System.out.println("No solution. ");
            
        System.out.println();
 
        System.out.println("after trying " + totalcount +
                         " board positions.");
    }
}
