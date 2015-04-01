/**
 * 
 */
package edu.pitt.array;

/**
 * Set Matrix Zeroes #73 --- Accepted 268ms
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * @author yanma
 * @since 2015-03-31
 * @version 2015-03-31
 *
 */
public class SetMatrixZeroes_73 {

    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix[0].length == 0 || matrix.length == 0) {
    		return;
    	}
    	
        java.util.Hashtable<Integer, Boolean> rowHashtable = new java.util.Hashtable<Integer, Boolean>();
        java.util.Hashtable<Integer, Boolean> colHashtable = new java.util.Hashtable<Integer, Boolean>();        
        
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			rowHashtable.put(Integer.valueOf(i), Boolean.valueOf(true));
        			colHashtable.put(Integer.valueOf(j), Boolean.valueOf(true));
        		}
        	}
        }
        
        for (int i = 0; i < matrix.length; i++) {
        	if (rowHashtable.containsKey(Integer.valueOf(i))) {
        		for (int j = 0; j < matrix[0].length; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
        	if (colHashtable.containsKey(Integer.valueOf(j))) {
        		for (int i = 0; i < matrix.length; i++) {
        			matrix[i][j] = 0;
        		}
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
