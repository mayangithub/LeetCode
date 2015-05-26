/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Unique Paths II #63 --- Accepted 292ms
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * @author yanma
 * @since 2015-05-25
 * @version 2015-05-25
 */
public class UniquePathsII_63 {

	/**
	 * Accepted 292ms
	 * @param obstacleGrid
	 * @return
	 */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 1. go through grid, make all '1' to '-1'
         * 2. make cells != '-1' in row0, col0 to 1
         * 3. from [1][1], cell != -1, cell = [row + 1][col] + [row][col + 1]
         *    if any one of the cell is '-1', the cell = the other cell, 
         *    two cells are '-1', cell = 0
         *    
         * Note: 
         * 1. first row, first column, if there's an obstacle, the cells after it would not be arrived, should be obstacles
         * 2. input {{0}}, expected output 1, input {{1}}, expected output 0, input{{1, 0}}, expected output 0.
         */
    	if (obstacleGrid == null) {
    		return 0;
    	} 
    	
    	int rows = obstacleGrid.length;
    	int cols = obstacleGrid[0].length;
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < cols; col++) {
    			if (obstacleGrid[row][col] == 1) {
    				obstacleGrid[row][col] = -1;
    			}
    		}
    	}
    	
    	boolean flag = true;
    	for (int col = 0; col < cols; col++) {
    		if (obstacleGrid[0][col] != -1 && flag) {
    			obstacleGrid[0][col] = 1;
    		} else {
    			flag = false;
    			obstacleGrid[0][col] = -1;
    		}
    	}
    	
    	flag = true;
    	for (int row = 0; row < rows; row++) {
    		if (obstacleGrid[row][0] != -1 && flag) {
    			obstacleGrid[row][0] = 1;
    		} else {
				flag = false;
				obstacleGrid[row][0] = -1;
			}
    	}
    	
    	for (int row = 1; row < rows; row++) {
    		for (int col = 1; col < cols; col++) {
    			if (obstacleGrid[row][col] != -1) {
    				if (obstacleGrid[row - 1][col] == -1 && obstacleGrid[row][col - 1] == -1) {
        				obstacleGrid[row][col] = 0;
        			} else if (obstacleGrid[row - 1][col] == -1) {
        				obstacleGrid[row][col] = obstacleGrid[row][col - 1];
        			} else if (obstacleGrid[row][col - 1] == -1) {
        				obstacleGrid[row][col] = obstacleGrid[row - 1][col];
        			} else {
        				obstacleGrid[row][col] = obstacleGrid[row - 1][col] + obstacleGrid[row][col - 1];
        			}
    			}
    		}
    	}
    	
    	return obstacleGrid[rows - 1][cols - 1] == -1 ? 0: obstacleGrid[rows - 1][cols - 1];
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		int[][] grid = {{1},{0}};
		System.out.println(uniquePathsWithObstacles(grid));
		
		
	}

}
