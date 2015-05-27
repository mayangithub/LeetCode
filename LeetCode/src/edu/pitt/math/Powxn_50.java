/**
 * 
 */
package edu.pitt.math;

/**
 * Pow(x, n) #50 --- Accepted 296ms
 * Implement pow(x, n). 
 * @author yanma
 * @since 2015-05-27
 * @version 2015-05-27
 */
public class Powxn_50 {

	/**
	 * Corner cases:
	 * 0.00001, 2147483647
	 * 1.00000, -2147483648
	 * -1.00000, -2147483648
	 */
	
    public static double myPow(double x, int n) {
        if (x == 0) {
        	return 0;
        } 
        //clean x & n
        if (x < 0) {
        	if (n % 2 == 0) {
        		x = -x;
        	} else {
            	return (-1) * myPow(-x, n);
            } 
        } 

        if (n == 0 || x == 1) {
        	return 1;
        }
        
        if (n < 0) {
			return 1 / myPow(x, -n);
		}  
        
        double half = myPow(x, n / 2); // in order to save time, use variable to store value to be used multiple times
        
        if (n % 2 == 0) {
        	return half * half;
        } else {
        	return half * half * x;
        }
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myPow(1, 5));
		System.out.println(myPow(1, 4));
		System.out.println(myPow(3, 2));
		System.out.println(myPow(2, -3));
		System.out.println(myPow(1, 0));
		System.out.println(myPow(0.00001, 2147483647));
		System.out.println(myPow(1.00000, -2147483648));
		System.out.println(myPow(-1.00000, -2147483648));
	}

}
