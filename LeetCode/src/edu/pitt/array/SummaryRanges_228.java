/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges #228 --- Accepted 320ms
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
 * @author yanma
 * @since 2015-06-25
 * @version 2015-06-25
 */
public class SummaryRanges_228 {
	
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        int start = 0;
        int end = start;
        
        while (end < nums.length) {
			if (end < nums.length - 1 && nums[end + 1] == nums[end] + 1) {
				end++;
				continue;
			}
			
			if (start != end) {
				result.add(nums[start] + "->" + nums[end]);
			} else {
				result.add("" + nums[start]);
			}
			
			start = end + 1;
			end = start;
		}
        
        if (start < nums.length - 1) {
        	result.add(nums[start] + "->" + nums[nums.length - 1]);
        } else if (start == nums.length - 1) {
        	result.add("" + nums[start]);
        }
        
        return result;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,215,216};
 		
		List<String> list = summaryRanges(nums);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
