/**
 * 
 */
package edu.pitt.array;

import java.util.TreeSet;

/**
 * Contains Duplicate III #220 --- Accepted 436ms
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array such that the difference between 
 * nums[i] and nums[j] is at most t and the difference between i and j is at most k. 
 * @author yanma
 * @since 2015-06-01
 * @version 2015-06-01
 */
public class ContainsDuplicateIII_220 {

	//using TreeSet to sort set
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
        	return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
        	Integer floor = set.floor(nums[i] + t); // <=
        	Integer ceiling = set.ceiling(nums[i] - t); // >=
        	if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
        		return true;
        	}
        	set.add(nums[i]);
        	if (set.size() == k + 1) {
        		set.remove(nums[i - k]);
        	}
        }
        
        return false;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
