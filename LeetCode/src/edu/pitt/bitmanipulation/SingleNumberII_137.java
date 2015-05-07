/**
 * 
 */
package edu.pitt.bitmanipulation;

/**
 * Single Number II #137 --- Accepted 327ms/372ms
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 * @author yanma
 * @since 2015-05-07
 * @version 2015-05-07
 */
public class SingleNumberII_137 {
	
	/**
	 * Accepted 327ms
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        if (nums == null) {
        	return -1;
        } else if (nums.length < 3) {
        	return nums[0];
        }
        
        int ones = 0;
        int twos = 0;
        int threes = 0;

        for (int i = 0; i < nums.length; i++) {
        	twos = (ones & nums[i]) | twos; 
        	ones = ones ^ nums[i];
        	threes = ones & twos;
        	ones = ones & ~threes;
        	twos = twos & ~threes;
        }
        
        return ones;
    }
    
    /**
     * Accepted 372ms
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
    	if (nums == null) {
        	return -1;
        } else if (nums.length < 3) {
        	return nums[0];
        }
    	
    	java.util.Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length; i = i + 3) {
    		if (i + 2 < nums.length && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
    			continue;
    		} else {
				return nums[i];
			}
    	}
    	
    	return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
