/**
 * 
 */
package edu.pitt.array;

import java.util.HashMap;

/**
 * Longest Consecutive Sequence #128 --- Accepted 374ms
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity. 
 * @author yanma
 * @since 2015-06-08
 * @version 2015-06-08
 */
public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        } else if (nums.length == 1) {
			return 1;
		}
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i : nums) {
			if (map.containsKey(i)) continue;
			int left = 0;
			if (map.containsKey(i - 1)) left = map.get(i - 1);
			int right = 0;
			if (map.containsKey(i + 1)) right = map.get(i + 1);
			int sum = left + right + 1;
			map.put(i, sum);
			max = (sum > max)? sum: max;
			map.put(i - left, sum);
			map.put(i + right, sum);
		}
        
        return max;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
