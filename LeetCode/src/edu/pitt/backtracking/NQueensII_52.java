/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens II #52 --- Accepted 213ms
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author yanma
 * @since 2015-06-09
 * @version 2015-06-09
 */
public class NQueensII_52 {

    public int totalNQueens(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int count = 0;
        count = helper(0, new ArrayList<Integer>(), n);
        return count;
    }
    
    public int helper(int count, List<Integer> cols, int n) {
    	if (cols.size() == n) return ++count;
    	
    	for (int col = 0; col < n; col++) {
			if (!isValidCol(cols, col)) continue;
			cols.add(col);
			count = helper(count, cols, n);
			cols.remove(cols.size() - 1);
		}
    	return count;
    }
    
    public boolean isValidCol(List<Integer> cols, int col) {
    	int r1 = cols.size(); //new row
    	for (int i = 0; i < r1; i++) { //i: old row
			int c = cols.get(i); //c: old col
			if (c == col) return false;
			if (r1 - i == col - c) return false;
			if (r1 - i == c - col) return false;
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
