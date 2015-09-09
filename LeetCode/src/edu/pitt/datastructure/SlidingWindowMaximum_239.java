/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum #239 --- Accepted
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * @author yanma
 * @version 2015-09-08
 */
public class SlidingWindowMaximum_239 {
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = {};
        if (nums == null || nums.length < k || k == 0) {
            return result;
        }
        result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) { // initialization
            while (deque.size() > 0 && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            while (deque.size() > 0 && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]); // add one
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst(); // remove one
            }
            result[i - k + 1] = deque.peekFirst(); // get max
        }
        
        return result;
    }

}
