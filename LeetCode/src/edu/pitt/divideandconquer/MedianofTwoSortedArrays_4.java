/**
 * 
 */
package edu.pitt.divideandconquer;

/**
 * ******Median of Two Sorted Arrays #4 --- Accepted 614ms
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author yanma
 * @since 2015-06-16
 * @version 2015-06-16
 */
public class MedianofTwoSortedArrays_4 {
	
	/**
	 * Accepted 614ms
	 * Time: O((n1 + n2)/2) Space: O(1)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
        	return 0;
        } else if (nums1.length == 0 && nums2.length > 0) {
        	if (nums2.length % 2 != 0) {
        		return nums2[nums2.length / 2];
        	} else {
        		return (double)(nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
        	}
        } else if (nums1.length > 0 && nums2.length == 0) {
        	if (nums1.length % 2 != 0) {
        		return nums1[nums1.length / 2];
        	} else {
        		return (double)(nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
        	}
        }
        
        int len = nums1.length + nums2.length;
        int mid = (len % 2 == 0) ? len / 2 - 1: (int)Math.ceil(len / 2);
        int count = -1;
        if (len % 2 != 0) { //odd, one median
        	int i = 0;
        	int j = 0;
        	int temp = 0;
        	while (count < mid && i < nums1.length && j < nums2.length) {
				if (nums1[i] <= nums2[j]) {
					temp = nums1[i];
					i++;
					count++;
				} else {
					temp = nums2[j];
					j++;
					count++;
				}
			}
        	if (count == mid && i < nums1.length && j < nums2.length) {
        		return temp;
        	}
        	
        	if (i == nums1.length) {
        		while (count < mid && j < nums2.length) {
					temp = nums2[j];
					j++;
					count++;
				}
        		if (count == mid) return temp;
        	} else if (j == nums2.length) {
        		while (count < mid && i < nums1.length) {
					temp = nums1[i];
					i++;
					count++;
				}
        		if (count == mid) return temp;
        	}
        	
        } else {//even, two median
        	int i = 0;
        	int j = 0;
        	int temp1 = 0;
        	int temp2 = 0;
        	while (count < mid && i < nums1.length && j < nums2.length) {
				if (nums1[i] <= nums2[j]) {
					temp1 = nums1[i];
					i++;
					count++;
				} else {
					temp1 = nums2[j];
					j++;
					count++;
				}
			}
        	if (count == mid && i < nums1.length && j < nums2.length) {
        		temp2 = Math.min(nums1[i], nums2[j]);
        		return (double)(temp1 + temp2) / 2;
        	}
        	
        	if (i == nums1.length) {
        		while (count < mid && j < nums2.length) {
					temp1 = nums2[j];
					j++;
					count++;
				}
        		if (count == mid) {
        			temp2 = nums2[j];
        			return (double)(temp1 + temp2) / 2;
        		}
        	} else if (j == nums2.length) {
        		while (count < mid && i < nums1.length) {
					temp1 = nums1[i];
					i++;
					count++;
				}
        		if (count == mid) {
        			temp2 = nums1[i];
        			return (double)(temp1 + temp2) / 2;
        		}
        	}
        }
        
        return 0;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2};
		int[] nums2 = {1,2,3};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
