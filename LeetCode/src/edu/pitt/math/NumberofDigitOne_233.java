/**
 * 
 */
package edu.pitt.math;

/**
 * Number of Digit One #233 --- Accepted  260ms
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example: 
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13. 
 * Explanation: http://blog.csdn.net/u013027996/article/details/17126977
 * @author yanma
 * @since 2015-07-10
 * @version 2015-07-10
 */
public class NumberofDigitOne_233 {
	
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        
        String number = String.valueOf(n);
        int length = number.length();
        
        int count = 0;
        for (int i = 0; i < length; i++) {
            int num = Character.getNumericValue(number.charAt(i));
            if (num == 0) {
                if (i == 0) {
                    continue;
                }
                String high = number.substring(0, i);
                count += Integer.valueOf(high) * Math.pow(10, length - 1 - i);
            } else if (num == 1) {
                String high = (i == 0) ? "0": number.substring(0, i);
                String low = (i == length - 1) ? "0" : number.substring(i + 1);
                count += Integer.valueOf(high) * Math.pow(10, length - 1 - i) + Integer.valueOf(low) + 1;
            } else {
                String high = (i == 0) ? "0": number.substring(0, i);
                count += (Integer.valueOf(high) + 1) * Math.pow(10, length - 1 - i);
            }
        }
        return count;
    }

}
