/**
 * 
 */
package edu.pitt.BFS;

/**
 * Surrounded Regions #130 --- Accepted 354ms
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * @author yanma
 * @since 2015-05-11
 * @version 2015-05-11
 */


public class SurroundedRegions_130 {
	static class Cell {
		int row;
		int col;
		boolean[] directions;
		public Cell(int r, int c) {
			this.row = r;
			this.col = c;
			this.directions = new boolean[4];
		}
	}
	/**
	 * Steps:
	 * 1. mark all "O" on border as "B"
	 * 2. iterate through "O" cells inside border, 
	 * 	  if it connects with "B", mark it as "B"; 
	 * 	  if it connects with "X" in all directions, mark it as "X".
	 * 4. capture all "B" as "O"
	 */
	
    public static void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
        	return;
        }
        
        int height = board.length;
        int width = board[0].length;
        
        for (int col = 0; col < width; col++) {
        	fill(board, 0, col);
        	fill(board, height - 1, col);
        }
    	
        
    	for (int row = 0; row < height; row++) {
    		fill(board, row, 0);
    		fill(board, row, width - 1);
    	}
        		
        captureO(board);
        
        captureB(board);
    }
    
    /**
     * from border cell to inner cells
     * blood fill algorithm
     * @param board
     * @param row
     * @param col
     */
    public static void fill(char[][] board, int row, int col) {
    	if (board[row][col] != 'O') {
    		return;
    	} else {
    		board[row][col] = 'B';
    	}
    	
    	java.util.Stack<Cell> stack = new java.util.Stack<>();
    	Cell currCell = new Cell(row, col);
    	stack.push(currCell);
    	
    	while (!stack.isEmpty()) {
			Cell cell = stack.pop();
			int r = cell.row;
			int c = cell.col;
			//top cell
			if (r - 1 >= 0 && board[r - 1][c] == 'O') {
				board[r - 1][c] = 'B';
				Cell next = new Cell(r - 1, c);
				stack.push(next);
			}
			//down cell
			if (r + 1 < board.length && board[r + 1][c] == 'O') {
				board[r + 1][c] = 'B';
				Cell next = new Cell(r + 1, c);
				stack.push(next);
			}
			//left cell
			if (c - 1 >= 0 && board[r][c - 1] == 'O') {
				board[r][c - 1] = 'B';
				Cell next = new Cell(r, c - 1);
				stack.push(next);
			}
			//right cell
			if (c + 1 < board[0].length && board[r][c + 1] == 'O') {
				board[r][c + 1] = 'B';
				Cell next = new Cell(r, c + 1);
				stack.push(next);
			}
		}
    	
    }
    
    public static void captureB(char[][] board) {
    	for (int row = 0; row < board.length; row++) {
    		for (int col = 0; col < board[0].length; col++) {
    			if (board[row][col] == 'B') {
    				board[row][col] = 'O';
    			}
    		}
    	}
    }
    
    public static void captureO(char[][] board) {
    	for (int row = 1; row < board.length - 1; row++) {
    		for (int col = 1; col < board[0].length - 1; col++) {
    			if (board[row][col] == 'O') {
    				board[row][col] = 'X';
    			}
    		}
    	}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[4][6];
		board[0][0] = 'X'; board[0][1] = 'O'; board[0][2] = 'X'; board[0][3] = 'O'; board[0][4] = 'X'; board[0][5] = 'O';
		board[1][0] = 'O'; board[1][1] = 'X'; board[1][2] = 'O'; board[1][3] = 'X'; board[1][4] = 'O'; board[1][5] = 'X';
		board[2][0] = 'X'; board[2][1] = 'O'; board[2][2] = 'X'; board[2][3] = 'O'; board[2][4] = 'X'; board[2][5] = 'O';
		board[3][0] = 'O'; board[3][1] = 'X'; board[3][2] = 'O'; board[3][3] = 'X'; board[3][4] = 'O'; board[3][5] = 'X';
				
		System.out.println("original board: ");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
				if (col == board[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
		
		solve(board);
		System.out.println("mark border: ");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
				if (col == board[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
			
		char[][] board1 = new char[3][3];
		board1[0][0] = 'X'; board1[0][1] = 'O'; board1[0][2] = 'X'; 
		board1[1][0] = 'X'; board1[1][1] = 'O'; board1[1][2] = 'X'; 
		board1[2][0] = 'X'; board1[2][1] = 'O'; board1[2][2] = 'X'; 
				
		System.out.println("original board: ");
		for (int row = 0; row < board1.length; row++) {
			for (int col = 0; col < board1[0].length; col++) {
				System.out.print(board1[row][col] + " ");
				if (col == board1[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
		
		solve(board1);
		System.out.println("mark border: ");
		for (int row = 0; row < board1.length; row++) {
			for (int col = 0; col < board1[0].length; col++) {
				System.out.print(board1[row][col] + " ");
				if (col == board1[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
		
		char[][] board2 = new char[5][5];
		board2[0][0] = 'O'; board2[0][1] = 'X'; board2[0][2] = 'X'; board2[0][3] = 'O'; board2[0][4] = 'X';
		board2[1][0] = 'X'; board2[1][1] = 'O'; board2[1][2] = 'O'; board2[1][3] = 'X'; board2[1][4] = 'O';
		board2[2][0] = 'X'; board2[2][1] = 'O'; board2[2][2] = 'X'; board2[2][3] = 'O'; board2[2][4] = 'X';
		board2[3][0] = 'O'; board2[3][1] = 'X'; board2[3][2] = 'O'; board2[3][3] = 'O'; board2[3][4] = 'O';
		board2[4][0] = 'X'; board2[4][1] = 'X'; board2[4][2] = 'O'; board2[4][3] = 'X'; board2[4][4] = 'O';
		
		System.out.println("original board: ");
		for (int row = 0; row < board2.length; row++) {
			for (int col = 0; col < board2[0].length; col++) {
				System.out.print(board2[row][col] + " ");
				if (col == board2[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
		
		solve(board2);
		System.out.println("mark border: ");
		for (int row = 0; row < board2.length; row++) {
			for (int col = 0; col < board2[0].length; col++) {
				System.out.print(board2[row][col] + " ");
				if (col == board2[0].length - 1) {
					System.out.println("");
				}
			}
		}
		System.out.println("");
	}

}
