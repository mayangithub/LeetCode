/**
 * 
 */
package edu.pitt.BFS;

/**
 * Number of Islands #200 --- Accepted 368ms
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * @author yanma
 * @since 2015-06-02
 * @version 2015-06-02
 */
public class NumberofIslands_200 {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
        	for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					num++;
					removeIsland(grid, row, col);
				}
			}
        }
        
        return num;
    }
    
    //remove adjacent '1's 
    public static void removeIsland(char[][] grid, int row, int col) {
    	grid[row][col] = '0';
    	if (row > 0) {
    		if (grid[row - 1][col] == '1') {
    			removeIsland(grid, row - 1, col);
    		}
    	}
    	
    	if (row < grid.length - 1) {
    		if (grid[row + 1][col] == '1') {
    			removeIsland(grid, row + 1, col);
    		}
    	}
    	
    	if (col > 0) {
    		if (grid[row][col - 1] == '1') {
    			removeIsland(grid, row, col - 1);
    		}
    	}
    	
    	if (col < grid[0].length - 1) {
    		if (grid[row][col + 1] == '1') {
    			removeIsland(grid, row, col + 1);
    		}
    	}
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid1 = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		char[][] grid2 = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
		
		System.out.println("grid1: " + numIslands(grid1));
		System.out.println("grid2: " + numIslands(grid2));
	}

}
