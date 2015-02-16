package edu.pitt.array;

import java.util.*;
import java.util.List;


/**
 * Pascal's Triangle #118 -- accepted
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *       [1],
 *      [1,1],
 *     [1,2,1],
 *    [1,3,3,1],
 *   [1,4,6,4,1]
 * ]

 * @author yanma
 * @since 2015-02-13
 * @version 2015-02-13
 * 
 * Problem: 
 * the convert between list and ArrayList
 * 
 * Note:
 * import java.util.List, instead of java.awt.List
 * the later one can not be parameterized
 */
public class PascalTriangle_118 {

	public static List<List<Integer>> generate(int numRows) {
		
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempArrayList = new ArrayList<Integer>();
        
        if (numRows == 0) {
        	return result;
        }
        
        for (int i = 0; i < numRows; i++ ) {
        	List<Integer> list = new ArrayList<Integer>();
        	if (i == 0) {
            	list.add(1);
            } else if (i == 1) {
            	list.add(1);
            	list.add(1);
            	
			} else {
				int number = i + 1;
				tempArrayList = result.get(i - 1);
				
				for (int k = 0; k < tempArrayList.size(); k++) {
					System.out.print(tempArrayList.get(k) + ",");
				}
				System.out.println();
				
				for (int j = 0; j < number; j++) {
	        		if (j == 0 || j == number - 1) {
	            		list.add(1);
	            	} else {
	            		
	            		int addition = tempArrayList.get(j-1) + tempArrayList.get(j);
	            		
	            		System.out.println("sum: " + tempArrayList.get(j-1) + "+" + tempArrayList.get(j) + "=" + addition);
		        		list.add(addition);
					}
	        	}
			}
        	
        	for (int k = 0; k < list.size(); k++) {
				System.out.print(list.get(k) + ",");
			}
			System.out.println();
			
			
        	result.add(list);
        	
        }
        
        return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = generate(5);
		
//		for (int i = 0; i< 5; i++) {
//			ArrayList<Integer> list = result.get(i);
//			
//			System.out.println("-------");
//			
//		}
		
	}

}
