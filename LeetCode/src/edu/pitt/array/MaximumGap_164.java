/**
 * 
 */
package edu.pitt.array;

import java.util.Arrays;

/**
 * Maximum Gap #164 --- Accepted 396ms/328ms
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * @author yanma
 * @since 2015-06-15
 * @version 2015-06-15
 */
public class MaximumGap_164 {
	
	/**
	 * Accepted 396ms
	 * using buckets
	 * @param nums
	 * @return
	 */
	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
        	return 0;
        }
		int max = findMax(nums);
		int min = findMin(nums);
		
		int period = ((max - min) / (nums.length - 1) == 0)? (max - min) / (nums.length - 1) + 1: (max - min) / (nums.length - 1); //for each bucket
		int nOfBucket = (max - min) / period + 1;
		
		java.util.HashMap<Integer, Bucket> hashMap = new java.util.HashMap<Integer, Bucket>();
		
		for (int i : nums) {
			int loc = (i - min) / period;
			if (!hashMap.containsKey(loc)) {
				hashMap.put(loc, new Bucket());
				hashMap.get(loc).maximum = i;
				hashMap.get(loc).minimum = i;
			} else {
				Bucket bucket = hashMap.get(loc);
				if (bucket.maximum < i) {
					bucket.maximum = i;
				}
				if (bucket.minimum > i) {
					bucket.minimum = i;
				}
			}
		}
		
		int maxgap = 0;
		int pre = 0;
		int post = 1;
		while (post < nOfBucket) {
			if (!hashMap.containsKey(post) || hashMap.get(post) == null) {
				post++;
			} else {
				int ceiling = hashMap.get(post).minimum;
				int floor = hashMap.get(pre).maximum;
				maxgap = (ceiling - floor > maxgap) ? ceiling - floor: maxgap;
				pre = post;
				post = pre + 1;
			}
		}
		
		return maxgap;
    }
	
	public static int findMax(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}
	
	public static int findMin(int[] nums) {
		int min = nums[0];
		for (int i : nums) {
			min = (i < min) ? i: min;
		}
		return min;
	}
	
	
	
	/**
	 * cheating solution 328ms
	 * @param nums
	 * @return
	 */
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return 0;
        }
        
        Arrays.sort(nums);
        int gapMax = 1;
        int gap = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] - nums[i - 1] > 1) {
				gap = nums[i] - nums[i - 1];
				gapMax = (gap > gapMax) ? gap: gapMax;
			} else {
				gap = 1;
			}
        }
        
        return gapMax;
    }
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,1,5,5,5,5,5};
//		int[] nums = {1, 100000};
		
		System.out.println(maximumGap(nums));
		
	}

}
