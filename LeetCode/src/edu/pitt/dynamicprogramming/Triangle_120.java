/**
 * 
 */
package edu.pitt.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Triangle #120 --- Accepted 273ms
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 * @author yanma
 * @since 2015-05-12
 * @version 2015-05-12
 */
public class Triangle_120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
        	return 0;
        } else if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
        
        int height = triangle.size();
        
        for (int level = height - 2; level >= 0; level--) {
        	for (int index = 0; index < triangle.get(level).size(); index++) {
				int left = triangle.get(level).get(index) + triangle.get(level + 1).get(index);
				int right = triangle.get(level).get(index) + triangle.get(level + 1).get(index + 1);
				triangle.get(level).set(index, Math.min(left, right));
			}
        }
        
        return triangle.get(0).get(0);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list0 = new ArrayList<Integer>();
		list0.add(2);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(3); list1.add(4); 
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(6); list2.add(5); list2.add(7); 
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(4); list3.add(1); list3.add(8); list3.add(3); 
		List<List<Integer>> list = new ArrayList<>();
		list.add(list0); list.add(list1); list.add(list2); list.add(list3); 
		
		System.out.println(minimumTotal(list));
	}

}
