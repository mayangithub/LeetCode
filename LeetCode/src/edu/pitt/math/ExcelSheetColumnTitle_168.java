/**
 * 
 */
package edu.pitt.math;

/**
 * Excel Sheet Column Title #168 --- Accepted 177ms
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB 
 *    52 -> AZ
 *    53 -> BA
 *    78 -> BZ
 *    79 -> CA
 * @author yanma
 * @since 2015-03-17
 * @version 2015-03-17
 *
 */
public class ExcelSheetColumnTitle_168 {
    public static String convertToTitle(int n) {
        /**
         * Thoughts:
         * 1. n < 1, return "";
         * 2. use a char array to store letters with index 0 to 26, 0 point to "", 1 to A, 25 to Y, 26 to Z
         * 3. n mod 26 not 0, get the last letter, n / 26 again and again to get front letters
         * 4. n mod 26 is 0, last letter is Z, n/26 - 1 again and again to get front letters
         */
    	
    	if (n < 1) {
    		return  "";
    	}
    	
    	String[] alphabet = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
    						  "R","S","T","U","V","W","X","Y","Z"};
    	    	
    	String lastLetter = "";
    	String frontLetter = "";
    	
    	if (n % 26 == 0) {
    		lastLetter = "Z";
    		frontLetter += convertToTitle(n/26 - 1);
    	} else {
    		lastLetter = alphabet[n % 26];
    		frontLetter += convertToTitle(n/26);
    	}
    	
    	return frontLetter + lastLetter;
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("11: " + convertToTitle(11));
		System.out.println("26: " + convertToTitle(26));
		System.out.println("27: " + convertToTitle(27));
		System.out.println("28: " + convertToTitle(28));
		System.out.println("52: " + convertToTitle(52));
		System.out.println("53: " + convertToTitle(53));
		System.out.println("78: " + convertToTitle(78));
		System.out.println("79: " + convertToTitle(79));
		System.out.println("7924: " + convertToTitle(7924));
	}

}
