/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Majority Element II #229 --- Accepted 488ms
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 * @note: using O(n) space and run in linear time
 * @author yanma
 * @since 2015-06-29
 * @version 2015-06-29
 */
public class MajorityElementII_229 {
	
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null) {
            return result;
        }
        
        int bound = (int) Math.floor(nums.length / 3);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x: nums) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                if (map.get(x) <= bound) {
                    map.put(x, map.get(x) + 1);
                } else {
                	continue;
                }
            }
            if (map.get(x) > bound) {
                    result.add(x);
            } 
        }

        return result;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,3,4,5};
		List<Integer> list = majorityElement(nums);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}

}
