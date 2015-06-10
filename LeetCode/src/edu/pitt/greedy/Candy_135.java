/**
 * 
 */
package edu.pitt.greedy;

/**
 * Candy #135 --- Accepted 468ms
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *     Each child must have at least one candy.
 *     Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give? 
 * @author yanma
 * @since 2015-06-09
 * @version 2015-06-09
 */
public class Candy_135 {
	
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
        	return 0;
        } 
        int length = ratings.length;
        int[] candies = new int[length];
        for (int i = 1; i < length; i++) {
			if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; 
		}
        int sum = candies[length - 1];
        for (int i = length - 2; i >= 0; i--) {
			if (candies[i] <= candies[i + 1] && ratings[i] > ratings[i + 1]) candies[i] = candies[i + 1] + 1;
			sum += candies[i];
		}
        
        return sum + length;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
