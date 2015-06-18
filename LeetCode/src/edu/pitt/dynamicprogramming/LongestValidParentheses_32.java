/**
 * 
 */
package edu.pitt.dynamicprogramming;

import java.util.Stack;

/**
 * Longest Valid Parentheses #32 --- accepted 392ms
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 * @author yanma
 * @since 2015-06-18
 * @version 2015-06-18
 */
public class LongestValidParentheses_32 {
	
	
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
        	return 0;
        }
        
        int max = 0; // global max
        int sum = 0; // local max
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					sum = 0;
				} else {
					int temp = i - stack.pop() + 1;
					if (stack.isEmpty()) { // have complete pairs infront
						sum += temp;
						max = Math.max(max, sum);
					} else { // have open parenthese in the front
						temp = i - stack.peek();
						max = Math.max(max, temp);
					}
				}
			}
		}
        return max;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
