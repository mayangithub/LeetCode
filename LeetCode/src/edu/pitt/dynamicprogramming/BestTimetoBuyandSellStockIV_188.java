/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Best Time to Buy and Sell Stock IV #188 --- accepted 320ms
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author yanma
 * @since 2015-06-16
 * @version 2015-06-16
 */
public class BestTimetoBuyandSellStockIV_188 {
	
	
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        
        if (k > prices.length / 2) {
        	int profit = 0;
        	for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1]; 
			}
        	return profit;
        }
        
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
			int gap = prices[i] - prices[i - 1];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(gap, 0), local[j] + gap);
				global[j] = Math.max(local[j], global[j]);
			}
		}
        
        return global[k];
    }
    
}
