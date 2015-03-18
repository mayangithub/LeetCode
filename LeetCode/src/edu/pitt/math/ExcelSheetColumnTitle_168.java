/**
 * 
 */
package edu.pitt.math;

/**
 * Excel Sheet Column Title #168
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB 
 * @author yanma
 * @since 2015-03-17
 * @version 2015-03-17
 *
 */
public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int n) {
        /**
         * Thoughts:
         * 1. n < 1, return "";
         * 2. use a char array to store letters with index 0 to 26, 0 point to "", 1 to A, 25 to Y, 26 to Z
         * 3. n mod 26 not 0, get the last letter, n / 26 again and again to get front letters
         * 4. n mod 26 is 0, last letter is Z, n/26 - 1 again and again to get front letters
         */
    	
    	
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
