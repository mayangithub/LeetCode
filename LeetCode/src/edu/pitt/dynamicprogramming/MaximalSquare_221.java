/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Maximal Square #221 --- Accepted 320ms
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4. 
 * @author yanma
 * @since 2015-06-03
 * @version 2015-06-03
 *
 */
public class MaximalSquare_221 {

	
    public static int maximalSquare(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	} else if (matrix.length == 1) { // only one row
    		return rowMax(matrix);
    	} else if (matrix[0].length == 1) { // only one col
    		return colMax(matrix);
    	}
    	
    	int[][] maxmatrix = new int[matrix.length][matrix[0].length];
    	int max = copyMatrix(matrix, maxmatrix);
//    	printMatrix(maxmatrix);
//    	System.out.println();
    	
    	for (int i = matrix.length - 2; i >= 0; i--) { // each row, exclude last row
			for (int j = matrix[0].length - 2; j >= 0; j--) { // each col, exclude last col
				if (matrix[i][j] == '1') {
					maxmatrix[i][j] = findMin(maxmatrix[i + 1][j], maxmatrix[i + 1][j + 1], maxmatrix[i][j + 1]) + 1;
					max = (maxmatrix[i][j] > max) ? maxmatrix[i][j]: max;
				}
			}
		}    	
//    	printMatrix(maxmatrix);
//    	
//    	System.out.println("max: " + max);
    	
    	return (int) Math.pow(max, 2);
    }
    
    public static int rowMax(char[][] matrix) {
    	for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1') {
				return 1;
			}
		}
    	return 0;
    }
    
    public static int colMax(char[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == '1') {
				return 1;
			}
		}
    	return 0;
    }
    
    public static int copyMatrix(char[][] matrix, int[][] maxmatrix) {
    	int max = 0;
    	for (int col = 0; col < matrix[0].length; col++) {
    		maxmatrix[matrix.length - 1][col] = matrix[matrix.length - 1][col] - '0'; 
    		if (max == 0 && maxmatrix[matrix.length - 1][col] == 1) {
    			max = 1;
    		}
    	}
    	for (int row = 0; row < maxmatrix.length - 1; row++) {
			maxmatrix[row][maxmatrix[0].length - 1] = matrix[row][matrix[0].length - 1] - '0';
			if (max == 0 && maxmatrix[row][maxmatrix[0].length - 1] == 1) {
				max = 1;
			}
		}
    	
    	return max;
    }
    
    public static int findMin(int a, int b, int c) {
    	return Math.min(Math.min(a, b), c);
    }
    
    
    public static void printMatrix(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
		
		System.out.println(maximalSquare(matrix));
		
	}

}
