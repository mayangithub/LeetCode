/**
 * 
 */
package edu.pitt.stack;

/**
 * Basic Calculator #224 --- Accepted 360ms
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function. 
 * @author yanma
 * @since 2015-06-10
 * @version 2015-06-10
 */
public class BasicCalculator_224 {
	
    public static int calculate(String s) {
        /**
         * First thought:
         * 1. because no * and / in the expression, just ignore parentheses, they will not change the operation order 
         * *******Big MISTAKE above!!!! -( + ), -( - ) will have change operator effect
         * 2. iterate through expression string, get each number, and operator, store in a queue, 
         * 3. that would be number1 | operator1 | number2 | operator | number3 | operator | number4 | operator | num...
         * 4. if the number1 is operator directly, make number1 = 0
         * 5. calculate from start, num1 ope1 num2, get result, then result ope num3, get result, ope num4....
         * 6. until no more num and the queue is empty, get final result, return
         * 
         * This method thought:
         * use a stack, 
         * when meet digit, add it to number
         * when meet + or -, means number is over, multiply number with previous sign + or -, make it the result so far
         * then make sign + or -
         * when meet with parentheses, meet (, store result so far in stack, store sign before ( in stack
         * make new sign + and new result 0
         * in parentheses, like usual
         * when meet ), calculate result in (), stack pop out the sign before (, times the current result, 
         * stack pop out result before (, add to current result, the new result so far
         * after all, if number is not 0, add number to result, means no more operator after this number
         * return result;
         */
    	if (s == null || s.length() == 0)  return 0;
    	java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
    	int number = 0;
    	int sign = 1; //+: 1, -: -1
    	int result = 0;
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = number * 10 + Character.getNumericValue(c);
			} else if (c == '+') {
				result += sign * number;
				sign = 1;
				number = 0;
			} else if (c == '-') {
				result += sign * number;
				sign = -1;
				number = 0;
			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				number = 0;
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				result *= stack.pop(); //times sign
				result += stack.pop(); //result before sign and (
				number = 0;
			}
		}
    	
    	result += sign * number;
    	
    	return result;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "1 + 1";
		String s2 = "2 - 1 + 2 ";
		String s3 = "(1 - (4 - 5 + 2) - 3) - (6 + 8) - 1";
		System.out.println(s1 + " = " + calculate(s1));
		System.out.println(s2 + " = " + calculate(s2));
		System.out.println(s3 + " = " + calculate(s3));
	}

}
