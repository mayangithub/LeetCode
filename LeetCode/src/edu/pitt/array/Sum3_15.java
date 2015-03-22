/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 3Sum #15 --- Accepted 284ms
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @author yanma
 * @since 2015-03-22
 * @version 2015-03-22
 */
public class Sum3_15 {
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
        	return resultList;
        }
        
        java.util.Arrays.sort(num);
        
        
        int first = num[0] - 1;
        for (int i = 0; i < num.length - 2; i++) {
        	if (num[i] == first) {
        		continue;
        	}
        	
        	int start = i + 1;
        	int end = num.length - 1;
        	
        	while (start < end) {
        		int sum = num[i] + num[start] + num[end];
        		if (sum == 0) {
        			List<Integer> result = new ArrayList<Integer>();
        			result.add(num[i]);
        			result.add(num[start]);
        			result.add(num[end]);
        			resultList.add(result);
        			
        			start++;
        			end--;
        			
        			while (start < end && num[start] == num[start - 1]) {
        				start++;
        			}
        			
        			while (start < end && num[end] == num[end + 1]) {
        				end--;
        			}
        		} else if (sum > 0) {
        			end--;
        		} else if (sum < 0) {
        			start++;
        		}
        	}
        	
        	first = num[i];
        }
        
        return resultList;
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
