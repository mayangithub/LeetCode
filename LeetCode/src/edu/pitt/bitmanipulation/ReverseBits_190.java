/**
 * 
 */
package edu.pitt.bitmanipulation;

import java.util.Stack;

/**
 * Reverse Bits #190 --- Accepted 261ms
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it? 
 * 
 * @author yanma
 * @since 2015-03-18
 * @version 2015-03-18
 *
 */
public class ReverseBits_190 {

    // you need treat n as an unsigned value
	
	/**
	 * Solution doesn't work
	 * @param n
	 * @return
	 */
    public static long reverseBits(long n) {
    	String binary = Long.toBinaryString(n);
//    	String binary = Integer.toBinaryString(n);
//    	String zeros = "";
    	
    	while (binary.length() < 32) {
    		binary = "0" + binary;
    	}
    	
    	Stack<String> stack = new Stack<String>();
    	for (int i = 0; i < binary.length(); i++) {
			stack.push(binary.substring(i, i+1));
		}
    	
    	String newString = "";
    	while (!stack.isEmpty()) {
    		newString += stack.pop();
    	}    	
    	
    	if (newString.charAt(0) == '1') {
    		System.out.println(Integer.MIN_VALUE);
    	}
    	
    	System.out.println(newString);
        return Long.valueOf(newString).longValue();
    	
    	
    }
    
    /**
     * My solution --- Accepted 261ms
     * @param n
     * @return
     */
    public static int reverseBits2(int n) {
    	int count = 0;
    	int result = 0;
    	result += n << 31;
    	System.out.println(result);
        while (count < 31) {
        	n = n >> 1;
        	System.out.println(n);
        	count++;
        	result += (n << 31) >>> count;
        	
        	System.out.println(result);
        }
        
        System.out.println(result);
        return result;
    }
    
    /**
     * Others solution --- Accepted 272ms
     * @param n
     * @return
     */
    public static long reverseBits1(long n) {
    	//others method
	    long res = 0;
		for (int i = 0; i<32;i++) {
			System.out.println("res: " + res);
			System.out.println((n >> i));
			System.out.println((n >> i) & 1);
			res = res*2 + ((n >> i) & 1);
			System.out.println("res: " + res);
			
		}
		System.out.println(res);
	    return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseBits2(1);
		//reverseBits2(43261596);
		//reverseBits2(4294967295L);
	}

}
