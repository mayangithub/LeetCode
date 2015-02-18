/**
 * 
 */
package edu.pitt.string;

import java.util.Stack;

/**
 * Valid Parentheses #20 --- accepted 204ms
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author yanma
 * @since 2015-02-17
 * @version 2015-02-17
 */
public class ValidParentheses_20 {

	public static boolean isValid(String s) {
        /**
         * 思路：
         * 1. if s = null or s.length = 0, return true;
         * 2. string1 = "(){}[]"; index % 2 = 0, the bracket is open, index % 2 = 1, the bracket is close
         * 3. if the char in s is open, push to stack, if the char in s is close, then, pop out an element in stack, 
         * 	find the index of element in string1, if its position is before the close bracket, go on to next char in s; 
         * 	if not the char in the front, return false;
         * 4. if only the open/close char, return false
         */
		
		if (s == null || s.length() == 0) {
			return true;
		}
		
		String str = "(){}[]";
		Stack<Character> stack = new Stack<Character>();
			
		for(int i = 0; i < s.length(); i++) {
			char item = s.charAt(i);
			char out;
			int index = str.indexOf(item);
			if (i == 0 && index % 2 != 0) {
				return false;
			}
			if (index % 2 == 0) {
				stack.push(item);
			}
			
			if (index % 2 != 0) {
				
				if (stack.size() > 0) {
					out = stack.pop();
					if (str.indexOf(out) + 1 != index) {
						return false;
					}
				}else {
					return false;
				}
				
			}
		}
		
		if (stack.size() != 0) {
			return false;
		}
		
		return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "(]";
		String str2 = "([)]";
		String str3 = "([{}{}])";
		String str4 = "((((([][]][)))})";
		String str5 = "[][]]";
		String str6 = "[";
		String str7 = "]";
		
		System.out.println(str1 + ": " + isValid(str1));
		System.out.println(str2 + ": " + isValid(str2));
		System.out.println(str3 + ": " + isValid(str3));
		System.out.println(str4 + ": " + isValid(str4));
		System.out.println(str5 + ": " + isValid(str5));
		System.out.println(str6 + ": " + isValid(str6));
		System.out.println(str7 + ": " + isValid(str7));
		
	}

}
