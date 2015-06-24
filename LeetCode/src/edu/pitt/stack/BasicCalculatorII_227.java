/**
 * 
 */
package edu.pitt.stack;

import java.util.Stack;

/**
 * Basic Calculator II #227 --- Accepted 508ms
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function. 
 * @author yanma
 * @since 2015-06-24
 * @version 2015-06-24
 */
public class BasicCalculatorII_227 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        s = eleminateSpaces(s);
        Stack<Integer> stack = new Stack<Integer>();
        boolean negative = false;
        boolean times = false;
        boolean divide = false;
        int num = 0;
        StringBuffer bf = new StringBuffer();
        
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		bf.append(s.charAt(i));
        		continue;
        	}
        	
        	if (bf.length() > 0) {
    			num = (negative) ? Integer.valueOf(bf.insert(0, '-').toString()): Integer.valueOf(bf.toString());
    			bf = new StringBuffer();
    			negative = false;
    			stack.push(num);
    			
    			if (times) {
    				int current = stack.pop();
            		int previous = stack.pop();
            		int result = previous * current;
            		stack.push(result);
            		times = false;
            	}
            	
            	if (divide) {
            		int current = stack.pop();
            		int previous = stack.pop();
            		if (current != 0) {
            			int result = previous / current;
            			stack.push(result);
            		} else {
            			stack.push(0);
            		}
            		divide = false;
            	}
    		}
        	
        	if (s.charAt(i) == '-') {
        		negative = true;
        		continue;
        	}
        	
        	if (s.charAt(i) == '+') {
        		continue;
        	}
        	
        	if (s.charAt(i) == '*') {
        		times = true;
        		continue;
        	}
        	
        	if (s.charAt(i) == '/') {
        		divide = true;
        		continue;
        	}
        }
        
        if (bf.length() > 0) {
			num = (negative) ? Integer.valueOf(bf.insert(0, '-').toString()): Integer.valueOf(bf.toString());
			bf = new StringBuffer();
			stack.push(num);
        	
        	if (times) {
        		int current = stack.pop();
        		int previous = stack.pop();
        		int result = previous * current;
        		stack.push(result);
        	}
        	
        	if (divide) {
        		int current = stack.pop();
        		int previous = stack.pop();
        		if (current != 0) {
        			int result = previous / current;
        			stack.push(result);
        		} else {
        			stack.push(0);
        		}
        	}
        }
        
        num = 0;
        while (!stack.isEmpty()) {
			num += stack.pop();
		}
        
        return num;
    }
    
    
    public static String eleminateSpaces(String s) {
    	StringBuffer bf = new StringBuffer();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == ' ') {
    			continue;
    		}
    		bf.append(s.charAt(i));
    	}
    	return bf.toString();
    }
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "3+2*2 + 1";
		String s2 = " 3/2  - 1";
		String s3 = " 3+5 / 2  - 2";
		String s4 = "0-2147483648";
		
		System.out.println(s1 + " -> " + calculate(s1));
		System.out.println(s2 + " -> " + calculate(s2));
		System.out.println(s3 + " -> " + calculate(s3));
		System.out.println(s4 + " -> " + calculate(s4));
	}

}
