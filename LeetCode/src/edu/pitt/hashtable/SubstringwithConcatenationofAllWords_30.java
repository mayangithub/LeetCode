/**
 * 
 */
package edu.pitt.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Substring with Concatenation of All Words #30 --- Accepted 744ms
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter). 
 * @author yanma
 * @since 2015-06-18
 * @version 2015-06-18
 */
public class SubstringwithConcatenationofAllWords_30 {
	
	
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
    	if (s == null || s.length() < words[0].length()) {
    		return result;
    	}
    	
    	HashMap<String, Integer> toFind = new HashMap<String, Integer>();
    	HashMap<String, Integer> found = new HashMap<String, Integer>();
    	
    	for (String word : words) {
			if (!toFind.containsKey(word)) {
				toFind.put(word, 1);
			} else {
				toFind.put(word, toFind.get(word) + 1);
			}
		}
    	
    	int wordlen = words[0].length();
    	int tolen = words.length;
    	
    	for (int i = 0; i <= s.length() - tolen * wordlen; i++) {
			found.clear();
			int j;
			for (j = i; j <= i + tolen * wordlen - wordlen; ) {
				String temp = s.substring(j, j + wordlen);
				if (!toFind.containsKey(temp)) {
					break;
				}
				if (!found.containsKey(temp)) {
					found.put(temp, 1);
				} else {
					if (found.get(temp) == toFind.get(temp)) {
						break;
					} else {
						found.put(temp, found.get(temp) + 1);
					}
				}	
				j = j + wordlen;
			}
			if (j > i + tolen * wordlen - wordlen) {
				result.add(i);
			}
		}
    	
    	return result;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		
		List<Integer> result = findSubstring(s, words);
		for (Integer integer : result) {
			System.out.println(integer + ", ");
		}
		
		
	}

}
