/**
 * 
 */
package edu.pitt.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses #22 --- Accepted 224ms/208ms
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *  For example, given n = 3, a solution set is:
 *  "((()))", "(()())", "(())()", "()(())", "()()()" 
 * @author yanma
 * @since 2015-05-06
 * @version 2015-05-07
 */
public class GenerateParentheses_22 {
	/**
	 * Accepted 224ms
	 * @param n
	 * @return
	 */
    public static List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
        if (n <= 0) {
        	return list;
        }
        helper(list, n, n, "");
        return list;
    }
    
    public static void helper(List<String> list, int open, int close, String s) {
    	if (close < open || open < 0) {
    		return;
    	}    	
    	if (close == 0) {
    		list.add(s);
    	}
    	
    	helper(list, open - 1, close, s + "(");
    	helper(list, open, close - 1, s + ")");
    }
    
    /**
     * Accepted 208ms
     * using DP
     * @param n
     * @return
     */
    public static List<String> generateParenthesis1(int n) {
    	List<String> list = new ArrayList<String>();
        if (n <= 0) {
        	return list;
        }
        
        List<List<String>> listArrayList = new ArrayList<List<String>>();
        
        List<String> list0 = new ArrayList<String>();
        list0.add("");
        listArrayList.add(0, list0);
        List<String> list1 = new ArrayList<String>();
        list1.add("()");
        listArrayList.add(1, list1);
        
        for (int i = 2; i <= n; i++) {
        	List<String> listi = new ArrayList<String>();
        	for (int j = 0; j < i; j++) {
        		for (String s: listArrayList.get(j)) {
        			for (String t: listArrayList.get(i-j-1)) {
        				listi.add("(" + s + ")" + t);
        			}
            	}
        	}
        	
        	listArrayList.add(i, listi);
        }
        
        return listArrayList.get(n);
    }
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = generateParenthesis1(3);
		for (String s : list) {
			System.out.print(s + ", ");
		}
		
	}

}
