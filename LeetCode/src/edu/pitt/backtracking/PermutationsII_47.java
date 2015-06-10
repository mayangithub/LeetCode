/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations II #47 --- Accepted 332ms
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1]. 
 * @author yanma
 * @since 2015-06-09
 * @version 2015-06-09
 */
public class PermutationsII_47 {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
        	return list;
        } else if (nums.length == 0) {
        	List<Integer> inner = new ArrayList<>();
        	list.add(inner);
        	return list;
        } else if (nums.length == 1) {
        	List<Integer> inner = new ArrayList<>();
        	inner.add(nums[0]);
        	list.add(inner);
        	return list;
		}
        
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(nums, list, new ArrayList<Integer>(), visited);
        return list;
    }
    
    public void helper(int[] nums, List<List<Integer>> list, List<Integer> inner, int[] visited) {
    	if (inner.size() == nums.length) {
    		list.add(new ArrayList<>(inner));
    		return;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1) { //already added to inner
				continue;
			} else if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) { //previous same num hasn't been added
				continue;
			}
    		
    		visited[i] = 1;
    		inner.add(nums[i]);
    		helper(nums, list, inner, visited);
    		inner.remove(inner.size() - 1);
    		visited[i] = 0;
		}
    }
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
