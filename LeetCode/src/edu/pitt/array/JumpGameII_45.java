/**
 * 
 */
package edu.pitt.array;

/**
 * Jump Game II #45 --- Accepted 456ms 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 * @author yanma
 * @since 2015-06-15
 * @version 2015-06-15
 */
public class JumpGameII_45 {
	
	/**
	 * Accepted 456ms 
	 * using BFS
	 * each step == each level
	 * end >= nums.length - 1, return step + 1
	 * @param nums
	 * @return
	 */
    public static int jump(int[] nums) {
    	if (nums == null || nums.length < 2 || nums[0] == 0) {
        	return 0;
        }
    	int start = 1;
    	int end = nums[0];
    	int step = 0;
    	int index = 1;
    	while (start <= end && end < nums.length - 1) {
    		int max = index;
    		step++;
			for (; index <= end; index++) {
				max = Math.max(index + nums[index], max);
				if (max >= nums.length - 1) {
					return step + 1;
				}
			}
    		start = end + 1;
    		end = max;
    		index = start;
		}
    	
    	return step + 1;
    	
    }
	
	
	/**
	 * TLE
	 * @param nums
	 * @return
	 */
    public static int jump2(int[] nums) {
    	if (nums == null || nums.length < 2) {
        	return 0;
        }
    	
    	int len = nums.length;
    	nums[len - 1] = 0;
    	for (int i = len - 2; i >= 0; i--) {
    		if (nums[i] == 0) {
    			nums[i] = len;
    		} else if (nums[i] >= len - i - 1) {
				nums[i] = 1;
			} else {
				int min = len;
				for (int j = 1; j <= nums[i]; j++) {
					min = Math.min(min, nums[i + j]);
				}
				nums[i] = min + 1;
			}
		}
    	
    	return nums[0];
    }
	
	
	
	/**
	 * TLE
	 * @param nums
	 * @return
	 */
    public static int jump1(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return 0;
        }
        int min = Integer.MAX_VALUE;
        min = findMinSteps(nums, min, 0, 0);
        
        return (min == Integer.MAX_VALUE) ? 0:min;
    }
    
    public static int findMinSteps(int[] nums, int min, int pos, int jumps) {
    	if (pos >= nums.length || jumps >= min - 1 || nums[pos] == 0) {
    		return min;
    	}
    	
    	if (pos == nums.length - 1 && jumps < min) {
    		min = jumps;
    		return min;
    	}
    	
    	for (int i = 1; i <= nums[pos]; i++) {
			min = findMinSteps(nums, min, pos + i, jumps + 1);
		}
    	return min;
    }
    
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
//		int[] nums = {1,2};
		System.out.println(jump(nums));
		
		
	}

}
