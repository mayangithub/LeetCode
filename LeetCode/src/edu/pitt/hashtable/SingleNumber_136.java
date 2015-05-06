/**
 * 
 */
package edu.pitt.hashtable;

/**
 * Single Number #136 --- Accepted 389ms/358ms
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 * @author yanma
 * @since 2015-05-05
 * @version 2015-05-05
 */
public class SingleNumber_136 {
	/**
	 * Accepted 389ms
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
        	return -1;
        } else if (nums.length == 1) {
        	return nums[0];
        }
        
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        	if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        		i++;
        	} else {
        		return nums[i];
        	}
        }
        return -1;
    }
    
    /**
     * using bit manipulation
     * Accepted 358ms
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
    	if (nums == null || nums.length < 1) {
        	return -1;
        } else if (nums.length == 1) {
        	return nums[0];
        }
        
    	int result = 0;
    	for (int number : nums) {
    		result ^= number;
    	}
    	
    	return result;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
