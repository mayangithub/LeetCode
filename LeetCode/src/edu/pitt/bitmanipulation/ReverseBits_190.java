/**
 * 
 */
package edu.pitt.bitmanipulation;

import java.util.Stack;

/**
 * Reverse Bits #190 
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
    public static int reverseBits(int n) {
    	int count = 0;
    	while (count < 31) {
    		n = n >>> 1;
    		System.out.println(n);
    		count++;
    	}
    	return n;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseBits(43261596);
	}

}
