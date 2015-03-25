package edu.pitt.string;

/**
 * Roman to Integer #13 --- accepted 308ms
 * 
 * Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author yanma
 * @since 2015-02-16
 * @version 2015-02-16
 *
 */

public class RomanToInteger_13 {

	public static int romanToInt(String s) {
        /**
         * 思路：
         * 1. sum作为结果，存放已算过的结果
         * 2. i pointer指向当前char, j pointer指向下一个char, i从第一位开始
         * 3. 比较两个char,在两个指针都不为空的情况下，如果getInt(i)<getInt(j), sum += getInt(j)-getInt(i), i+2 
         * ---> 这种情况说明两个字符代表一个数字
         * 4. 如果getInt(i)>=getInt(j),sum += getInt(i), i+1,
         * ---> 这种情况说明一个字符代表一个数字
         * 5. 如果i、j指针为空，sum = sum; 当i不为空j为空时，sum += getInt(i)
         * 
         * 6. base case: s.length() = 0, return directly
         * 7. return sum
         */
		
		int sum = 0;
		if (s.length() == 0) {
			return sum;
		}
		
		int i = 0;
		char temp1;
		char temp2;
		int temp1int;
		int temp2int;
		while (i <= s.length() - 2){
			temp1 = s.charAt(i);
			temp2 = s.charAt(i + 1);
			temp1int = getInt(temp1);
			temp2int = getInt(temp2);
			if (temp1int < temp2int) {
				sum += temp2int - temp1int;
				i += 2;
			} else {
				sum += temp1int;
				i += 1;
			}
		}
		
		if (i == s.length()) {
			return sum;
		} else if (i == s.length() - 1) {
			temp1 = s.charAt(i);
			temp1int = getInt(temp1);
			sum += temp1int;
		}
		
		return sum;
    }
	
	public static int getInt(char c) {
		int value = 0;
		switch (c) {
		case 'I':
			value = 1;
			break;
		case 'V':
			value = 5;
			break;
		case 'X':
			value = 10;
			break;
		case 'L':
			value = 50;
			break;
		case 'C':
			value = 100;
			break;
		case 'D':
			value = 500;
			break;
		case 'M':
			value = 1000;
			break;
		default:
			break;
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "I";
		int sum = romanToInt(string);
		System.out.println("I: " + sum);
		
		String string1 = "MMMCMXCIX";
		System.out.println("MMMCMXCIX: " + romanToInt(string1));
	}

}
