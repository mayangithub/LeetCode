/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Unique Paths #62 --- Accepted 192ms
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *  ________________________________________________
 * |Robot |      |      |      |      |      |      |
 * |______|______|______|______|______|______|______|
 * |      |      |      |      |      |      |      |
 * |______|______|______|______|______|______|______|
 * |      |      |      |      |      |      |Finish|
 * |______|______|______|______|______|______|______|
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * @author yanma
 * @since 2015-05-10
 * @version 2015-05-10
 */
public class UniquePaths_62 {
	
	/**
	 * Accepted 192ms
	 * @param m
	 * @param n
	 * @return
	 */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        } else if (m == 1 || n == 1) {
        	return 1;
        }
        
        int[][] pathMatrix = new int[m + 1][n + 1]; 
    	pathMatrix[0][0] = 0;
    	for (int row = 0; row < m + 1; row++) {
    		pathMatrix[row][0] = 0;
    		pathMatrix[row][1] = 1;
    	}
    	
    	for (int col = 0; col < n + 1; col++) {
    		pathMatrix[0][col] = 0;
    		pathMatrix[1][col] = 1;
    	}
    	
    	for (int row = 2; row < m + 1; row++) {
    		for (int col = 2; col < n + 1; col++) {
    			pathMatrix[row][col] = pathMatrix[row - 1][col] + pathMatrix[row][col - 1];
    		}
    	}
    	
    	return pathMatrix[m][n];    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
