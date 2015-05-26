/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II #90 --- Accepted 368ms/328ms
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *  Note:
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *  For example,
 *  If nums = [1,2,2], a solution is:
 *  [
 *    [2],
 *    [1],
 *    [1,2,2],
 *    [2,2],
 *    [1,2],
 *    []
 *  ]
 * @author yanma
 * @since 2015-05-25
 * @version 2015-05-25
 */
public class SubsetsII_90 {

	/**
	 * Accepted 368ms
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
        	return list;
        } else if (nums.length == 0) {
        	List<Integer> inner = new ArrayList<>();
        	list.add(inner);
        	return list;
        } 
        Arrays.sort(nums);
        helper(nums, 0, list, new ArrayList<Integer>());
        return list;
    }
    
    public static void helper(int[] nums, int start, List<List<Integer>> list, List<Integer> inner) {
    	if (nums == null || start > nums.length) {
    		return;
    	}
    	
    	if (!list.contains(inner)) {
        	list.add(new ArrayList<>(inner));
    	}
    	for (int index = start; index < nums.length; index++) {
    		inner.add(nums[index]);
    		helper(nums, index + 1, list, inner);
    		inner.remove(inner.size() - 1);
    	}
    }
    
    
    /**
     * Accepted 328ms
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
        	return list;
        } else if (nums.length == 0) {
        	List<Integer> inner = new ArrayList<>();
        	list.add(inner);
        	return list;
        } 
        Arrays.sort(nums);
        //add empty inner list
        list.add(new ArrayList<Integer>());
        //add first num
        List<Integer> inner = new ArrayList<>();
        inner.add(nums[0]);
        list.add(inner);
        int size = 0;
        int length = 0;    	
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == nums[i - 1]) {
        		size = (length == 0) ? 1: length;
        		length = list.size();
        		for (int index = size; index < length; index++) {
        			List<Integer> innerlist = new ArrayList<>(list.get(index));
        			innerlist.add(nums[i]);
        			list.add(innerlist);
        		}
        	} else {
        		length = list.size();
        		for (int k = 0; k < length; k++) {
        			List<Integer> innerlist = new ArrayList<>(list.get(k));
        			innerlist.add(nums[i]);
        			list.add(innerlist);
        		}
        	}
        }
        return list;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2};
		List<List<Integer>> list = subsetsWithDup1(nums);
		System.out.println("[");
		for (List<Integer> inner: list) {
			System.out.print("[");
			for (int i = 0; i < inner.size(); i++) {
				System.out.print(inner.get(i));
				if (i < inner.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

}
