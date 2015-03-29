/**
 * 
 */
package edu.pitt.array;

/**
 * Search for a Range #34 --- Accepted 240ms
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 * @author yanma
 * @since 2015-03-29
 * @version 2015-03-29
 */
public class SearchForARange_34 {
    public int[] searchRange(int[] A, int target) {
    	int[] range = new int[2];
    	range[0] = -1;
    	range[1] = -1;
        if (A == null || target < A[0] || target > A[A.length - 1]) {
        	return range;
        } else if (A.length == 1 && target == A[0]) {
        	range[0] = 0;
        	range[1] = 0;
        	return range;
        } 
        
        int left = 0;
        int right = A.length - 1;
        int mid = (left + right) / 2;
        int start = range[0];
        int end = range[1];
    	if (A[mid] == target) {
    		start = mid;
    		end = mid;
    		int[] larray = java.util.Arrays.copyOfRange(A, left, mid + 1);
    		int[] leftrange = searchRange(larray, target);
    		if (leftrange[0] + left < start) {
    			start = leftrange[0] + left;
    		}
    		int[] rarray = java.util.Arrays.copyOfRange(A, mid + 1, right + 1);
    		int[] rightrange = searchRange(rarray, target);
    		if (rightrange[1] + mid + 1 > end) {
    			end = rightrange[1] + mid + 1;
    		}
    	} else if (A[mid] < target) {
    		int[] riarray = java.util.Arrays.copyOfRange(A, mid + 1, right + 1);
    		int[] rightarr = searchRange(riarray, target);
    		if (rightarr[0] != -1) {
    			start = rightarr[0] + mid + 1;
    			end = rightarr[1] + mid + 1;
    		}
    		
    	} else {
    		int[] learray = java.util.Arrays.copyOfRange(A, left, mid);
    		int[] leftarr = searchRange(learray, target);
    		if (leftarr[0] != -1) {
    			start = leftarr[0] + left;
    			end = leftarr[1] + left;
    		}
    		
    	}
        
    	range[0] = start;
    	range[1] = end;
    	
        return range;
        
    }
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
