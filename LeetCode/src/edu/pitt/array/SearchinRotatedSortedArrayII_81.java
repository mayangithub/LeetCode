/**
 * 
 */
package edu.pitt.array;

/**
 * Search in Rotated Sorted Array II #81 --- Accepted 372ms
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * @author Yan-PC
 * @since 2015-05-29
 * @version 2015-05-29
 */
public class SearchinRotatedSortedArrayII_81 {

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return false;
        } if (nums.length == 1) {
        	return (nums[0] == target)? true: false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        return helper(nums, target, start, end);
    }
    
    public static boolean helper(int[] nums, int target, int start, int end) {
    	if (start == end) {
    		return (nums[start] == target)? true: false;
    	} else if (start > end) {
    		return false;
    	} else if (end - start == 1) {
    		return (nums[start] == target) || (nums[end] == target);
    	}
    	
    	int mid = (start + end) / 2;
    	if (nums[mid] == target) {
        	return true;
        } else if (nums[mid] == nums[start]) { // from start to mid, all identical or different
        	return helper(nums, target, start + 1, end);
        } else if (nums[mid] >= nums[start] && nums[mid] >= nums[end]) { // left sorted
        	if (target >= nums[start] && target <= nums[mid]) { // in left part
        		return helper(nums, target, start, mid);
        	} else if (target >= nums[mid] || target <= nums[end]) { // in right part
        		return helper(nums, target, mid, end);
        	} else {
        		return false;
        	}
        } else if (nums[mid] <= nums[end] && nums[mid] <= nums[start]) { // right sorted
        	if (target >= nums[mid] && target <= nums[end]) { // in right part
        		return helper(nums, target, mid, end);
        	} else if (target <= nums[mid] || target >= nums[end]) { // in left part
        		return helper(nums, target, start, mid);
        	} else {
        		return false;
        	}
        } else if (nums[start] <= nums[end]) { // sorted
        	return binarySearch(nums, target, start, end);
        } 
    	return false;
    }
    
    //add while loop to jump over same number in array
    public static boolean binarySearch(int[] nums, int target, int start, int end) {
    	if (nums == null || nums.length == 0 || start > end) {
    		return false;
    	} else if (start == end) {
    		return (nums[start] == target) ? true: false;
    	}
    	int mid = (start + end) / 2;
    	if (nums[mid] == target) {
    		return true;
    	} else if (target > nums[mid]) {
    		while (mid <= nums.length - 2 && nums[mid + 1] == nums[mid]) {
				mid++;
			}
    		start = mid + 1;
    	} else {
    		while (mid >= 1 && nums[mid - 1] == nums[mid]) {
				mid--;
			}
    		end = mid - 1;
    	}
    	return binarySearch(nums, target, start, end);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};
		int[] nums1 = {0, 1,2,3,3,3};
		int[] nums2 = {1,3,1,1,1};
		int[] nums3 = {1,1,1,1,3};
		int target = 0;
		int target1 = 1;
		int target2 = 2;
		int target3 = 4;
		int target4 = 3;
		System.out.println(search(nums, target));
		System.out.println(search(nums, target1));
		System.out.println(search(nums, target2));
		System.out.println(search(nums1, target3));
		System.out.println(search(nums2, target4));
		System.out.println(search(nums3, target));
	}

}
