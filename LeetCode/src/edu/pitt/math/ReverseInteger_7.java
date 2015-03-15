/**
 * 
 */
package edu.pitt.math;

/**
 * Reverse Integer #7 --- Accepted 250ms
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321 
 * 
 * Have you thought about this?
 * Here are some good questions to ask before coding. 
 * Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * @author yanma
 * @since 2015-03-15
 * @version 2015-03-15
 */
public class ReverseInteger_7 {

    public static int reverse(int x) {
    	if (x == 0) return 0;
    	if (String.valueOf(Math.abs(x)).length() > 10)  return 0;
    		
    	String intString = String.valueOf(x);
    	int length = intString.length();
    	
    	StringBuffer buffer = new StringBuffer();
    	boolean flag = false;
    	int base;
    	
    	if (x > 0) {
    		base = 0;
    	} else {
    		base = 1;
    	}
    	
    	for (int n = length - 1; n >= base; n--) {
    		int num = Integer.valueOf(String.valueOf(intString.charAt(n)));
    		if (num != 0) {
    			flag = true;
    			buffer.append(num);
    		} else if (num == 0 && flag == true) {
    			buffer.append(0);
    		}
    		
    	}
    	
    	int result = 0;
    	
    	if (buffer.length() == 10) {
    		if (buffer.toString().compareTo("2147483647") > 0) return 0;
    	}
    	
    	result = Integer.valueOf(buffer.toString());
    	
		if (x < 0) return result * (-1);
		return result;
    
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 123;
		int b = -123;
		int c = 10;
		int d = 100;
		int e = 0;
		int f = 1000000003;
		int g = -2147483412;
		
		System.out.println("a: " + reverse(a));
		System.out.println("b: " + reverse(b));
		System.out.println("c: " + reverse(c));
		System.out.println("d: " + reverse(d));
		System.out.println("e: " + reverse(e));
		System.out.println("f: " + reverse(f));
		System.out.println("g: " + reverse(g));
		
		
	}

}
