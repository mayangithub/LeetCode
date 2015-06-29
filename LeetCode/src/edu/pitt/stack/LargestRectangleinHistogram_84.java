/**
 * 
 */
package edu.pitt.stack;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram #84 --- Accepted 468ms
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 *   ^
 * 7 |         __
 * 6 |      __|  |
 * 5 |     |  |  |
 * 4 |     |  |  |   __
 * 3 |__   |  |  |__|  |
 * 2 |  |__|  |  |  |  |
 * 1 |__|__|__|__|__|__|_____
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10. 
 * @author yanma
 * @since 2015-06-24
 * @version 2015-06-24
 */
public class LargestRectangleinHistogram_84 {
	
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
        	return 0;
        }
        
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>(); // store index
        for (int i = 0; i < height.length; i++) {
        	while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
        		int index = stack.pop();
        		int area = (stack.isEmpty()) ? i * height[index]: (i - stack.peek() - 1) * height[index]; // between i and peek(), have height higher than height[index]
        		max = Math.max(area, max);
        	}
        	stack.push(i); //keep stack in ascending order
        }
        
        while (!stack.isEmpty()) {
        	int index = stack.pop();
        	int area = (stack.isEmpty()) ? height.length * height[index]: (height.length - stack.peek() - 1) * height[index];
        	max = Math.max(max, area);
        }
        
        return max;
    }
	

}
