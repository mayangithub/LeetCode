/**
 * 
 */
package edu.pitt.math;

/**
 * Palindrome Number #9 --- Accepted 443ms
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author yanma
 * @since 2015-03-15
 * @version 2015-03-15
 *
 */
public class PalindromeNumber_9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {return false;}
        
        while (x >= 10) {
        	int left = (int) Math.pow(10, (int) Math.log10(x));
        	int right = 10;
        
        	int last = x % right;
        	int first = (int) (x / left);
        	if (last == first) {
        		if (x / (left / 10) - first * 10 != 0) {
        			x = (x - (int) (first * left) - last) / right;
        			
        		} else {
        			int second = (x - last) % (right * right); 
        			if (x / (left / 10) - first * 10 != second) {
        				return false;
        			} else {
        				x += left/10 + 10; 
        			}
        		}
        		
        		
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 12321;
		int b = -1;
		int c = 1247483412;
		int d = 100030001;
		int e = 1003101;
		
		System.out.println("a: " + isPalindrome(a));
		System.out.println("b: " + isPalindrome(b));
		System.out.println("c: " + isPalindrome(c));
		System.out.println("d: " + isPalindrome(d));
		System.out.println("e: " + isPalindrome(e));
		
	}

}
