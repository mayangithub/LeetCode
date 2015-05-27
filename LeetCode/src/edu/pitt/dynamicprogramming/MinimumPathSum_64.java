/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Minimum Path Sum #64 --- Accepted 360ms
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author yanma
 * @since 2015-05-27
 * @version 2015-05-27
 */
public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
        	return 0;
        } else if (grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        
        //row 0
        for (int col = 1; col < grid[0].length; col++) {
        	grid[0][col] += grid[0][col - 1];
        }
        
        //col 0
        for (int row = 1; row < grid.length; row++) {
        	grid[row][0] += grid[row - 1][0];
        }
        
        //cells >= grid[1][1]
        for (int row = 1; row < grid.length; row++) {
        	for (int col = 1; col < grid[0].length; col++) {
        		grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
        	}
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
