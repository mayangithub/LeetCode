/**
 * 
 */
package edu.pitt.array;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Container With Most Water #11 --- Accepted 317ms
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container. 
 * @author yanma
 * @since 2015-03-24
 * @version 2015-03-24
 *
 */
public class ContainerWithMostWater_11 {

	/**
	 * Time limit exceeded
	 * @param height
	 * @return
	 */
    public int maxArea1(int[] height) {
    	if (height == null || height.length < 2) {
            return 0;
        }
        
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            int index = i;
            for (int j = 0; j < height.length; j++) {
                if (j == i) {
                    continue;
                }
                
                if (height[j] >= height[i]) {
                    if (Math.abs(j - i) > Math.abs(index - i)) {
                        index = j;
                    }
                }
            }
            
            area = i * Math.abs(index - i);
        }
        
        return area;
    }
    
    /**
     * Accepted 317ms
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
        	return 0;
        }
        
        int area = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
        	if ((high - low) * Math.min(height[low], height[high]) > area) {
        		area = (high - low) * Math.min(height[low], height[high]);
        	}
        	
        	if (height[low] < height[high]) {
        		low++;
        	} else {
        		high--;
        	}
        }
        return area;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
