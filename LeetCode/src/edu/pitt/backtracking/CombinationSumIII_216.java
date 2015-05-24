/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III #216 --- Accepted 256ms
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * @author yanma
 * @since 2015-05-24
 * @version 2015-05-24
 */
public class CombinationSumIII_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n <= k || n <= 0) {
        	return list;
        }
        
        helper(k, n, list, new ArrayList<Integer>(), 0);
        
        return list;
    }
    
    public static void helper(int k, int n, List<List<Integer>> list, List<Integer> innerlist, int tail) {
    	
    	if (innerlist.size() == k && n == 0) {
    		list.add(new ArrayList<>(innerlist));
    	}
    	
    	for (int num = tail + 1; num <= 9; num++) {
    		innerlist.add(num);
    		helper(k, n - num, list, innerlist, num);
    		innerlist.remove(innerlist.size() - 1);
    	}
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 3; 
		int n = 7;
		
		List<List<Integer>> list = combinationSum3(k, n);
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
