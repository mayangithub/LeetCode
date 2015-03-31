/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix #54 --- Accepted 192ms
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5]. 
 * @author yanma
 * @since 2015-03-30
 * @version 2015-03-30
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
        	return list;
        } else if (matrix.length == 1) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		list.add(matrix[0][j]);
        	}
        	return list;
        } else if (matrix[0].length == 1) {
            for (int j = 0; j < matrix.length; j++) {
        		list.add(matrix[j][0]);
        	}
        	return list;
        }
        
        int i = 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int limit = (Math.min(m, n) - 1) / 2;
        
        while (i <= limit) {
        	for (int j = i; j < n - 1 - i; j++) {
        		list.add(matrix[i][j]);
        	}
        	for (int j = i; j < m - 1 - i; j++) {
        		list.add(matrix[j][n - 1 - i]);
        	}
        	
        	for (int j = n - 1 - i; j > i; j--) {
        		list.add(matrix[m - 1 - i][j]);
        	}
        	
        	for (int j = m - 1 - i; j > i; j--) {
        		list.add(matrix[j][i]);
        	}
        	
        	i++;
        }
        
        if (m == n && m % 2 == 1) {
        	list.add(matrix[limit][limit]);
        }
        
        return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
