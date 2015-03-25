/**
 * 
 */
package edu.pitt.string;

/**
 * Integer to Roman #12 --- Accepted 301ms
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author yanma
 * @since 2015-03-25
 * @version 2015-03-25
 */
public class IntegerToRoman_12 {
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
        	return "";
        }
        
        String roman = "";
        String numString = String.valueOf(num);
        
        for (int i = 1; i <= numString.length(); i++) {
        	int digit = Integer.valueOf(numString.substring(numString.length() - i, numString.length() - i + 1));
        	System.out.println(digit);
        	roman = digitToRoman(digit, i) + roman;
        }
        System.out.println(roman);
        return roman;
    }
    
    public static String digitToRoman(int digit, int position) {
    	String roman = "";
    	if (position == 1) {
    		if (digit % 5 < 4) {
    			for (int i = 1; i <= digit % 5; i++) {
    				roman += "I";
    			}
    			if (digit >= 5) {
    				roman = "V" + roman;
    			}
    		} else {
    			switch (digit) {
				case 4:
					roman = "IV";
					break;
				case 9:
					roman = "IX";
					break;
				default:
					break;
				}
    		}
    	} else if (position == 2) {
    		if (digit % 5 < 4) {
    			for (int i = 1; i <= digit % 5; i++) {
    				roman += "X";
    			}
    			if (digit >= 5) {
    				roman = "L" + roman;
    			}
    		} else {
    			switch (digit) {
				case 4:
					roman = "XL";
					break;
				case 9:
					roman = "XC";
					break;
				default:
					break;
				}
    		}
    	} else if (position == 3) {
    		if (digit % 5 < 4) {
    			for (int i = 1; i <= digit % 5; i++) {
    				roman += "C";
    			}
    			if (digit >= 5) {
    				roman = "D" + roman;
    			}
    		} else {
    			switch (digit) {
				case 4:
					roman = "CD";
					break;
				case 9:
					roman = "CM";
					break;
				default:
					break;
				}
    		}
    	} else {
    		if (digit % 5 < 4) {
    			for (int i = 1; i <= digit % 5; i++) {
    				roman += "M";
    			}
    		}
    	}
    	
    	System.out.println(roman);
    	return roman;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 3999;
		intToRoman(num1);
	}

}
