/**
 * 
 */
package edu.pitt.array;

/**
 * Find Minimum in Rotated Sorted Array II #154 --- Accepted 376ms
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * @author yanma
 * @since 2015-06-04
 * @version 2015-06-04
 * 
 * Solution:
 * For case where AL == AM == AR, the minimum could be on AM’s left or right side 
 * (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). 
 * In this case, we could not discard either subarrays and therefore such worst case degenerates to the order of O(n).
 */
public class FindMinimuminRotatedSortedArrayII_154 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        } else if (nums.length == 1) {
			return nums[0];
		}

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
