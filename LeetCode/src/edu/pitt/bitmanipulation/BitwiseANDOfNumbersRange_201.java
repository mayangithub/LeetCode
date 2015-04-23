/**
 * 
 */
package edu.pitt.bitmanipulation;

/**
 * Bitwise AND of Numbers Range #201 --- Accepted 397ms
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4. 
 * @author yanma
 * @since 2015-04-22
 * @version 2015-04-22
 */
public class BitwiseANDOfNumbersRange_201 {
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        }
        
        String mBinaryString = Integer.toBinaryString(m);
        String nBinaryString = Integer.toBinaryString(n);
        
        if (mBinaryString.length() != nBinaryString.length()) {
        	return 0;
        }
        
        String resultString = "";
        boolean flag = true;
        for (int i = 0; i < mBinaryString.length(); i++) {
        	if (flag == true && mBinaryString.charAt(i) == nBinaryString.charAt(i)) {
        		resultString += mBinaryString.charAt(i);
        	} else {
        		flag = false;
        		resultString += "0";
        	}
        }
        
        return Integer.parseInt(resultString, 2);
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(5, 7));
	}

}
