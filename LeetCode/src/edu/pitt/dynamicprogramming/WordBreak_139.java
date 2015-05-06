/**
 * 
 */
package edu.pitt.dynamicprogramming;

import java.util.Set;

/**
 * Word Break #139 --- Accepted 310ms
 *  Given a string s and a dictionary of words dict, 
 *  determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *  For example, given
 *  s = "leetcode",
 *  dict = ["leet", "code"].
 *  Return true because "leetcode" can be segmented as "leet code". 
 * @author yanma
 * @since 2015-05-05
 * @version 2015-05-05
 */
public class WordBreak_139 {
	
	/**
	 * Accepted 310ms
	 * @param s
	 * @param wordDict
	 * @return
	 */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
        	return false;
        }
        
        boolean[] trueArray = new boolean[s.length() + 1];
        trueArray[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
        	if (trueArray[i]) { // means be a word in dict
        		for (String word : wordDict) {
    				int length = word.length();
    				if (i + length <= s.length() && !trueArray[i + length] && s.substring(i, i + length).equals(word)) {
    					trueArray[i + length] = true; // means be another word in dict
    				}
    			}
        	}
        }
        
        return trueArray[s.length()]; // use all letters to consist words
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
