package edu.pitt.math;

/**
 * Sqrt(x) #69 --- Accepted 239 ms
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author yanma
 * @since 2015-04-22
 * @version 2015-04-22
 */
public class Sqrt_69 {

	/**
	 * if mid^2 > x, right = mid, because mid can not be the answer, but mid - 1 might be the answer;
	 * if mid^2 < x, left = mid + 1, return left - 1, because mid might be the answer
	 */
    public static int mySqrt(int x) {
    	if (x == 0 || x == 1) {
    		return x;
    	}
    	
    	int left = 1;
    	int right = x;
    	int mid = 0;
    	while (left < right) {
    		mid = (left + right) / 2;
    		if (mid == x/mid) {
    			return mid;
    		} else if (mid > x/mid) {
    				right = mid;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	return left - 1;
    	
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(2));
		System.out.println(mySqrt(9));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(25));
		System.out.println(mySqrt(16));
		System.out.println(mySqrt(81));
		System.out.println(mySqrt(144));
	}

}
