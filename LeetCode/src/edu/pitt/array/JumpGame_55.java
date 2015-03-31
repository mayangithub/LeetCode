/**
 * 
 */
package edu.pitt.array;

/**
 * Jump Game #55 --- Accepted 234ms
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false. 
 * @author yanma
 * @since 2015-03-31
 * @version 2015-03-31
 */
public class JumpGame_55 {
	public boolean canJump(int[] A) {
		if (A == null || A.length <= 1) {
            return true;
        }
        
        int index = A.length - 1;
        while (index > 0) {
            int j = index - 1;
            while (j >= 0) {
                if (A[j] >= index - j) {
                    index = j;
                    break;
                } else {
                    j--;
                }
            }
            
            if (j < 0) {
                return false;
            }
        }
        
        return true;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
