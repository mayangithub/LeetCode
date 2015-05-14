/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum II #40 --- Accepted 366ms
 *  Given a collection of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.
 *  Each number in C may only be used once in the combination.
 * Note:
 *  All numbers (including target) will be positive integers.
 *  Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *  The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 *  [1, 7]
 *  [1, 2, 5]
 *  [2, 6]
 *  [1, 1, 6] 
 * @author yanma
 * @since 2015-05-14
 * @version 2015-05-14
 */
public class CombinationSumII_40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
        	return resultList;
        }
        
        java.util.Arrays.sort(candidates);
        
        if (target < candidates[0]) {
        	return resultList;
        } else if (candidates.length == 1 && candidates[0] == target) {
        	List<Integer> innerList = new ArrayList<Integer>();
        	innerList.add(candidates[0]);
        	resultList.add(innerList);
        	return resultList;
        }
        
        helper(candidates, target, resultList, new ArrayList<Integer>(), 0);
        
        return resultList;
    }
    
    public static void helper(int[] candidates, int target, List<List<Integer>> resultlist, List<Integer> innerList, int start) {
    	if (start == candidates.length && target > 0) {
    		return;
    	} 
    	if (target == 0) {
    		List<Integer> newInnerList = new ArrayList<>();
    		newInnerList.addAll(innerList);
    		if (!resultlist.contains(newInnerList)) {
        		resultlist.add(newInnerList);
    		}
    		return;
    	}
    	
    	for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
    		innerList.add(candidates[i]);
    		helper(candidates, target - candidates[i], resultlist, innerList, i + 1);
    		innerList.remove(innerList.size() - 1);    	
    	}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2, 2, 2};
		int target = 4;
		
		List<List<Integer>> list = combinationSum2(candidates, target);
		for (List<Integer> innerList: list) {
			System.out.print("[");
			for (Integer num: innerList) {
				System.out.print(" " + num + ",");
			}
			System.out.println("]");
		}
		
	}

}
