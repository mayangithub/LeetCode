/**
 * 
 */
package edu.pitt.array;

/**
 * Rotate Image #48 --- Accepted 296ms
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * @author yanma
 * @since 2015-05-27
 * @version 2015-05-27
 */
public class RotateImage_48 {
	
	/**
	 * Accepted 296ms
	 * @param matrix
	 */
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
        	return;
        }
        
        int cycle = 1;
        int n = matrix.length;
        while (cycle <= matrix.length / 2) {
        	int blocks = matrix.length - 2 * (cycle - 1) - 1;
        	for (int b = 0; b < blocks; b++) {
        		int temp = matrix[cycle - 1][b + cycle - 1];
        		matrix[cycle - 1][b + cycle - 1] = matrix[n - cycle - b][cycle - 1];
        		matrix[n - cycle - b][cycle - 1] = matrix[n - cycle][n - cycle - b];
        		matrix[n - cycle][n - cycle - b] = matrix[cycle + b - 1][n - cycle];
        		matrix[cycle + b - 1][n - cycle] = temp;
        	}
        	/** _________________________________________________________
        	 * | [cycle - 1][cycle - 1 + b] | [cycle - 1 + b][n - cycle] |
        	 * |____________________________|____________________________|
        	 * | [n - cycle - b][cycle - 1] | [n - cycle][n - cycle - b] |
        	 * |____________________________|____________________________|
        	 */
        	cycle++;
		}        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,2,3,4, 5}, {6,7,8, 9, 10}, {11,12, 13, 14, 15}, {16, 17, 18, 19,20}, {21,22,23,24,25}};
		for (int r = 0; r < 5; r++) {
			System.out.print("| ");
			for (int c = 0; c < 5; c++) {
				if (matrix[r][c] < 10) {
					System.out.print(matrix[r][c] + "  | ");
				} else {
					System.out.print(matrix[r][c] + " | ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println();
		rotate(matrix);
		
		for (int r = 0; r < 5; r++) {
			System.out.print("| ");
			for (int c = 0; c < 5; c++) {
				if (matrix[r][c] < 10) {
					System.out.print(matrix[r][c] + "  | ");
				} else {
					System.out.print(matrix[r][c] + " | ");
				}
				
			}
			System.out.println();
		}
	}

}
