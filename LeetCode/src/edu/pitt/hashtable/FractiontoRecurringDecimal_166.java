/**
 * 
 */
package edu.pitt.hashtable;

/**
 * Fraction to Recurring Decimal #166 --- Accepted 212ms
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 *     Given numerator = 1, denominator = 2, return "0.5".
 *     Given numerator = 2, denominator = 1, return "2".
 *     Given numerator = 2, denominator = 3, return "0.(6)".
 * @author yanma
 * @since 2015-04-29
 * @version 2015-04-29
 */
public class FractiontoRecurringDecimal_166 {
	
	/**
	 * Note: 
	 * 1. one negative, one positive
	 * 2. one to the boundary value, -2147483648, 2147483647
	 * 3. can't only use the indexOf() method to get the start position, because of duplicate values
	 */
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
        	return "0";
        } else if (denominator == 0) {
        	return "infinity";
        } else if (denominator == 1) {
        	return numerator + "";
        }
        
        long num = numerator;
        long den = denominator;
        
        String fraction = "";
        if (num * den < 0) {
        	fraction += "-";
        	num *= -1; 
        }
        
        if (num % den == 0) {
        	return "" + num / den;
        } else {
        	fraction += num / den + ".";
        	long mod = num % den * 10;
        	java.util.Hashtable<Long, Integer> hashtable = new java.util.Hashtable<Long, Integer>();
        	String repeat = "";
        	while (mod != 0) {
        		if (!hashtable.containsKey(mod)) {
        			String value = String.valueOf(mod / den);
        			hashtable.put(mod, 1);
        			mod = mod % den * 10;
        			fraction += value;
        		} else {
        			if (hashtable.get(mod).intValue() == 1) {
        				repeat += mod / den;
        				hashtable.put(mod, 2);
        				mod = mod % den * 10;
        			} else if (hashtable.get(mod).intValue() == 2) {
        				int dotpos = fraction.indexOf(".");
            			int pos = fraction.indexOf(repeat, dotpos);
            			fraction = fraction.substring(0, pos) + "(" + repeat + ")";
            			break;
        			}
        			
        		}
        	}
        }
        
        return fraction;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = -1;
		int den = -2147483648;
		System.out.println(fractionToDecimal(num, den));
	}

}
