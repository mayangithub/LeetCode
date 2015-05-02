/**
 * 
 */
package edu.pitt.stack;

/**
 * Evaluate Reverse Polish Notation #150 --- Accepted 375ms
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author yanma
 * @since 2015-05-01
 * @version 2015-05-01
 */
public class EvaluateReversePolishNotation_150 {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
        	return 0;
        } if (tokens.length == 1) {
        	return Integer.valueOf(tokens[0]);
        }
        
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
        	if (isNumeric(tokens[i])) {
        		stack.push(Integer.valueOf(tokens[i]));
        	} else {
        		int second = stack.pop().intValue();
        		int first = stack.pop().intValue();
        		switch (tokens[i]) {
        		case "+":
        			stack.push(Integer.valueOf(first + second));
        			break;
        		case "-":
        			stack.push(Integer.valueOf(first - second));
        			break;
        		case "*":
        			stack.push(Integer.valueOf(first * second));
        			break;
        		default:
        			stack.push(Integer.valueOf(first / second));
        			break;
        		}
        	}
        }
        
        int result = stack.pop().intValue();
        
        return result;
    }
    
    public static boolean isNumeric(String element) {
    	if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
    		return false;
    	}
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stringArray = {"2", "1", "+", "3", "*"};
		String[] stringarray2 = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(stringarray2));
	}

}
