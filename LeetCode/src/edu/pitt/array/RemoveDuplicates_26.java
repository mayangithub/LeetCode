package edu.pitt.array;

/**
 * Remove Duplicates from Sorted Array #26 -- accepted
 * @author yanma
 * @since 2015-02-12
 * @version 2015-02-12
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 */

public class RemoveDuplicates_26 {
	
	/**
	 * function remove duplicate
	 * @param A integer array
	 * @return length of new array
	 * 
	 * because the array is sorted, 
	 * two pointers, j always larger than i
	 * when equal, length reduce and j move to next index
	 * if not equal, copy j to i, and move i forward
	 * j move forward
	 * 
	 * only duplicate occurs, reduce length
	 * 
	 */
	public static int removeDuplicates(int[] A) {
	        int length = A.length;
	        if (length == 0) {
	        	throw new NullPointerException("the array is empty");
	        }
	        
	        int i = 0;
	        int j = i + 1;
	        for (; i < A.length - 1; i++) {
	        	while( j < A.length && A[i] == A[j]) {
	        		A[j] = -1;
	        		j++;
	        		length--;
	        	}
	        	
	        	if (j == A.length) {
	        		return length;
	        	}
	        	
	        	A[i+1] = A[j];
	        	j++;
	        }
	        
	        return length;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		System.out.println("original length: " + A.length);
		int length = removeDuplicates(A);
		
		System.out.println("new length: " + length);
		
		
	}

}
