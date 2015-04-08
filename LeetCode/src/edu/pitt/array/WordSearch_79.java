/**
 * 
 */
package edu.pitt.array;

/**
 * Word Search #79 --- Accepted 381ms
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
 * @version 2015-04-08
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
		    		
				if (row == board.length) {
					System.out.println("row: " + row + " col: " + col);
					return false;
				}//not found the first letter
	    		
			} else {
				boolean[][] newtrueboard = new boolean[board.length][board[0].length];
				newtrueboard[row][col] = true;
				if (existsub(board, word, index, row, col, newtrueboard) ) {
					return true;
				} else {
					index = 0;
					trueboard[row][col] = true;
				}
			}
		}
		
		return true;
		        
    }
    
    public static boolean existsub(char[][] board, String word, int index, int row, int col, boolean[][] trueboard) {
    	trueboard[row][col] = true;
    	
    	if (index < word.length()) {
    		/**
    		 * try above
    		 */
    		if (row > 0) {
    			if (board[row - 1][col] == word.charAt(index) && trueboard[row - 1][col] == false ) {
    				
    				if (existsub(board, word, index + 1, row - 1, col, trueboard)) {
        				System.out.println("index: " + index + " row: " + (row - 1) + " col: " + col);
    					return true;
    				} else {
    					System.out.println("above doesn't work.");
    					trueboard[row - 1][col] = false;
    				}
    			}
    		}
    		
    		/**
    		 * try below
    		 */
    		if (row < board.length - 1) {
    			if (board[row + 1][col] == word.charAt(index) && trueboard[row + 1][col] == false) {
    				
    				if (existsub(board, word, index + 1, row + 1, col, trueboard)) {
        				System.out.println("index: " + index + " row: " + (row + 1) + " col: " + col);
    					return true;
    				} else {
    					System.out.println("below doesn't work.");
    					trueboard[row + 1][col] = false;
    				}
    			}
    		}
    		
    		/**
    		 * try left
    		 */
    		if (col > 0) {
    			if (board[row][col - 1] == word.charAt(index) && trueboard[row][col - 1] == false) {
    				
    				if (existsub(board, word, index + 1, row, col - 1, trueboard)) {
        				System.out.println("index: " + index + " row: " + row + " col: " + (col - 1));
    					return true;
    				} else {
    					System.out.println("left doesn't work.");
    					trueboard[row][col - 1] = false;
    				}
    				
    			}
    		}
    		
    		/**
    		 * try right
    		 */
    		if (col < board[0].length - 1) {
    			if (board[row][col + 1] == word.charAt(index) && trueboard[row][col + 1] == false) {
    				
    				if (existsub(board, word, index + 1, row, col + 1, trueboard)) {
        				System.out.println("index: " + index + " row: " + row + " col: " + (col + 1));
    					return true;
    				} else {
    					System.out.println("right doesn't work.");
    					trueboard[row][col + 1] = false;
    				}
    				
    			}
    		}
        	
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
		
		
		char[][] board2 = new char[3][3];
		board2[0][0] = 'C';
		board2[0][1] = 'A';
		board2[0][2] = 'A';
		board2[1][0] = 'A';
		board2[1][1] = 'A';
		board2[1][2] = 'A';
		board2[2][0] = 'B';
		board2[2][1] = 'C';
		board2[2][2] = 'D';
		
		char[][] board3 = new char[3][4];
		board3[0][0] = 'A';
		board3[0][1] = 'B';
		board3[0][2] = 'C';
		board3[0][3] = 'E';
		board3[1][0] = 'S';
		board3[1][1] = 'F';
		board3[1][2] = 'E';
		board3[1][3] = 'S';
		board3[2][0] = 'A';
		board3[2][1] = 'D';
		board3[2][2] = 'E';
		board3[2][3] = 'E';
		
		
		
		System.out.println(exist(board, "cdba"));
		System.out.println(exist(board1, "SEE"));
		System.out.println(exist(board2, "AAB"));
		System.out.println(exist(board3, "ABCESEEEFS"));
		
	}

}
