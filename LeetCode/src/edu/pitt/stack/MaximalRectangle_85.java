/**
 * 
 */
package edu.pitt.stack;

import java.util.Stack;

/**
 * Maximal Rectangle #85 --- Accepted 348ms
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area. 
 * @author yanma
 * @since 2015-06-24
 * @version 2015-06-24
 */
public class MaximalRectangle_85 {
	
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
        	for (int c = 0; c < matrix[0].length; c++) {
        		if (matrix[r][c] != '0') {
        			height[c] = height[c] + 1;
        		} else {
        			height[c] = 0;
        		}
        	}
        	max = Math.max(max, largestRectangleArea(height));
        }
        
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
    	int max = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < height.length; i++) {
    		while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int index = stack.pop();
				int area = (stack.isEmpty()) ? i * height[index]: (i - stack.peek() - 1) * height[index];
    			max = Math.max(max, area);
			}
    		stack.push(i);
    	}
    	
    	while (!stack.isEmpty()) {
    		int index = stack.pop();
    		int area = (stack.isEmpty()) ? height.length * height[index]: (height.length - stack.peek() - 1) * height[index];
    		max = Math.max(max, area);
    	}
    	return max;
    }
	
	
	

}
