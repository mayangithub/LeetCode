/**
 * 
 */
package edu.pitt.array;

/**
 * Move Zeroes #283 --- Accepted
 *  Given an array nums, 
 *  write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 * @author yanma
 * @version 2015-09-22
 * @week 8 0921-0927
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0; // next non-zero element index
        int j = 0; // next zero element index
        while (i < nums.length && j < nums.length) {
            while (j < nums.length && nums[j] != 0) { //note: j valid
                j++;
            }
            while (i < nums.length && nums[i] == 0) { // note: i valid
                i++;
            }
            if (i == nums.length || j == nums.length) return;
            if (i > j) { 
                nums[j] = nums[i];
                nums[i] = 0;
            } else { // sorted subarray
                i++;
            }
        }
        
    }

}
