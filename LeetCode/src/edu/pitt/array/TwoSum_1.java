/**
 * 
 */
package edu.pitt.array;

/**
 * Two Sum #1 --- Accepted 247ms
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 * 
 * @author yanma
 * @since 2015-03-20
 * @version 2015-03-20
 *
 */
public class TwoSum_1 {
    public static int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
        java.util.Hashtable<Integer, Integer> hashtable = new java.util.Hashtable<Integer, Integer>();
    	
        for (int i = 0; i < numbers.length; i++) {
        	if (hashtable.containsKey(numbers[i])) {
        		result[0] = hashtable.get(numbers[i]) + 1;
        		result[1] = i + 1;
        		break;
        	} else {
        		hashtable.put(target - numbers[i], i);
        	}
        }
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2,7,11,15};
		int[] result = twoSum(numbers, 22);
		System.out.println(result[0]);
		System.out.println(result[1]);		

	}

}
