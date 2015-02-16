package edu.pitt.array;

/**
 * Majority Element #169  232 ms -- accepted
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @tags Divide and Conquer, Array, Bit Manipulation
 * @author yanma
 *
 * @since 2015-02-15
 * @version 2015-02-15
 */
public class MajorityElement_169 {

	
	public static int majorityElement(int[] num) {
		int result = 0;
        /**
         * 1. create another boolean array copy[], initialize all elements are false and length equals to num array length
         * 2. pointer k in copy array from 0, k < length
         * 3. if copy[k] = false, count = 1, i = k + 1, copy[k] = true, if num[i] = num[k], count++, copy[i] = true; if count > floor(n/2) return num[k]; otherwise i++; i = length-1, k++
         */
		
		boolean[] copy = new boolean[num.length];
		java.util.Arrays.fill(copy, false);
		int count;
		for (int k = 0; k < num.length; k++) {
			count = 0;
			if (copy[k] == false) {
				for (int i = k; i < num.length; i++) {
					if (copy[i] == false && num[i] == num[k]) {
						count++;
						copy[i] = true;
						if (count > num.length/2) {
							return num[k];
						}
					}
				}	
			}
		}
		
		
		return result;
    }
	
	
	/**
	 * if (copy[k] == false) {
				for (int i = k; i < num.length; i++) {
					if (copy[i] == false && num[i] == num[k]) {
	 * 
	 * can be wrote to 
	 * 
	 * if (copy[k] == false) {
			copy[k] = true;
			for (int i = k; i < num.length; i++) {
				if (num[i] == num[k]) {
	 *
	 * I think the first one is much faster
	 * because it would skip the num[i] which has been tested before
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3};
		System.out.println("element: " + majorityElement(num));
	}

}
