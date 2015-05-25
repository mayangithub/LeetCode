/**
 * 
 */
package edu.pitt.array;

/**
 * Contains Duplicate #217 --- Accepted 472ms/436ms
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * @author yanma
 * @since 2015-05-25
 * @version 2015-05-25
 */
public class ContainsDuplicate_217 {
	/**
	 * sort array
	 * Accepted 472ms
	 * @param nums
	 * @return
	 */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return false;
        }
        java.util.Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 2; i++) {
        	if (nums[i] == nums[i + 1]) {
        		return true;
        	}
        }
        return false;
    }
    
    
    /**
     * Hash table
     * Accepted 436ms
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
    	if (nums == null || nums.length < 2) {
        	return false;
        }
    	java.util.Hashtable<Integer, Boolean> hashtable = new java.util.Hashtable<>();
    	for (int num: nums) {
    		if (hashtable.containsKey(num)) {
    			return true;
    		} else {
    			hashtable.put(num, Boolean.valueOf(true));
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
