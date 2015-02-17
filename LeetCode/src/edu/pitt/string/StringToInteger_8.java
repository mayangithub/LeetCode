package edu.pitt.string;

/**
 * String to Integer #8 --- accepted 262ms
 * 
 * Implement atoi to convert a string to an integer.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character 
 * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many 
 * numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author yanma
 * @since 2015-02-16
 * @version 2015-02-16
 */

public class StringToInteger_8 {

	public static int atoi(String str) {
		/**
		 * 思路：
		 * 1. str.length() = 0, return 0
		 * 2. while loop to access the first non-whitespace character. if no non-whitespace char exists, return 0.
		 * while the non-whitespace char is not numeric, do 3 or 6
		 * 3. if the first non-whitespace char is +, go to next char, if is -, save it to a temp string 
		 * 4. if the first char is number, use the temp string to store the number, 
		 * 	  go on this store process until the char is not a number then stop
		 * 5. compare the temp string with max and min, if larger than max, return max, is smaller than min, return min
		 * 6. if the first non-whitespace char is neither the sign nor numeric, return 0.
		 * 
		 * 
		 * Note:
		 * 1. only one sign can exist, otherwise, return 0
		 * 2. after the sign, if the char is not numeric, return 0
		 * 
		 */
		if (str.length() == 0) {
			return 0;
		}
		
        int integer = 0;
        int index = 0;
        while (index < str.length()) {
        	if (java.lang.Character.isWhitespace(str.charAt(index))) {
        		index++;
        	}else {
        		break;
        	}
        }
        if (index == str.length()) {
        	return integer;
        }
        
        String temp = "";
        
        if (java.lang.Character.isLetter(str.charAt(index))) {
        	return integer;
        } else if (str.charAt(index) == '+') {
        	index += 1;
        } else if (str.charAt(index) == '-') {
        	temp += str.charAt(index);
        	index += 1;
        } 
        
        if (!java.lang.Character.isDigit(str.charAt(index))) {
    		return integer;
    	}
        
        int count = 0;
        while (index < str.length() && count<= 10 && java.lang.Character.isDigit(str.charAt(index))) {
        	temp += str.charAt(index);
        	count++;
        	index++;
        }
		
        long templong;
        templong = java.lang.Long.parseLong(temp);
        
		if (templong > java.lang.Integer.MAX_VALUE) {
			return java.lang.Integer.MAX_VALUE;
		} else if (templong < java.lang.Integer.MIN_VALUE) {
			return java.lang.Integer.MIN_VALUE;
		}else {
			integer = java.lang.Integer.parseInt(temp);
		}
		
		return integer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString1 = "512";
		String testString2 = "512.035";
		String testString3 = "   512.035";
		String testString4 = "   512+34";
		String testString5 = "   512 bottles of beer on the wall";
		String testString6 = " does not work: 512";
		String testString7 = "    -2222222-22222222222222222     ";
		String testString8 = "+- -----2";
		String testString9 = "         ";
		
		System.out.println("testString1: " + testString1 + ", return: " + atoi(testString1));
		System.out.println("testString2: " + testString2 + ", return: " + atoi(testString2));
		System.out.println("testString3: " + testString3 + ", return: " + atoi(testString3));
		System.out.println("testString4: " + testString4 + ", return: " + atoi(testString4));
		System.out.println("testString5: " + testString5 + ", return: " + atoi(testString5));
		System.out.println("testString6: " + testString6 + ", return: " + atoi(testString6));
		System.out.println("testString7: " + testString7 + ", return: " + atoi(testString7));
		System.out.println("testString8: " + testString8 + ", return: " + atoi(testString8));
		System.out.println("testString9: " + testString9 + ", return: " + atoi(testString9));
		
	}

}
