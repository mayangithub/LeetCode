/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning #131 --- Accepted 324ms
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
 *  Return all possible palindrome partitioning of s.
 *  For example, given s = "aab",
 *  Return
 *   [
 *     ["aa","b"],
 * 	   ["a","a","b"]
 *   ]
 * @author yanma
 * @since 2015-05-15
 * @version 2015-05-15
 */
public class PalindromePartitioning_131 {

	
    public List<List<String>> partition(String s) {
    	List<List<String>> list = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
        	return list;
        } else if (s.length() == 1) {
        	List<String> innerList = new ArrayList<String>();
        	innerList.add(s);
        	list.add(innerList);
        	return list;
        }
        
        helper(s, 0, list, new ArrayList<String>());
        
        return list;
    }
	
	
    public void helper(String s, int index, List<List<String>> list, List<String> innerList) {
    	if (index == s.length()) {
    		list.add(new ArrayList<>(innerList));
    	}
    	
    	for (int length = 1; index + length <= s.length(); length++) {
    		String subString = s.substring(index, index + length);
    		if (isPalindrome(subString)) {
    			innerList.add(subString);
    			helper(s, index + length, list, innerList);
    			innerList.remove(innerList.size() - 1);
    		}
    	}
    	
    }
    
    public boolean isPalindrome(String s) {
    	int start = 0;
    	int end = s.length() - 1;
    	while (start <= end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
    	return true;
    }
    
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
