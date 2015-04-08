/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;


/**
 * Remove Duplicates from Sorted Array II #80 --- Accepted 235ms
 *  Follow up for "Remove Duplicates":
 *  What if duplicates are allowed at most twice?
 * For example,
 *  Given sorted array A = [1,1,1,2,2,3],
 *  Your function should return length = 5, and A is now [1,1,2,2,3]. 
 * @author yanma
 * @since 2015-04-08
 * @version 2015-04-08
 * **
 * Not only find the length, do the in-place remove as well
 */
public class RemoveDuplicatesFromSortedArrayII_80 {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        } else if (A.length <= 2) {
        	return A.length;
        }
                        
        int length = 2;
        for (int i = 2; i < A.length; i++) {
        	if (A[i] == A[length - 1] && A[i] == A[length - 2]) {
        		continue;
        	} else {
        		A[length] = A[i];
        		length++;
        	}
        }
        
        return length;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,1,2,2,2,3,3,3,4,5,6,6};
		int[] B = {1,1,1,2};
		int[] C = {1,2};
		System.out.println(removeDuplicates(A));
		System.out.println(removeDuplicates(B));
		
		System.out.println(removeDuplicates(C));
	}

}
