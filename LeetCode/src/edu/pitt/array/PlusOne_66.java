package edu.pitt.array;

/**
 * Plus One #66
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author yanma
 * @since 2015-02-13
 * @version 2015-02-13
 *
 * Note:
 * 1. last number add 1
 * 2. other number add carry 
 * 3. array needs to be enlarged?
 */
public class PlusOne_66 {
	/**
	 * 220ms
	 * @param digits
	 * @return
	 */
	public static int[] plusOneFifthTry(int[] digits) {
        int length = digits.length;
        if (digits[length-1]<9) {
        	digits[length-1] = digits[length-1] + 1;
        	toString(digits);
        	return digits;
        } else {
        	int carry = 1;
        	digits[length-1] = 0;
        	int addition;
        	int j = length - 2;
        	while(carry != 0 && j >= 0) {
        		addition = digits[j] + carry;
        		carry = addition / 10;
        		digits[j] = addition % 10;
        		j--;
        	}
        	
        	if (carry == 1) {
        		
        		int[] result = new int[length+1];
        		result[0] = carry;
        		for (int i = 1; i < length + 1; i++) {
        			result[i] = digits[i-1];
        		}
        		toString(result);
        		return result;
        		
        	}
        	toString(digits);
        	return digits;
        }
        
    }
	
	public static int[] plusOneForthTry(int[] digits) {
        int length = digits.length;
        int carry = 1;
        int addition;
        
        for (int i = length -1; i >= 0; i--) {
        	addition = digits[i] + carry;
        	carry = addition / 10;
        	digits[i] = addition % 10;
        }
        
        if (carry == 1) {
    		
    		int[] result = new int[length+1];
    		result[0] = carry;
    		for (int i = 1; i < length + 1; i++) {
    			result[i] = digits[i-1];
    		}
    		toString(result);
    		return result;
    		
    	}
        
        toString(digits);
        return digits;
        
        
    }
	
	public static int[] plusOneThirdTry(int[] digits) {
        int length = digits.length;
        int addition = digits[length-1] + 1;
        digits[length-1] = addition % 10;
        int carry = addition / 10;
        
        for (int i = length -2; i >= 0; i--) {
        	addition = digits[i] + carry;
        	carry = addition / 10;
        	digits[i] = addition % 10;
        }
        
        if (carry == 1) {
    		
    		int[] result = new int[length+1];
    		result[0] = carry;
    		for (int i = 1; i < length + 1; i++) {
    			result[i] = digits[i-1];
    		}
    		return result;
    		
    	}
    	return digits;
    }
	
	public static int[] plusOneSecondTry(int[] digits) {
        int length = digits.length;
        if (digits[length-1]<9) {
        	digits[length-1] = digits[length-1] + 1;
        	return digits;
        } else {
        	int carry = 0;
        	int addition = digits[length-1] + 1;
        	digits[length-1] = addition % 10;
        	carry = addition / 10; 
        	int j = length - 2;
        	while(carry != 0 && j >= 0) {
        		addition = digits[j] + carry;
        		carry = addition / 10;
        		digits[j] = addition % 10;
        		j--;
        	}
        	
        	if (carry == 1) {
        		
        		int[] result = new int[length+1];
        		result[0] = carry;
        		for (int i = 1; i < length + 1; i++) {
        			result[i] = digits[i-1];
        		}
        		return result;
        		
        	}
        	return digits;
        }
    }
	
	/**
	 * fastest 199ms
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length-1]<9) {
        	digits[length-1] = digits[length-1] + 1;
        	toString(digits);
        	return digits;
        } else {
        	int carry = 0;
        	int addition = digits[length-1] + 1;
        	digits[length-1] = addition % 10;
        	carry = addition / 10; 
        	int j = length - 2;
        	while(carry != 0 && j >= 0) {
        		addition = digits[j] + carry;
        		carry = addition / 10;
        		digits[j] = addition % 10;
        		j--;
        	}
        	
        	if (carry == 1) {
        		
        		int[] result = new int[length+1];
        		result[0] = carry;
        		for (int i = 1; i < length + 1; i++) {
        			result[i] = digits[i-1];
        		}
        		toString(result);
        		return result;
        		
        	}
        	toString(digits);
        	return digits;
        }
        
    }
	
	
	public static void toString(int[] array) {
		String string = "[";
		string += array[0];
		for (int i = 1; i< array.length; i++) {
			string += ", " + array[i];
		}
		string += "]";
		System.out.println(string);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {0};
		int[] array2 = {9};
		int[] array3 = {1,2};
		int[] array4 = {8,9,9,9};
		int[] array5 = {1,0,2};
		
		plusOneFifthTry(array1);
		plusOneFifthTry(array2);
		plusOneFifthTry(array3);
		plusOneFifthTry(array4);
		plusOneFifthTry(array5);
		
	}

}
