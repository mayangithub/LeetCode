/**
 * 
 */
package edu.pitt.string;

/**
 * Longest Palindromic Substring #5 --- accepted 392ms
 * a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author yanma
 * @since 2015-04-29
 * @version 2015-04-29
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
        	return s;
        }
        
        int length = 0;
        int left = 0;
        int right = s.length() - 1;
        
        boolean[][] truthtable = new boolean[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
        	for (int j = i; j < s.length(); j++) {
        		if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || truthtable[i+1][j-1])) {
        			truthtable[i][j] = true;
        			
        			if (length < j - i + 1) {
        				length = j - i + 1;
        				left = i;
        				right = j;
        			}
        			
        		}
        	}
        }
        
        return s.substring(left, right + 1);
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
