/**
 * 
 */
package edu.pitt.divideandconquer;

/**
 * Search a 2D Matrix II #240 --- Accepted 680ms
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *     Integers in each row are sorted in ascending from left to right.
 *     Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * @author yanma
 * @since 2015-07-24
 * @version 2015-07-24
 */
public class Searcha2DMatrixII_240 {
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int c = 0; c < cols; c++) {
            int start = 0;
            int end = rows - 1;
            if (matrix[end][c] < target) {
                continue; 
            }
            if (matrix[start][c] > target) {
                break;
            }
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (matrix[mid][c] == target) {
                    return true;
                } else if (matrix[mid][c] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
            if (matrix[start][c] == target || matrix[end][c] == target) {
                return true;
            } 
        }
        
        return false;
    }

}
