/**
 * 
 */
package edu.pitt.array;


/**
 * Kth Largest Element in an Array #215 --- Accepted 304ms
 * Find the kth largest element in an unsorted array.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author yanma
 * @since 2015-05-22
 * @version 2015-05-22
 */
public class KthLargestElementinanArray_215 {

	/**
	 * Accepted 304ms
	 * @param nums
	 * @param k
	 * @return
	 */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
        	return 0;
        } else if (nums.length == 1 && k == 1) {
        	return nums[0];
        }
        
        java.util.Arrays.sort(nums);
        int i = nums.length - 2;
        int rank = 1;
        while (rank < k && i >= 0) {//same number, increase rank as well
			i--;
			rank++;
		}
        return nums[i + 1];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
