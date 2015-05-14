/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Maximum Subarray #53 --- Accepted 358ms
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *  the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * @author yanma
 * @since 2015-05-13
 * @version 2015-05-13
 */
public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
        	return nums[0];
        } 
        
        int globalmax = nums[0];
        int localmax = nums[0];
        
        for (int index = 1; index < nums.length; index++) {
        	localmax = Math.max(nums[index], localmax + nums[index]);
        	globalmax = Math.max(globalmax, localmax);
        }
        
        return globalmax;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(nums));
		
	}

}
