package edu.pitt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II #119 -- accepted
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space? 
 * @author yanma
 * 
 * @since 2015-02-13
 * @version 2015-02-13
 *
 */
public class PascalTriangleII_119 {

	public static List<Integer> getRow(int rowIndex) {
		int[] extra = new int[rowIndex + 1];
		
		/**
		 * 思路：
		 * 1. 确定array长度， rowIndex+1
		 * 2. 从第一排开始算，算到第rowIndex排，每次循环增加一个element
		 * 		最后一个是1，第j个等于[j]+[j-1], 第1个是1
		 * 3. 然后把array放到list里
		 */
		
		for (int i = 0; i <= rowIndex; i++) {
			for (int k = i; k >= 0; k--) {
				if (k == i || k == 0) {
					extra[k] = 1;
				}else {
					extra[k] = extra[k] + extra[k-1];
				}
			}
		}
		
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i <= rowIndex; i++) {
        	list.add(extra[i]);
        }
        return list;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> result = getRow(5);
		String string = "[";
		for (Integer integer : result) {
			string += integer + ", ";
		}
		string += "]";
		
		System.out.println(string);
	}

}
