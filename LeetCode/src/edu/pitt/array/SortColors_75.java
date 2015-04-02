/**
 * 
 */
package edu.pitt.array;

/**
 * Sort Colors #75 --- Accepted 192ms/189ms
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem. 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
 * then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * @author yanma
 * @since 2015-04-01
 * @version 2015-04-01
 */
public class SortColors_75 {
	
	/**
	 * Accepted 192ms
	 * @param A
	 */
    public void sortColors1(int[] A) {
    	if (A == null || A.length == 0) {
            return;
        }
        
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for (int i = 0; i < A.length; i++) {
            switch(A[i]) {
                case 0: zero++; break;
                case 1: one++;  break;
                case 2: two++;  break;
                default:        break;
            }
        }
        
        for (int i = 0; i < zero; i++) {
            A[i] = 0;
        }
        for (int i = zero; i < zero + one; i++) {
            A[i] = 1;
        }
        for (int i = zero + one; i < A.length; i++) {
            A[i] = 2;
        }
    }
    
    /**
     * Other's solution 189ms
     * @param A
     */
    public void sortColors(int[] A) {
    	if (A == null || A.length == 0) {
            return;
        }
    	
    	int pointer1 = 0;
    	int pointer2 = A.length - 1;
    	
    	for (int i = 0; i < A.length && pointer2 >= i; i++) {
    		if (A[i] == 0) {
    			int temp = A[i];
    			A[i] = A[pointer1];
    			A[pointer1] = temp;
    			pointer1++;
    		} else if (A[i] == 2) {
    			int temp = A[i];
    			A[i] = A[pointer2];
    			A[pointer2] = temp;
    			pointer2--;
    			i--;
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
