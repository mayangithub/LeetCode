/**
 * 
 */
package edu.pitt.array;

/**
 * Find Minimum in Rotated Sorted Array #153 --- Accepted 198ms
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * @author yanma
 * @since 2015-03-26
 * @version 2015-03-26
 */
public class FindMinimumInRotatedSortedArray_153 {
    public static int findMin(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        } else if (num.length == 1) {
        	return num[0];
        } else if (num.length == 2) {
        	return Math.min(num[0], num[1]);
        } else {
        	int low = 0;
        	int high = num.length - 1;
        	if (num[low] < num[high]) {
        		return num[low];
        	} else {
        		int mid = num.length / 2;
        		if (num[mid] < num[mid - 1]) {
        			return num[mid];
        		} else {
        			int[] left = java.util.Arrays.copyOfRange(num, low, mid);
        			int lnum = findMin(left);
        			int[] right = java.util.Arrays.copyOfRange(num, mid, high + 1);
        			int rnum = findMin(right);
        			
        			return Math.min(lnum, rnum);
        		}
        	}
        }
    }
    
    /**
     * Accepted 198ms
     * if not rotated, num[low] must smaller than num[high]
     * if rotated, only if low = high, the num[low] = num[high] is the smallest number
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
     * @param num
     * @return
     */
    public static int findMin1(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        } else if (num.length == 1) {
        	return num[0];
        } else {
        	int low = 0;
        	int high = num.length - 1;
        	if (num[low] < num[high]) {
        		return num[low];
        	} else {
        		int mid = num.length / 2;
        	
    			int[] left = java.util.Arrays.copyOfRange(num, low, mid);
    			int lnum = findMin(left);
    			int[] right = java.util.Arrays.copyOfRange(num, mid, high + 1);
    			int rnum = findMin(right);
    			
    			return Math.min(lnum, rnum);
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
