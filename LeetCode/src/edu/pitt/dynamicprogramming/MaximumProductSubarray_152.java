package edu.pitt.dynamicprogramming;

/**
 * Maximum Product Subarray #152 --- Accepted 283ms
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6. 
 * @author yanma
 * @since 2015-05-01
 * @version 2015-05-01
 */
public class MaximumProductSubarray_152 {
	
	/**
	 * Keep track of both max and min of previous multiplication results
	 */
    
    /**
     * accpted 283ms
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
    	/**
    	 * note:
    	 * the min times negative number would be the largest
    	 */
    	if (nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
        	return nums[0];
        }
    	
    	int max = nums[0];
    	int min = nums[0];
    	int result = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		int temp = max;
    		max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]); // max(max*nums[i], nums[i], min*nums[i])
    		min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]); // min(max*nums[i], nums[i], min*nums[i])
    		result = max > result ? max: result;
    	}
    	
    	return result;
    }
    
    /**
     * Accepted 294ms
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
    	if (nums.length == 0) {
    		return 0;
    	} else if (nums.length == 1) {
    		return nums[0];
    	}
    	
    	int[] f = new int[nums.length];
    	int[] g = new int[nums.length];
    	f[0] = nums[0];
    	g[0] = nums[0];
    	int result = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		f[i] = Math.max(Math.max(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
    		g[i] = Math.min(Math.min(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
    		result = f[i]>result? f[i]: result;
    	}
    	
    	return result;
    	
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2};
		int[] num = {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}

}
