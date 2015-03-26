/**
 * 
 */
package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 4Sum #18 --- Accepted 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * @author yanma
 * @since 2015-03-25
 * @version 2015-03-25
 */
public class Sum4_18 {
	/**
	 * Accepted 427ms
	 * @param num
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	
        if (num == null || num.length < 4) {
        	return resultList;
        }
        
        java.util.Arrays.sort(num);
        
        int first = num[0] - 1;
        for (int i = 0; i < num.length - 3; i++) {
        	if (num[i] == first) {
        		continue;
        	}
        	
        	int sum = target - num[i];
        	
        	int j = i + 1;
        	int second = num[j] - 1;
        	for (; j < num.length - 2; j++) {
        		if (num[j] == second) {
        			continue;
        		}
        		int start = j + 1;
            	int end = num.length - 1;
            	while (start < end) {
            		int sum3 = num[j] + num[start] + num[end];
            		if (sum3 == sum) {
            			List<Integer> list = new ArrayList<Integer>();
            			list.add(num[i]);
            			list.add(num[j]);
            			list.add(num[start]);
            			list.add(num[end]);
            			resultList.add(list);
            			start++;
            			end--;
            			
            			while (start < end && num[start] == num[start - 1]) {
                			start++;
                		}
                		
                		while (start < end && num[end] == num[end + 1]) {
                			end--;
                		}
                		
            		} else if (sum3 > sum) {
            			end--;
            			while (start < end && num[end] == num[end + 1]) {
                			end--;
                		}
            		} else {
            			start++;
            			while (start < end && num[start] == num[start - 1]) {
                			start++;
                		}
            		}
            		
            		
            	}
            	second = num[j];
        	}
        	
        	first = num[i];
        }
        
        return resultList;
    }
    
    /**
     * Accepted 479ms
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] num, int target) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	
        if (num == null || num.length < 4) {
        	return resultList;
        }
        
        java.util.Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	
        	int sum = target - num[i];
        	
        	for (int j = i + 1; j < num.length - 2; j++) {
        		if (j != i + 1 && num[j] == num[j - 1]) {
        			continue;
        		}
        		int start = j + 1;
            	int end = num.length - 1;
            	while (start < end) {
            		int sum3 = num[j] + num[start] + num[end];
            		if (sum3 == sum) {
            			List<Integer> list = new ArrayList<Integer>();
            			list.add(num[i]);
            			list.add(num[j]);
            			list.add(num[start]);
            			list.add(num[end]);
            			resultList.add(list);
            			start++;
            			end--;
            			
            			while (start < end && num[start] == num[start - 1]) {
                			start++;
                		}
                		
                		while (start < end && num[end] == num[end + 1]) {
                			end--;
                		}
                		
            		} else if (sum3 > sum) {
            			end--;
            			while (start < end && num[end] == num[end + 1]) {
                			end--;
                		}
            		} else {
            			start++;
            			while (start < end && num[start] == num[start - 1]) {
                			start++;
                		}
            		}
            		
            		
            	}
        	}
        	
        }
        
        return resultList;
    }
    
    /**
     * Accepted 410ms
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] num, int target) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	
        if (num == null || num.length < 4) {
        	return resultList;
        }
        
        java.util.Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	
        	int sum = target - num[i];
        	
        	for (int j = i + 1; j < num.length - 2; j++) {
        		if (j != i + 1 && num[j] == num[j - 1]) {
        			continue;
        		}
        		int start = j + 1;
            	int end = num.length - 1;
            	while (start < end) {
            		int sum3 = num[j] + num[start] + num[end];
            		if (sum3 == sum) {
            			List<Integer> list = new ArrayList<Integer>();
            			list.add(num[i]);
            			list.add(num[j]);
            			list.add(num[start]);
            			list.add(num[end]);
            			resultList.add(list);
            			start++;
            			end--;
            			
            			while (start < end && num[start] == num[start - 1]) {
                			start++;
                		}
                		
                		while (start < end && num[end] == num[end + 1]) {
                			end--;
                		}
                		
            		} else if (sum3 > sum) {
            			end--;
            		} else {
            			start++;
            		}
            	}
        	}
        }
        
        return resultList;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
