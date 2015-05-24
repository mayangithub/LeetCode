/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations #70 --- Accepted 268ms
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @author yanma
 * @since 2015-05-24
 * @version 2015-05-24
 */
public class Combinations_70 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0 || n < k) {
        	return list;
        } else if (n == k) {
        	List<Integer> innerList = new ArrayList<>();
        	for (int i = 1; i <= n; i++) {
        		innerList.add(i);
        	}
        	list.add(innerList);
        	return list;
        }
        
        helper(n, k, list, new ArrayList<Integer>(), 0);
        
        return list;
    }
    
    
    public static void helper(int n, int k, List<List<Integer>> list, List<Integer> innerList, int tail) {
    	if (innerList.size() > k) {
    		return;
    	}
    	
    	if (innerList.size() == k) {
    		list.add(new ArrayList<>(innerList));
    	}
    	
    	for (int num = tail + 1; num <= n; num++) {
    		innerList.add(num);
    		helper(n, k, list, innerList, num);
    		innerList.remove(innerList.size() - 1);
    	}
    	
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int k = 5;
		List<List<Integer>> list = combine(n, k);
		System.out.println("[");
		for (List<Integer> inner: list) {
			System.out.print("[");
			for (int i = 0; i < inner.size(); i++) {
				System.out.print(inner.get(i));
				if (i != inner.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		System.out.println("]");
		
	}

}
