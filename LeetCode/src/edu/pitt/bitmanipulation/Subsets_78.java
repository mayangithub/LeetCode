/**
 * 
 */
package edu.pitt.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets #78 --- Accepted 246ms
 *  Given a set of distinct integers, S, return all possible subsets.
 *  Note:
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *  For example,
 *  If S = [1,2,3], a solution is:
 *  [
 *    [3],
 *    [1],
 *    [2],
 *    [1,2,3],
 *    [1,3],
 *    [2,3],
 *    [1,2],
 *    []
 *  ]
 * @author yanma
 * @since 2015-04-02
 * @version 2015-04-02
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
        	return result;
        }
        
        java.util.Arrays.sort(S);
        return subset(S, 0, result, new ArrayList<Integer>());
        
    }
    
    public List<List<Integer>> subset(int[] S, int index, List<List<Integer>> result, List<Integer> list) {
    	if (S == null || index > S.length) {
    		return result;
    	} 
    	
    	result.add(new ArrayList<Integer>(list));
    	for (int i = index; i < S.length; i++) {
    		list.add(S[i]);
    		subset(S, i + 1, result, list);
    		list.remove(list.size() - 1);
    	}
    	
    	return result;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
