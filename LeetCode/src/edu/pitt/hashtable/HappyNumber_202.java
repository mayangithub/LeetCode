/**
 * 
 */
package edu.pitt.hashtable;

/**
 * Happy Number #202 --- Accepted 233 ms
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

 * @author yanma
 * @since 2015-04-22
 * @version 2015-04-22
 */
public class HappyNumber_202 {
    public static boolean isHappy(int n) {
        if (n == 0) {
        	return false;
        } else if (n == 1) {
        	return true;
        }
        
        java.util.Hashtable<Integer, Boolean> hashtable = new java.util.Hashtable<Integer, Boolean>();
        
        String number = String.valueOf(n);
        int sum = n;
        while (sum > 1) {
        	sum = 0;
        	for (int i = 0; i < number.length(); i++) {
	        	sum += Math.pow(java.lang.Character.getNumericValue(number.charAt(i)), 2);
	        }
        	if (sum == 1) {
        		return true;
        	} else {
        		if (hashtable.containsKey(Integer.valueOf(sum))) {
        			return false;
        		} else {
        			hashtable.put(Integer.valueOf(sum), Boolean.valueOf(true));
        			number = String.valueOf(sum);
        		}
        	}
        	
        }
        
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isHappy(1));
		System.out.println(isHappy(19));
		System.out.println(isHappy(99));
		System.out.println(isHappy(9));

	}

}
