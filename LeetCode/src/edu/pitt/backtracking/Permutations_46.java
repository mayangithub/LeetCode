/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations #46 --- Accepted 306ms
 *  Given a collection of numbers, return all possible permutations.
 *  For example,
 *  [1,2,3] have the following permutations:
 *  [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 * @author yanma
 * @since 2015-05-14
 * @version 2015-05-14
 *
 */
public class Permutations_46 {

    public static List<List<Integer>> permute(int[] nums) {
    	List<List<List<Integer>>> wholelist = new ArrayList<>();
    	List<List<Integer>> list0 = new ArrayList<List<Integer>>();
        wholelist.add(0, list0);
        
    	if (nums == null || nums.length == 0) {
        	return list0;
        } 

    	int loop = 1;
    	while (loop <= nums.length) {
    		if (loop == 1) { // only 1 element
    			List<List<Integer>> list1 = new ArrayList<List<Integer>>();
    	        List<Integer> innerList = new ArrayList<>();
    	    	innerList.add(nums[0]);
    	    	list1.add(innerList);
    	    	wholelist.add(1, list1);
    		} else { // loop - 1 elements
    			List<List<Integer>> preList = wholelist.get(loop - 1);
    			List<List<Integer>> currList = new ArrayList<List<Integer>>();
    			for (List<Integer> innerList : preList) {
					int size = innerList.size();
					for (int index = 0; index <= size; index++) {
						List<Integer> permuteList = new ArrayList<>();
						permuteList.addAll(innerList);
						permuteList.add(index, nums[loop - 1]);
						currList.add(permuteList);
					}
				}
    			wholelist.add(currList);
    		}
    		loop++;
		}
                
        return wholelist.get(nums.length);
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 2, 3, 4, 5, 6};
		List<List<Integer>> list = permute(nums);
		
		int no = 1;
		for (List<Integer> innerList: list) {
			System.out.print(no + ". [");
			for (Integer integer : innerList) {
				System.out.print(integer + ", ");
			}
			System.out.println("]");
			no++;
		}
		
		
		
	}

}
