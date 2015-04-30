/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * House Robber #198 --- Accepted 247ms
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author yanma
 * @since 2015-04-30
 * @version 2015-04-30
 */
public class HouseRobber_198 {
	
	/**
	 * Accepted 247ms
	 * @param nums
	 * @return 
	 */
    public static int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
        	return nums[0];
        } else if (nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
        	return Math.max(nums[1], nums[0] + nums[2]);
        }
        
    	/**
    	 * Thoughts: 
    	 * 1. include this house, exclude previous house, 
    	 * 2. exclude this house, include previous house, exclude previous house
    	 */
    	
    	int include = 0;
    	int exclude = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		int temp = include;//previous one robbed
    		include = exclude + nums[i];//exclude: previous one not robbed, + this one = this one robbed
    		exclude = Math.max(temp, exclude); // not rob this one, maximum of rob previous one or not rob previous one
    	}
    	
    	return Math.max(include, exclude); // rob/not rob last one, choose the maximum
    }
	
	/**
	 * Exceed Time Limit
	 * @param nums
	 * @return
	 */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
        	return nums[0];
        } else if (nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
        	return Math.max(nums[1], nums[0] + nums[2]);
        }
        
    	int max = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		int total = nums[i] + rob1(nums, i);
    		if (total > max) {
    			max = total;
    		}
    	}
    	
    	return max;
    	
    }
    
    public static int rob1(int[] nums, int startIndex) {
    	if (startIndex >= nums.length - 2) {
    		return 0;
    	} else if (startIndex == nums.length - 3) {
    		return nums[nums.length - 1];
    	}
    	
    	int max = 0;
    	
    	for (int n = 2; startIndex + n < nums.length; n++) {
    		int total = nums[startIndex + n] + rob1(nums, startIndex + n);
    		if (total > max) {
    			max = total;
    		}
    	}
    	
    	return max;
    	
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		System.out.println(rob(nums));
	}

}
