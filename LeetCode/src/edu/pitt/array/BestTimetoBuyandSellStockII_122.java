/**
 * 
 */
package edu.pitt.array;

/**
 * Best Time to Buy and Sell Stock II #122 --- Accepted 362ms/359ms
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author yanma
 * @since 2015-05-08
 * @version 2015-05-08
 */
public class BestTimetoBuyandSellStockII_122 {
	
	/**
	 * Accepted 362ms
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2) {
        	return 0;
        } else if (prices.length == 2 && prices[0] > prices[1]) {
        	return 0;
        }
    	
    	int minPrice = prices[0];
    	int maxPrice = prices[0];
        int maxProfit = 0;
        int maxTotal = 0;
        
        for (int index = 1; index < prices.length; index++) {
        	if (prices[index] < minPrice) {
        		maxTotal += maxProfit;
        		minPrice = prices[index];
        		maxPrice = prices[index];
        		maxProfit = 0;
        	}
        	
        	if (prices[index] >= maxPrice) { 
        		maxPrice = prices[index];
        		maxProfit = (maxPrice - minPrice > maxProfit) ? maxPrice - minPrice: maxProfit;
        	}
        	
        	if (prices[index] >= minPrice && prices[index] < maxPrice) {
        		maxProfit = maxPrice - minPrice;
        		maxTotal += maxProfit;
        		minPrice = prices[index];
        		maxPrice = prices[index];
        		maxProfit = 0;
        	}
        }
        
        maxProfit = maxPrice - minPrice; // after all days, sell stock
        maxTotal += maxProfit;
           
        return maxTotal;
    }
    
    /**
     * Accepted 359ms
     * the prices should continuously grow before selling
     * once the price drops, sell it, and new buy price is the new low price
     * all buying prices are the ones after selling
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
    	if (prices == null || prices.length < 2) {
        	return 0;
        } else if (prices.length == 2 && prices[0] > prices[1]) {
        	return 0;
        }
    	
    	int total = 0;
    	int profit = 0;
    	
    	int index = 1;
    	int start = 0;
    	while (index < prices.length) {
    		if (prices[index] >= prices[index - 1]) {
    			index++;
    		} else {
    			profit = prices[index - 1] - prices[start];
    			total += profit;
    			start = index;
    			profit = 0;
    			index++;
    		}
    	}
    	
    	profit = prices[index - 1] - prices[start];
    	total += profit;
    	
    	return total;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
