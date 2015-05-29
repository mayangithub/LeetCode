/**
 * 
 */
package edu.pitt.string;

/**
 * Multiply Strings #43 --- Accepted 419ms
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author yanma
 * @since 2015-05-14
 * @version 2015-05-14
 */
public class MultiplyStrings_43 {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
        	return "0";
        } else if (num1.equals("1")) {
        	return num2;
        } else if (num2.equals("1")) {
        	return num1;
        }
        
        int length1 = num1.length();
        int length2 = num2.length();
        
        char[] num1array = new char[length1];
        char[] num2array = new char[length2];
        num1array = num1.toCharArray();
        num2array = num2.toCharArray();
        int[] resultarray = new int[length1 + length2];
        
        for (int two = 0; two < length2; two++) {
        	int numtwo = Character.getNumericValue(num2array[length2 - two - 1]);
        	for (int one = 0; one < length1; one++) {
        		int numone = Character.getNumericValue(num1array[length1 - one - 1]);
        		int times = numone * numtwo;
//        		System.out.println(times);
        		int current = resultarray[length1 + length2 - 1 - one - two];
//        		System.out.println(current);
        		resultarray[length1 + length2 - one - two - 2] += (times + current) / 10;
        		//System.out.println(resultarray[length1 + length2 - one - two - 2]);
        		resultarray[length1 + length2 - one - two - 1] = (times + current) % 10;
        		//System.out.println(resultarray[length1 + length2 - one - two - 1]);
        	}
        }
                
        
        String resultString = "";
        for (int i = resultarray.length - 1; i >= 0; i--) {
        	if (i == 0 && resultarray[i] == 0) {
        		continue;
        	} else {
        		resultString = resultarray[i] + resultString;
        	}
			
		}
        
        return resultString;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "4321";
		String num2 = "4321";
		
		System.out.println(multiply(num1, num2));;
	}

}
