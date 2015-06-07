/**
 * 
 */
package edu.pitt.array;

/**
 * Trapping Rain Water #42 --- Accepted 404ms
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 *  compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 *   ^
 * 4_|
 * 3_|                            ___
 * 2_|            ___            |   |___     ___
 * 1_|    ___    |   |___     ___|   |   |___|   |___
 * 0_|___|___|___|___|___|___|___|___|___|___|___|___|_____->
 *   0   1   2   3   4   5   6   7   8   9   10  11  12    
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped. 
 * @author yanma
 * @since 2015-06-06
 * @version 2015-06-07
 */
public class TrappingRainWater_42 {

	
    public static int trap(int[] height) {
        
    	if (height == null || height.length < 3) {
    		return 0;
    	}
    	
    	int result = 0;
    	int start = 0;
    	int end = height.length - 1;
    	
    	while (height[start] == 0) {
			start++;
		}
    	
    	int lefthigh = height[start++];
    	int righthigh = height[end--];
    	int boundry = 0;
    	
    	while (start < end) {
    		if (lefthigh <= righthigh) { //move left
    			if (height[start] > lefthigh) {
    				lefthigh = height[start];
    			} 
    			boundry = Math.min(lefthigh, righthigh);
    			result += (boundry > height[start])? boundry - height[start]: 0;
    			start++;
    		} else {//move right
    			if (height[end] > righthigh) {
    				righthigh = height[end];
    			} 
    			boundry = Math.min(lefthigh, righthigh);
    			result += (boundry > height[end])? boundry - height[end]: 0;
    			end--;
    		}
		}
    	
    	if (start == end) {
    		boundry = Math.min(lefthigh, righthigh);
			result += (boundry > height[start])? boundry - height[start]: 0;
    	}
    	
    	return result;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2, 1};
//		int[] height = {5,3,7,7};
//		int[] height = {5,2,1,2,1,5};
//		int[] height = {5,5,1,7,1,1,5,2,7,6};
		
		System.out.println(trap(height));
		
		
		
	}

}
