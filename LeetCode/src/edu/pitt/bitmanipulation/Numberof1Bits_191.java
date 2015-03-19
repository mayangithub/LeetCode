/**
 * 
 */
package edu.pitt.bitmanipulation;

/**
 * Number of 1 Bits #191 --- Accepted 236ms
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
 * (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 * @author yanma
 * @since 2015-03-19
 * @version 2015-03-19
 *
 */
public class Numberof1Bits_191 {

    // you need to treat n as an unsigned value
	/**
	 * Accepted 236ms
	 * @param n
	 * @return
	 */
    public static int hammingWeight1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
        	if (binaryString.substring(i, i+1).equals("1")) {
        		count++;
        	}
        }
        return count;
    }
    
    /**
     * Others method --- Accepted 302ms
     * 1. move right 0 to 31 bit, logic & with 1
     * 2. the count += &result
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
        	count += (n >> i) & 1;
        }
        return count;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("11: " + hammingWeight(11));
	}

}
