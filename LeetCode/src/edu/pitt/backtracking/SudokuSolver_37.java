/**
 * 
 */
package edu.pitt.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku Solver #37 --- Accepted 512ms
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution. 
 * @author yanma
 * @since 2015-06-18
 * @version 2015-06-18
 */
public class SudokuSolver_37 {
	
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
        	return;
        }
        
        fill(board);
        return;
    }
    
    
    
    public static boolean fill(char[][] board) {
    	
    	for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char c = board[row][col];
				if (c == '.') {
					for (int num = 1; num <= 9; num++) {
						board[row][col] = (char) ('0' + num);
						if (isfillable(board, row, col)) {
							if (fill(board)) {
								return true;
							}
						}
						board[row][col] = '.';
					}
					return false;
				}
			}
		}	
    			
    	return true;		
    }
    
    
    public static boolean isfillable(char[][] board, int row, int col) {
		Set<Character> containSet = new HashSet<Character>();
		
		//scan row
		for (int i = 0; i < 9; i++) {
			if (containSet.contains(board[row][i])) {
				return false;
			}
			if (board[row][i] > '0' && board[row][i] <= '9') {
				containSet.add(board[row][i]);
			}
		}
		
		//scan col
		containSet = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			if (containSet.contains(board[i][col])) {
				return false;
			}
			if (board[i][col] > '0' && board[i][col] <= '9') {
				containSet.add(board[i][col]);
			}
		}
		
		
		//scan square
		containSet = new HashSet<Character>();
		int startrow = (row / 3) * 3;
		int startcol = (col / 3) * 3;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (containSet.contains(board[startrow + r][startcol + c])) {
					return false;
				}
				if (board[startrow + r][startcol + c] > '0' && board[startrow + r][startcol + c] <= '9') {
					containSet.add(board[startrow + r][startcol + c]);
				}
			}
		}
		
    	return true;
    }
    
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};
		
		solveSudoku(board);
		
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + ",");
			}
		}
		
		

	}

}
