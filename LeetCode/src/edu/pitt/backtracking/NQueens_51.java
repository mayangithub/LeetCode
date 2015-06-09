/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens #51 --- Accepted 304ms
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
    [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],
     
    ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
 * ]
 * @author yanma
 * @since 2015-06-09
 * @version 2015-06-09
 */
public class NQueens_51 {

    public List<String[]> solveNQueens(int n) {
    	List<String[]> list = new ArrayList<String[]>();
        if (n == 0) {
        	return list;
        }
        
        helper(n, list, new ArrayList<Integer>());
        
        return list;
    }
    
    public void helper(int n, List<String[]> list, List<Integer> cols) {
    	if (cols.size() == n) {
    		drawboard(list, cols); return;
    	}
    	
    	for (int col = 0; col < n; col++) {
			if (!isvalid(cols, col))  continue;
			else {
				cols.add(col);
				helper(n, list, cols);
				cols.remove(cols.size() - 1);
			}
		}
    }
    
    
    public void drawboard(List<String[]> list, List<Integer> cols) {
    	int n = cols.size();
    	String[] board = new String[n];
    	for (int i = 0; i < n; i++) {
    		board[i] = "";
			int col = cols.get(i);
			int j = 0;
			while (j < n) {
				if (j == col) board[i] += "Q";
				else board[i] += ".";
				j++;
			}
		}
    	list.add(board);
    }
    
    public boolean isvalid(List<Integer> cols, int col) {
    	for (int row = 0; row < cols.size(); row++) { 
    		int c = cols.get(row);
    		if (col == c) return false;                    //same col
    		if (cols.size() - row == col - c) return false;//from left upper corner to right lower corner
    		if (cols.size() - row == c - col) return false;//from right upper corner to left lower corner
		}
    	
    	return true;
    }
    
    
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
