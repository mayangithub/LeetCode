/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum #39 --- unfinished
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
 * @version 2015-04-08
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    
    public void combinationSubsum(int[] candidates, int target, int index, List<List<Integer>> resultList, List<Integer> innerList) {
    	if (target < candidates[index]) {
    		return ;
    	} else if (target == candidates[index]) {
    		innerList.add(target);
    		return;
    	}
    	
    	resultList.add(innerList);
    	
    	for (int i = index; i <= candidates.length - 1 && candidates[i] <= target; i++) {
    		innerList.add(candidates[i]);
    		combinationSubsum(candidates, target - candidates[i], i, resultList, innerList);
    		innerList.remove(innerList.size() - 1 );
    		while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
    			i++;
    		}
    	}
    	    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
