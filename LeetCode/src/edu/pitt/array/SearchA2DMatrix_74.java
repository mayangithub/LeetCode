/**
 * 
 */
package edu.pitt.array;

/**
 * Search a 2D Matrix #74 --- Accepted 229ms
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * @author yanma
 * @since 2015-04-01
 * @version 2015-04-01
 */
public class SearchA2DMatrix_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
        	return false;
        } else if (matrix.length == 1 && matrix[0].length == 1) {
        	if (matrix[0][0] == target) {
        		return true;
        	} else {
        		return false;
        	}
        } 

        int startrow = 0;
        int endrow = matrix.length - 1;
        int midrow = (startrow + endrow) / 2;
        
        if (matrix.length > 1) {
            if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
             	return false;
            }
            
        	if (target > matrix[midrow][matrix[0].length - 1]) { // bottom half
        		int[][] submatrix = java.util.Arrays.copyOfRange(matrix, midrow + 1, endrow + 1);
        		return searchMatrix(submatrix, target);
        	} else if (target < matrix[midrow][0]) {
        		int[][] submatrix = java.util.Arrays.copyOfRange(matrix, startrow, midrow);
        		return searchMatrix(submatrix, target);
        	} else {
        		int[][] row = java.util.Arrays.copyOfRange(matrix, midrow, midrow + 1);
        		return searchMatrix(row, target);
        	}
        } else {
        	//only one row left
        	int[] subrow = matrix[0];
        	return searchRow(subrow, target);
    		
        }
    }
    
    public boolean searchRow(int[] row, int target) {
    	if (row == null || row.length == 0) {
    		return false;
    	} else if (row.length == 1) {
    		if (row[0] == target) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    	    if (target > row[row.length - 1] || target < row[0]) {
    	        return false;
    	    }
    		int left = 0;
    		int right  = row.length - 1;
    		int mid = (left + right) / 2;
    		
    		if (row[mid] == target) {
    			return true;
    		} else if (row[mid] < target) {
    			int[] subrow = java.util.Arrays.copyOfRange(row, mid + 1, right + 1);
    			return searchRow(subrow, target);
    		} else {
    			int[] subrow = java.util.Arrays.copyOfRange(row, left, mid);
    			return searchRow(subrow, target);
    		}
    	}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
