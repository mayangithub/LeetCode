/**
 * 
 */
package edu.pitt.array;

/**
 * Spiral Matrix II #59 --- Accepted 207ms
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author yanma
 * @since 2015-03-31
 * @version 2015-03-31
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
        if (n == 0) {
        	return matrix;
        } if (n == 1) {
        	matrix[0][0] = n;
        	return matrix;
        }
        
        if (n % 2 == 1) {
        	matrix[n / 2][n / 2] = n * n;
        }
        
        int num = 1;
        int cycle = 0;
        
        while (cycle < n / 2) {
        	for (int col = cycle; col < n - 1 - cycle; col++) {
        		matrix[cycle][col] = num;
        		num++;
        	}
        	
        	for (int row = cycle; row < n - 1 - cycle; row++) {
        		matrix[row][n - 1 - cycle] = num;
        		num++;
        	}
        	
        	for (int col = n - 1 - cycle; col > cycle; col--) {
        		matrix[n - 1 - cycle][col] = num;
        		num++;
        	}
        	
        	for (int row = n - 1 - cycle; row > cycle; row--) {
        		matrix[row][cycle] = num;
        		num++;
        	}
        	
        	cycle++;
        }
        
        return matrix;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
