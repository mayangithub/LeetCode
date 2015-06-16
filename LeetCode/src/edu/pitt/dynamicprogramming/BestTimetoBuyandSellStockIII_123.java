/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Best Time to Buy and Sell Stock III #123 --- Accepted 348ms/356ms
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author yanma
 * @since 2015-06-16
 * @version 2015-06-16
 */
public class BestTimetoBuyandSellStockIII_123 {
	
	
	/**
	 * Accepted 348ms
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        int[] local = new int[3];
        int[] global = new int[3];
        
        for (int i = 1; i < prices.length; i++) {
        	int gap = prices[i] - prices[i - 1];
        	for (int j = 2; j >= 1; j--) {
        		local[j] = Math.max(global[j - 1] + Math.max(gap, 0), local[j] + gap);
        		global[j] = Math.max(local[j], global[j]);
        	}	
        }
        
        return global[2];
    }
    
    /**
     * Accepted 356ms
     * left:max transaction made by left part
     * right: max transaction made by right part
     * profit: max total of 2 transactions made on each part
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        //left DP
        int min = prices[0];
        for (int i = 1; i < left.length; i++) {
			min = Math.min(prices[i], min);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
        
        //right DP
        int max = prices[prices.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
        
        int profit = 0;
        for (int i = 0; i < left.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
        
        return profit;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
