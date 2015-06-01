/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * House Robber II #213 --- accepted 324ms
 * After robbing those houses on that street, 
 * the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, 
 * the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author yanma
 * @since 2015-05-22
 * @version 2015-05-22
 */
public class HouseRobberII_213 {

	/**
	 * Accepted 324ms
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
        	return nums[0];
        } else if (nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        
        //[0, length - 2] && [1, length - 1]
        int include0 = 0;
        int exclude0 = 0;
        int include1 = 0;
        int exclude1 = 0;
        
        include0 = nums[0];
        
        for (int i = 1; i < nums.length - 1; i++) {
        	int temp0 = include0;
        	int temp1 = include1;
        	include0 = exclude0 + nums[i];
        	include1 = exclude1 + nums[i];
        	exclude0 = Math.max(temp0, exclude0);
        	exclude1 = Math.max(temp1, exclude1);
        }
        
        int temp1 = include1;
        include1 = exclude1 + nums[nums.length - 1];
        exclude1 = Math.max(temp1, exclude1);
        
        return Math.max(Math.max(include0, exclude0), Math.max(include1, exclude1));
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
