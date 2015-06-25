/**
 * 
 */
package edu.pitt.divideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The Skyline Problem #218 --- Accepted 504ms
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), 
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, 
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, 
 * is merely used to mark the termination of the skyline, and always has zero height. 
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * Notes:
 *    The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 *    The input list is already sorted in ascending order by the left x position Li.
 *    The output list must be sorted by the x position.
 *    There must be no consecutive horizontal lines of equal height in the output skyline. 
 *    For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
 *    the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * @author yanma
 * @since 2015-06-24
 * @version 2015-06-24
 */
public class TheSkylineProblem_218 {
	
	/**
	 * Divide and Conquer
	 * Accepted 504ms
	 * @param buildings
	 * @return
	 */
    public static List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
        	return result;
        }
        int start = 0;
        int end = buildings.length - 1;
        
        result = divideconquer(buildings, start, end);
        
        return result;
    }
    
    
    public static List<int[]> divideconquer(int[][] buildings, int start, int end) {
    	if (start == end) {
    		List<int[]> onebuilding = new ArrayList<int[]>();
    		int[] left = {buildings[start][0], buildings[start][2]};
    		int[] right = {buildings[start][1], 0};
    		onebuilding.add(left);
    		onebuilding.add(right);
    		return onebuilding;
    	}
    	
    	if (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		List<int[]> firstList = divideconquer(buildings, start, mid);
    		List<int[]> secodnList = divideconquer(buildings, mid + 1, end);
    		return merge(firstList, secodnList);
    	}
    	
    	if (start + 1 == end) {
    		List<int[]> leftList = divideconquer(buildings, start, start);
    		List<int[]> rightList = divideconquer(buildings, end, end);
    		return merge(leftList, rightList);
    	}
    	
    	return null;
    }
    
    public static List<int[]> merge(List<int[]> list1, List<int[]> list2) {
    	List<int[]> result = new ArrayList<int[]>();
    	
    	int i = 0; 
    	int len1 = list1.size();
    	int j = 0;
    	int len2 = list2.size();
    	
    	int h1 = 0;
    	int h2 = 0;
    	
    	while (i < len1 && j < len2) {
			if (list1.get(i)[0] <= list2.get(j)[0]) {
				h1 = list1.get(i)[1]; // update h1
				if (!result.isEmpty() && result.get(result.size() - 1)[0] == list1.get(i)[0]) {
					result.get(result.size() - 1)[1] = Math.max(h1, h2);
				} else {
					int[] point = {list1.get(i)[0], Math.max(h1, h2)};
					result.add(point);
				}
				i++;
				continue;
			}
			
			if (list1.get(i)[0] > list2.get(j)[0]) {
				h2 = list2.get(j)[1]; // update h2
				if (!result.isEmpty() && result.get(result.size() - 1)[0] == list2.get(j)[0]) {
					result.get(result.size() - 1)[1] = Math.max(h1, h2);
				} else {
					int[] point = {list2.get(j)[0], Math.max(h1, h2)};
					result.add(point);
				}
				j++;
				continue;
			}
		}
    	
    	if (i == len1) {
    		while (j < len2) {
				h2 = list2.get(j)[1];
				if (!result.isEmpty() && result.get(result.size() - 1)[0] == list2.get(j)[0]) {
					result.get(result.size() - 1)[1] = Math.max(h1, h2);
				} else {
					int[] point = {list2.get(j)[0], Math.max(h1, h2)};
					result.add(point);
				}
				j++;
			}
    	}
    	
    	if (j == len2) {
    		while (i < len1) {
    			h1 = list1.get(i)[1]; // update h1
    			if (!result.isEmpty() && result.get(result.size() - 1)[0] == list1.get(i)[0]) {
					result.get(result.size() - 1)[1] = Math.max(h1, h2);
				} else {
					int[] point = {list1.get(i)[0], Math.max(h1, h2)};
					result.add(point);
				}
				i++;
			}
    	}
    	
    	removeDuplicate(result);
    	
    	return result;
    }
    
    
    public static void removeDuplicate(List<int[]> list) {
    	for (int i = 1; i < list.size(); i++) {
			if (list.get(i)[1] == list.get(i - 1)[1]) {
				list.remove(i);
				i--;
			}
		}
    }
    
	
	
	
	/**
	 * MLE
	 * @param buildings
	 * @return
	 */
    public static List<int[]> getSkyline1(int[][] buildings) {
    	List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
        	return result;
        }
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int start = buildings[0][0];
        int end = buildings[0][1];
        for (int[] building: buildings) {
        	int left = building[0];
        	int right = building[1];
        	int height = building[2];
        	end = Math.max(end, right);
        	for (int x = left; x <= right; x++) {
        		if (!hashMap.containsKey(x)) {
        			hashMap.put(x, height);
        		} else {
        			hashMap.put(x, Math.max(height, hashMap.get(x)));
        		}
        	}
        }
        
        int key = start;
        int pre = 0;
        while (key <= end + 1) {
        	if (!hashMap.containsKey(key)) {
        		if (pre != 0) {
        			int[] point = {key - 1, 0};
        			pre = 0;
        			result.add(point);
        		}
        		key++;
        		continue;
        	}
        	
        	if (hashMap.get(key) == pre) {
        		key++;
        		continue;
        	}
        	
        	int[] point = {0,0};
        	if (hashMap.get(key) > pre) {
        		point[0] = key; 
        	} else {
        		point[0] = key - 1;
        	}
        	point[1] = hashMap.get(key);
        	result.add(point);
        	pre = hashMap.get(key);
        	key++;
		}
        
        return result;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
//		int[][] buildings = {{0,1,3}};
//		int[][] buildings = {{0,2,3}, {2,5,3}};
		List<int[]> resultList = getSkyline(buildings);
		
		for (int[] is : resultList) {
			System.out.println(is[0] + ", " + is[1]);
		}
		
		
		
	}

}
