/**
 * 
 */
package edu.pitt.dynamicprogramming;

import java.util.HashMap;

/**
 * Perfect Squares #279 --- Accepted
 * Given a positive integer n, 
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
 * @author yanma
 * @version 2015-09-22
 * @week 8 0921-0927
 * @category Dynamic Programming
 */
public class PerfectSquares_279 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int root = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for (int i = root; i >= 1; i--) {
            int num = 1 + numSquares(n - i * i);
            min = Math.min(num, min);
        }
        map.put(n, min);
        return min;
    }

}
