/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum #39 --- Accepted 398ms
 *  Given a set of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.
 *  The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * 	All numbers (including target) will be positive integers.
 *  Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *  The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * 	A solution set is:
 * 	[7]
 * 	[2, 2, 3] 
 * @author yanma
 * @since 2015-04-08
 * @version 2015-04-15
 */
public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        
        combinationSubsum(candidates, target, 0, resultList, new ArrayList<Integer>());
        return resultList;
    }
    
    public static void combinationSubsum(int[] candidates, int target, int index, List<List<Integer>> resultList, List<Integer> innerList) {
    	if (index == candidates.length) {
    		return;
    	} else if (target == 0) {
    		List<Integer> newInnerList = new ArrayList<>();
    		newInnerList.addAll(innerList);
    		resultList.add(newInnerList);
    		return;
    	}
    	
    	for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
    		innerList.add(candidates[i]);
    		combinationSubsum(candidates, target - candidates[i], i, resultList, innerList);
    		innerList.remove(innerList.size() - 1);
    	}
    	    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		int target = 310;
		
		List<List<Integer>> list = combinationSum(candidates, target);
		for (List<Integer> innerList: list) {
			System.out.print("[");
			for (Integer num: innerList) {
				System.out.print(" " + num + ",");
			}
			System.out.println("]");
		}
		
	}

}
