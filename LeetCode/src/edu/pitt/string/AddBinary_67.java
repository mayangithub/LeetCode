package edu.pitt.string;

/**
 * Add Binary #67 --- accepted 266ms
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 * @author yanma
 * @since 2015-02-21
 * @version 2015-02-21
 */
public class AddBinary_67 {

	public static String addBinary(String a, String b) {
		/**
         * 思路：
         * 1. from the last number of a and b, do sum, carry = 0, sum % 2, remainder stay in the position
         * 2. not the last digit, sum = a + b + carry
         * 3. when pass the 0 position of both a and b, sum = carry + sum
         * 
         * *****
         * 1. if the last carry is 0, not add 0 as the leading digit
         * 2. a, b might be super long, use string.equals() to compare with "0", don't use Integer.valueOf(String) to compare with 0
         */
		
        if (a ==  null || b == null) {
        	return "";
        } else if (a.length() == 0 || a.equals("0")) {
        	return b;
        } else if (b.length() == 0 || b.equals("0")) {
        	return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String sumString = "";
        int tempa;
        int tempb;
        int tempsum;
        
        while (i >= 0 && j >= 0) {
        	tempa = Integer.valueOf(String.valueOf(a.charAt(i)));
        	tempb = Integer.valueOf(String.valueOf(b.charAt(j)));
        	tempsum = tempa + tempb + carry;
        	carry = tempsum / 2;
        	sumString = "" + tempsum % 2 + sumString;
        	i--;
        	j--;
        }
        
        if (i >= 0) {
        	while (i >= 0 ) {
        		tempa = Integer.valueOf(String.valueOf(a.charAt(i)));
        		tempsum = tempa + carry;
        		carry = tempsum / 2;
            	sumString = "" + tempsum % 2 + sumString;
            	i--;
        	}
        }
        
        
        if (j >= 0) {
        	while (j >= 0 ) {
        		tempb = Integer.valueOf(String.valueOf(b.charAt(j)));
        		tempsum = tempb + carry;
        		carry = tempsum / 2;
            	sumString = "" + tempsum % 2 + sumString;
            	j--;
        	}
        }
        
        if (carry != 0) {
        	sumString = carry + "" + sumString;
        }
        
        
        return sumString;
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("100 + 110010 = " + addBinary("100", "110010"));
	}

}
