/**
 * 
 */
package edu.pitt.array;

/**
 * Rotate Array #189 ---Accepted 
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem. 
 * Hint:
 * Could you do it in-place with O(1) extra space? 
 * @author yanma
 * @since 2015-03-13
 * @version 2015-03-15
 */
public class RotateArray_189 {
	
	/**
	 * Time Limit Exceeded
	 */
    public static void rotate1(int[] nums, int k) {
    	int length = nums.length;
        k = k % length;
        
        if (k == 0) {
        	return;
        }
        
        int cycle = 1;
        while (cycle <= k) {
        	int temp = nums[length - 1];
        	for (int index = length - 1; index >= 0; index--) {
        		if (index == 0) {
        			nums[0] = temp;
        		} else {
					nums[index] = nums[index - 1];
				}
        	}
        	cycle++;
        }
    }
    
    /**
     * Accepted 212ms
     */
    public static void rotate2(int[] nums, int k) {
    	int length = nums.length;
    	k = k % length;
        int[] add = new int[k];
        
        for (int i = 0; i < k; i++) {
        	add[i] = nums[i + length - k];
        }
        
        for (int i = length - 1; i >= k; i--) {
        	nums[i] = nums[i - k];
        }
        
        for (int i = 0; i < k; i++) {
        	nums[i] = add[i];
        }
        
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4,5,6,7};
		int k = 13;
		
		rotate2(nums, k);
		System.out.print("["); 
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i != nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}
