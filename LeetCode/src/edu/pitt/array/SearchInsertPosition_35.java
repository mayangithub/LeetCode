/**
 * 
 */
package edu.pitt.array;

/**
 * Search Insert Position #35 --- Accepted 230ms
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0 
 * @author yanma
 * @since 2015-03-30
 * @version 2015-03-30
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] A, int target) {
        if (A == null || target <= A[0] ) {
        	return 0;
        } else if (target > A[A.length - 1]) {
        	return A.length;
        } 
        
        int position;
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2;
        
        if (A[mid] == target) {
        	position = mid;
        	int[] subarray = java.util.Arrays.copyOfRange(A, start, mid);
        	if (searchInsert(subarray, target) < position) {
        		position = searchInsert(subarray, target);
        	}
        } else if (A[mid] < target) {
        	int[] rsubarray = java.util.Arrays.copyOfRange(A, mid + 1, end + 1);
        	position = searchInsert(rsubarray, target) + mid + 1;
        } else {
        	int[] lsubarray = java.util.Arrays.copyOfRange(A, start, mid);
        	position = searchInsert(lsubarray, target);
        }
        
        return position;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
