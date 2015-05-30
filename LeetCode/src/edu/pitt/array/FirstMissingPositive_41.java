/**
 * 
 */
package edu.pitt.array;

/**
 * First Missing Positive #41 --- Accepted 304ms/240ms
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author Yan-PC
 * @since 2015-05-30
 * @version 2015-05-30
 */
public class FirstMissingPositive_41 {

	/**
	 * Accepted 304ms
	 * @param nums
	 * @return
	 */
    public static int firstMissingPositive(int[] nums) {
        /**
         * create a hash table, key nums[i], value true/false
         * loop nums array, jump over 0 and negative values, store positive value to hash table, find amount of positives k
         * loop hash table from 1 to k, if hashtable doesn't contain key, return key
         */
    	if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] < 1)) {
    		return 1;
    	} 
    	java.util.Hashtable<Integer, Boolean> hashtable = new java.util.Hashtable<Integer, Boolean>();
    	int k = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > 0) {
    			hashtable.put(nums[i], true);
    			k++;
    		}
    	}
    	
    	for (int i = 1; i <= k; i++) {
    		if (!hashtable.containsKey(i)) {
    			return i;
    		}
    	}
    	
    	return k + 1;
    }
	
    
    /**
     * Accepted 240ms/312ms
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        /**
         * make all positive numbers to the front of the array
         * find amount k of all positives
         * from 0 to k - 1, treat each positive as index, if nums[index] > 0, make it negative, 
         * finally, loop through from 1 to k-1 index, if nums[index] > 0, the index is the missing number
         */
    	if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] < 1)) {
    		return 1;
    	} 
    	
    	int k = move(nums);
    	for (int i = 0; i < k; i++) {
    		int temp = (nums[i] < 0)? -nums[i]: nums[i];
			if (temp <= k) {
				nums[temp - 1] = (nums[temp - 1] > 0) ? -nums[temp - 1]: nums[temp - 1];
			}
    	}
    	
    	for (int i = 0; i < k; i++) {
    		if (nums[i] > 0) {
    			return i + 1;
    		}
    	}
    	
    	return k + 1;
    }
    
    public int move(int[] nums) { // return amount of positives
    	int k = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > 0) {
    			swap(nums, i, k);
    			k++;
    		}
    	}
    	return k;
    }
    
    public void swap(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2, 0};
		int[] nums2 = {3, 4, -1, 1};
		
		System.out.println(firstMissingPositive(nums1));
		System.out.println(firstMissingPositive(nums2));
	}

}
