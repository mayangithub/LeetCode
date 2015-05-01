/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Climbing Stairs #70 --- Accepted 254ms
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * 
 * @author yanma
 * @since 2015-03-19
 * @version 2015-05-01
 *
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
    	if (n <= 1) {
    		return 1;
    	} 
    	
    	int first = 1;
    	int second = 1;
    	
    	for (int i = 2; i < n; i++) {
    		int temp = first + second;
    		first = second;
    		second = temp;
    	}
    	
    	return first + second;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
