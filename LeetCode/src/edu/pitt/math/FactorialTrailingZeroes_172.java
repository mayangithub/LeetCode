/**
 * 
 */
package edu.pitt.math;

/**
 * Factorial Trailing Zeroes #172
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * @author yanma
 * @since 2015-03-16
 * @version 2015-03-16
 */
public class FactorialTrailingZeroes_172 {
    public static int trailingZeroes(int n) {
        int n2 = 0;
        int n5 = 0;
        int n10 = 0;
        
        int div = n;
        while (div > 0) {
        	div = div / 2;
        	n2 += div;
        }
        
        div = n;
        while (div > 0) {
        	div = div / 5;
        	n5 += div;
        }
        
        div = n;
        while (div > 0) {
        	div = div / 10;
        	n10 += div;
        }
        
        return Math.min(n2, n5) + n10;
        
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a1 = 15;
		int a2 = 1808548329;
		
		System.out.println("15: " + trailingZeroes(a1));
		System.out.println("1808548329: " + trailingZeroes(a2));
		System.out.println("150: " + trailingZeroes(150));
		System.out.println("25: " + trailingZeroes(25));
		
	}

}
