/**
 * 
 */
package edu.pitt.array;

/**
 * 3Sum Closest #16 --- Accepted 258ms
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). 
 * @author yanma
 * @since 2015-03-24
 * @version 2015-03-24
 */
public class Sum3Closest_16 {

    public static int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
        	return 0;
        }
        
        java.util.Arrays.sort(num);
        
    	int closest = num[0] + num[1] + num[num.length - 1];
        
        int prev = num[0] - 1;
        for (int i = 0; i < num.length - 2; i++) {
        	if (num[i] == prev) {
        		continue;
        	}
        	int start = i + 1;
        	int end = num.length - 1;
        	while (start < end) {
        		int sum = num[i] + num[start] + num[end];
        		if (sum == target) {
        			return sum;
        		}
        		
        		if (Math.abs(sum - target) < Math.abs(closest - target)) {
        			closest = sum;
        		}
        		
        		if (sum > target) {
        			end--;
        			while (start < end && num[end] == num[end + 1]) {
	        			end--;
	        		} 
        		} else if (sum < target) {
        			start++;
        			while (start < end && num[start] == num[start - 1]) {
        				start++;
        			}
        		}
        		
        	}
        }
        
        
        return closest;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] num = {-1, 2, 1, -4};
		int[] num1 = {-3,-2,-5,3,-4};
		System.out.println(threeSumClosest(num1, -1));
		
	}

}
