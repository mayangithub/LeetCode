/**
 * 
 */
package edu.pitt.array;

/**
 * Largest Number #179 --- Accepted 333ms
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * @author yanma
 * @since 2015-05-01
 * @version 2015-05-01
 */
public class LargestNumber_179 {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return "";
        }
        String[] stringArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	stringArray[i] = String.valueOf(nums[i]);
        }
        String result = "";
        StringComparator comparator = new StringComparator();
        java.util.Arrays.sort(stringArray, comparator);
        
        //after sort, "smaller" string put before "larger" string
        //s1 < s2, s1s2 < s2s1, 
        //so, in stringArray, from index 0, each element string should put before current result string
        //s3s4s5s6 < s6s5s4s3
        for (String element: stringArray) {
        	result = element + result;
        }
        
        while (result.charAt(0) == '0' && result.length() > 1) {
        	result = result.substring(1, result.length());
        }
        return result;
    }
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 30, 34, 0, 5, 9};
		int[] num1 = {0,0};
		System.out.println(largestNumber(num1));
	}

}
