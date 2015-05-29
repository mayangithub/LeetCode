/**
 * 
 */
package edu.pitt.array;

/**
 * Search in Rotated Sorted Array #33 --- Accepted 308ms
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author Yan-PC
 * @since 2015-05-28
 * @version 2015-05-28
 */
public class SearchinRotatedSortedArray_33 {

    public static int search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
    		return -1;
    	} else if (nums.length == 1) {
    		return (nums[0] == target) ? 0: -1;
    	}
    	
    	int left = 0;
    	int right = nums.length - 1;
    	if (nums[left] < nums[right]) {//sorted
    		return binarySearch(nums, target, left, right);
    	}
    	
    	return helper(nums, target, left, right);
    	
    }
    
    public static int helper(int[] nums, int target, int start, int end) {
    	if (start > end) {
    		return -1;
    	}
    	
    	int mid = (start + end) / 2;
    	
    	if (nums[mid] >= nums[start]) { //left part is sorted
    		if (target >= nums[start] && target <= nums[mid]) {//in left sorted array
    			return binarySearch(nums, target, start, mid);
    		} else if (target <= nums[end] || target >= nums[mid]) {
    			start = mid + 1;
    		} else {
    			return -1;
    		}
    	} else { // right part is sorted
    		if (target == nums[mid]) {
    			return mid;
    		} else {
    			if (target <= nums[end] && target >= nums[mid]) {
    				start = mid + 1;
    			} else if (target >= nums[start] || target <= nums[mid]) {
    				end = mid - 1;
    			} else {
    			    return -1;
    			}
    		}
    	}
    	return helper(nums, target, start, end);
    	
    }
    
    
    
    public static int binarySearch(int[] nums, int target, int start, int end) {
    	if (start > end || (start == end && nums[start] != target)) {
    		return -1;
    	}
    	if (nums[start] == target) {
    		return start;
    	} else if (nums[end] == target) {
    		return end;
    	} 
    	int mid = (start + end) / 2;
    	if (nums[mid] == target) {
    		return mid;
    	} else if (target > nums[mid]) {
    		return binarySearch(nums, target, mid + 1, end);
    	} else {
    		return binarySearch(nums, target, start, mid - 1);
    	}
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {4,5,6,7,0,1,2};
//		int[] nums1 = {2,4,5,6,7,0,1};
//		int[] nums2 = {6,7,0,1,2,4,5};
//		int[] nums3 = {1,3};
//		int[] nums4 = {3,1};
		int[] nums5 = {5,1,3};
		
//		System.out.println("nums find 6: " + search(nums, 6));
//		System.out.println("nums find 7: " + search(nums, 7));
//		System.out.println("nums find 4: " + search(nums, 4));
//		System.out.println("nums find 0: " + search(nums, 0));
//		System.out.println("nums find 3: " + search(nums, 3));
//		System.out.println("nums find 2: " + search(nums, 2));
//		System.out.println("nums1 find 6: " + search(nums1, 6));
//		System.out.println("nums1 find 7: " + search(nums1, 7));
//		System.out.println("nums1 find 4: " + search(nums1, 4));
//		System.out.println("nums1 find 0: " + search(nums1, 0));
//		System.out.println("nums1 find 3: " + search(nums1, 3));
//		System.out.println("nums1 find 2: " + search(nums1, 2));
//		System.out.println("nums2 find 6: " + search(nums2, 6));
//		System.out.println("nums2 find 7: " + search(nums2, 7));
//		System.out.println("nums2 find 4: " + search(nums2, 4));
//		System.out.println("nums2 find 0: " + search(nums2, 0));
//		System.out.println("nums2 find 3: " + search(nums2, 3));
//		System.out.println("nums2 find 2: " + search(nums2, 2));
//		System.out.println("nums3 find 0: " + search(nums3, 0));
//		System.out.println("nums4 find 0: " + search(nums4, 0));
		System.out.println("nums5 find 4: " + search(nums5, 4));
	}

}
