package edu.pitt.string;

/**
 * Count and Say #38 --- accepted 272ms
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string. 
 * @author yanma
 * @since 2015-02-21
 * @version 2015-02-21
 */
public class CountAndSay_38 {
	
	public static String countAndSay(int n) {
        /**
         * 思路：
         * 1. if n = 0, return "1"
         * 2. recursive call function countAndSay(n - 1)
         * 3. get the returned string, pointer i in range [0, returned string's length - 1],
         * 4. find the next different char number, count the number times, the string += times + number
         * 
         * ******
         * 1. 1 is the first not the 0th element
         * 2. string.charAt(i), if the char is a number, will return ASCII, 
         * 3. in String, number + number will be a number, should cast first
         */
		
		if (n == 1) {
			return "1";
		}
		
		String preString = countAndSay(n - 1);
		
		String sequence = "";
		int temp = Integer.valueOf(String.valueOf(preString.charAt(0)));
		int count = 1;
		for (int i = 1; i < preString.length(); i++) {
			if (Integer.valueOf(String.valueOf(preString.charAt(i))) != temp) {
				sequence += "" + count + temp;
				count = 1;
				temp = Integer.valueOf(String.valueOf(preString.charAt(i)));
			} else {
				count++;
			}
			
		}
		sequence += "" + count + temp;
		
		return sequence;
		
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("n = 1:" + countAndSay(1));
		System.out.println("n = 2:" + countAndSay(2));
		System.out.println("n = 3:" + countAndSay(3));
		System.out.println("n = 4:" + countAndSay(4));
		System.out.println("n = 5:" + countAndSay(5));
	}

}
