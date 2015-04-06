/**
 * 
 */
package edu.pitt.array;

/**
 * Word Search #79 unfinished
 *  Given a 2D board and a word, find if the word exists in the grid.
 *  The word can be constructed from letters of sequentially adjacent cell, 
 *  where "adjacent" cells are those horizontally or vertically neighboring. 
 *  The same letter cell may not be used more than once.
 *  For example,
 *  Given board =
 *  [
 *    ["ABCE"],
 *    ["SFCS"],
 *    ["ADEE"]
 *  ]
 *  word = "ABCCED", -> returns true,
 *  word = "SEE", -> returns true,
 *  word = "ABCB", -> returns false.
 * @author yanma
 * @since 2015-04-03
 * @version 2015-04-03
 */
public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        if (board == null) {
        	return false;
        } else if (word.length() == 0) {
        	return true;
        } else if ((board.length) * (board[0].length) < word.length() ) {
        	return false;
        }
        
        boolean[][] trueboard = new boolean[board.length][board[0].length];
        /**
         * 1. find the first letter and check the trueboard, 
         * 		find the position make it true, go on to next letter; 
         * 2. check the grid above, below, left or right of the first letter, 
         * 		if no one is the letter, return to find the first letter again.make the previous first letter position false
         * 3. 	if find the letter, check the trueboard
         * 			if false, make it true and go on to check next letter
         * 			if true, go to next direction to check
         * 			if all used, return to the letter before and make it false on trueboard
         */
        
        int index = 0;
        int row = 0 ;
		int col = 0;
		
		while (index < word.length()) {
			if (index == 0) {
				outerloop:
				for (; row < board.length; row++) {
	    			col = 0;
		    		for (; col < board[0].length; col++) {
		    			if (board[row][col] == word.charAt(index)) {
		    				if (trueboard[row][col] == false) {
		    					trueboard[row][col] = true;
		    					index++;
		    					System.out.println("row: " + row + " col: " + col);
		    					break outerloop;
		    				}
		    			} 
		    		}
		    	}
	    		
	    		if (row == board.length && col == board[0].length) {
	    			System.out.println("row: " + row + " col: " + col);
	    			return false;
	    		}
	    		
			} else {
				if (existsub(board, word, index, row, col, trueboard) ) {
					index++;
				} else {
					index--;
				}
			}
		}
		
		return true;
        
    }
    
    public static boolean existsub(char[][] board, String word, int startindex, int startrow, int startcol, boolean[][] trueboard) {
    	int index = startindex;
    	int row = startrow;
    	int col = startcol;
    	
    	if (index < word.length()) {
    		/**
    		 * try above
    		 */
    		if (row > 0) {
    			if (board[row - 1][col] == word.charAt(index) && trueboard[row - 1][col] == false ) {
    				row = row - 1; 
    				trueboard[row][col] = true;
    				
    			}
    		}
    		
    		/**
    		 * try below
    		 */
    		if (row < board.length - 1) {
    			if (board[row + 1][col] == word.charAt(index) && trueboard[row + 1][col] == false) {
    				row = row + 1;
    				trueboard[row][col] = true;
    				if (existsub(board, word, index + 1, row, col, trueboard)) {
    					return true;
    				}
    				System.out.println("below: row: " + row + " col: " + col);
    				row = row - 1;
    			}
    		}
    		
    		/**
    		 * try left
    		 */
    		if (col > 0) {
    			if (board[row][col - 1] == word.charAt(index) && trueboard[row][col - 1] == false) {
    				col = col - 1;
    				trueboard[row][col] = true;
    				if (existsub(board, word, index + 1, row, col, trueboard)) {
    					return true;
    				}
    				System.out.println("left: row: " + row + " col: " + col);
    				col = col + 1;
    			}
    		}
    		
    		/**
    		 * try right
    		 */
    		if (col < board[0].length - 1) {
    			if (board[row][col + 1] == word.charAt(index) && trueboard[row][col + 1] == false) {
    				col = col + 1;
    				trueboard[row][col] = true;
    				if (existsub(board, word, index + 1, row, col, trueboard)) {
    					return true;
    				}
    				System.out.println("right: row: " + row + " col: " + col);
    				col = col - 1;
    			}
    		}
        	
    		System.out.println("not found: row: " + row + " col: " + col);
    		trueboard[row][col] = true;
    	} else {
    		return true;
    	}
    	
    	return false;
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[2][2];
		board[0][0] = 'a';
		board[0][1] = 'b';
		board[1][0] = 'c';
		board[1][1] = 'd';
		
		char[][] board1 = new char[3][4];
		board1[0][0] = 'A';
		board1[0][1] = 'B';
		board1[0][2] = 'C';
		board1[0][3] = 'E';
		board1[1][0] = 'S';
		board1[1][1] = 'F';
		board1[1][2] = 'C';
		board1[1][3] = 'S';
		board1[2][0] = 'A';
		board1[2][1] = 'D';
		board1[2][2] = 'E';
		board1[2][3] = 'E';
		
		//System.out.println(exist(board, "cdba"));
		System.out.println(exist(board1, "SEE"));
		
	}

}
