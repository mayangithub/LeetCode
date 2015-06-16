/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Best Time to Buy and Sell Stock #121 --- Accepted 421ms/299ms/376ms
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @author yanma
 * @since 2015-05-07
 * @version 2015-05-07
 */
public class BestTimetoBuyandSellStock_121 {
	
	/**
	 * Accepted 421ms
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
        	return 0;
        } else if (prices.length == 2 && prices[0] > prices[1]) {
        	return 0;
        }
        
        java.util.Stack<Integer> minStack = new java.util.Stack<Integer>();
        java.util.Stack<Integer> maxStack = new java.util.Stack<Integer>();
        java.util.Hashtable<Integer, Integer> indexTable = new java.util.Hashtable<>(); //key: price, value: index
        
        minStack.push(prices[0]);
        maxStack.push(prices[0]);
        indexTable.put(prices[0], 0);
        int gap = 0;
        
        for (int index = 1; index < prices.length; index++) {
        	if (prices[index] < minStack.peek()) {
        		minStack.push(prices[index]);
        		indexTable.put(prices[index], index);
        	}
        	
        	if (prices[index] > maxStack.peek()) {
        		maxStack.push(prices[index]);
        		indexTable.put(prices[index], index);
        	}
        	
        	if (prices[index] == maxStack.peek() && index > indexTable.get(maxStack.peek())) {
        		indexTable.put(prices[index], index);
        	}
        	
        	if (prices[index] > minStack.peek() && prices[index] < maxStack.peek() && 
        			indexTable.get(maxStack.peek()) < indexTable.get(minStack.peek())) {
        		maxStack.push(prices[index]);
        		indexTable.put(prices[index], index);
        	}
        	
        	int min = minStack.peek();
            int max = maxStack.peek();
        	int minIndex = indexTable.get(min);
            int maxIndex = indexTable.get(max);
            
            if (minIndex < maxIndex && max - min > gap) {
            	gap = max - min;
            }
        	
        }
           
        return gap;
    }
    
    /**
     * Accepted 299ms
     * Note: 
     * 1. cautious when new min appears, max would be invalid
     * 2. cautious when new max appears, old max would be invalid
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
    	if (prices == null || prices.length < 2) {
        	return 0;
        } else if (prices.length == 2 && prices[0] > prices[1]) {
        	return 0;
        }
        
    	int minPrice = prices[0];
    	int maxPrice = prices[0];
        int maxProfit = 0;
        
        for (int index = 1; index < prices.length; index++) {
        	if (prices[index] < minPrice) {
        		minPrice = prices[index];
        	}
        	
        	if (prices[index] >= maxPrice) { // new maxPrice, even the same with old maxPrice, calculate profit
        		maxPrice = prices[index];
        		maxProfit = (maxPrice - minPrice > maxProfit) ? maxPrice - minPrice: maxProfit;
        	}
        	
        	if (prices[index] > minPrice && prices[index] < maxPrice && prices[index] - minPrice > maxProfit) {
        		maxPrice = prices[index];
        		maxProfit = maxPrice - minPrice;
        	}
        }
           
        return maxProfit;
    }
    
    /**
     * Accepted 376ms
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
    	if (prices == null || prices.length < 2) {
        	return 0;
        }
    	
    	int local = 0;
    	int global = 0;
    	for (int i = 1; i < prices.length; i++) {
			local = Math.max(local + prices[i] - prices[i - 1], 0); // this line can add new higher price and minus lower high price, 
			                                                        // when equals 0, there's a new low price 
			global = Math.max(local, global); // 
		}
    	return global;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
