/**
 * 
 */
package edu.pitt.array;

/**
 * Find Peak Element #162 --- Accepted
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * @author yanma
 * @since 2015-03-26
 * @version 2015-03-26
 *
 */
public class FindPeakElement_162 {
	/**
	 * Accepted 237ms
	 * @param num
	 * @return
	 */
    public static int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        } else if (num.length == 1) {
        	return 0;
        } else if (num.length == 2) {
        	return (num[0] > num[1])? 0: 1;
        } else {
        	int low = 0;
        	int high = num.length - 1;
        	int mid = (num.length % 2 == 0)? num.length / 2 - 1: num.length / 2;
        	
        	if ((num[mid] > num[mid - 1]) && (num[mid] > num[mid + 1])) {
        		return mid;
        	} else {
        		int[] left = java.util.Arrays.copyOfRange(num, low, mid + 1);
        		int lpos = findPeakElement(left);
        		
        		int[] right = java.util.Arrays.copyOfRange(num, mid, high + 1);
        		int rpos = findPeakElement(right);
        		
        		return (num[lpos] > num[mid + rpos])? lpos: mid + rpos;
        	}
        }
    }
    
    /**
     * Accepted 248ms
     * @param num
     * @return
     */
    public static int findPeakElement1(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        } else if (num.length == 1) {
        	return 0;
        } else if (num.length == 2) {
        	return (num[0] > num[1])? 0: 1;
        } else {
        	int low = 0;
        	int high = num.length - 1;
        	int mid = (num.length % 2 == 0)? num.length / 2 - 1: num.length / 2;
        	
        	if ((num[mid] > num[mid - 1]) && (num[mid] > num[mid + 1])) {
        		return mid;
        	} else {
        		int[] left = java.util.Arrays.copyOfRange(num, low, mid + 1);
        		int lpos = findPeakElement(left);
        		
        		int[] right = java.util.Arrays.copyOfRange(num, mid + 1, high + 1);
        		int rpos = findPeakElement(right);
        		
        		return (num[lpos] >= num[mid + rpos + 1])? lpos: mid + rpos + 1;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {1,2,4,3,1};
		int[] num1 = {2,1,4,5,3};
		int[] num2 = {1,2,3,1};
		int[] num3 = {1,3,2,1};
		int[] num4 = {4,1,2,5,3};
		int[] num5 = {1,2,3};
		int[] num6 = {2,1,2};
		
		System.out.println("{1,2,4,3,1}: " + findPeakElement1(num));
		System.out.println("{2,1,4,5,3}: " + findPeakElement1(num1));
		System.out.println("{1,2,3,1}: " + findPeakElement1(num2));
		System.out.println("{1,3,2,1}: " + findPeakElement1(num3));
		System.out.println("{4,1,2,5,3}: " + findPeakElement1(num4));
		System.out.println("{1,2,3}: " + findPeakElement1(num5));
		System.out.println("{2,1,2}: " + findPeakElement1(num6));
	}

}
