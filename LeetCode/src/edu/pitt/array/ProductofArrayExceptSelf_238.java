/**
 * 
 */
package edu.pitt.array;

/**
 * Product of Array Except Self #238 --- Accepted
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: 
 * The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author yanma
 * @since 2015-07-18
 * @version 2015-07-18
 */
public class ProductofArrayExceptSelf_238 {
	
	
	/**
	 * O(1) extra space, O(2n) time
	 * @param nums
	 * @return
	 */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        int size = nums.length;
        int[] result = new int[size];
        result[size - 1] = 1;

        for (int i = size - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        
        int left = 1;
        
        for (int i = 1; i < size; i++) {
            left *= nums[i - 1];
            result[i] *= left;
        }
        
        return result;
    }
    
    /**
     * O(n) extra space, O(n) time
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null) {
            return null;
        }
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int[] result = new int[size];
        right[size - 1] = 1;
        left[0] = 1;
        
        for (int i = size - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for (int i = 1; i < size; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        for (int i = 0; i < size; i++) {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }

}
