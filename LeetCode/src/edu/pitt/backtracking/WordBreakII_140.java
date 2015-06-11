/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break II #140  --- Accepted 300ms
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"]. 
 * @author yanma
 * @since 2015-06-10
 * @version 2015-06-10
 */
public class WordBreakII_140 {
	
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
        	return list;
        } 
        boolean[][] isWord = new boolean[s.length()][s.length()]; //row: start, col: end
        isWord(s, wordDict, isWord);
        boolean[] isPossible = new boolean[s.length() + 1]; //index: start from, there is a way 
        isPossible(isWord, isPossible);
        
        helper(s, wordDict, list, new ArrayList<String>(), isWord, isPossible, 0);
        
        return list;
    }
    
    public static void isWord(String s, Set<String> wordDict, boolean[][] isWord) {
    	for (int i = 0; i < s.length(); i++) { // i: 0 ~ s.length - 1
			for (int j = i; j < s.length(); j++) { // j: 0 ~ s.length - 1
				String word = (j < s.length() - 1) ? s.substring(i, j + 1): s.substring(i);
				if (wordDict.contains(word)) {
					isWord[i][j] = true; //start at i, end at j, include
				} else {
					isWord[i][j] = false;
 				}
			}
		}
    }
    
    public static void isPossible(boolean[][] isWord, boolean[] isPossible) {
    	isPossible[isPossible.length - 1] = true;
    	for (int i = isWord.length - 1; i >= 0; i--) {
			for (int j = i; j < isWord.length; j++) {
				if (isWord[i][j] && isPossible[j + 1]) {
					isPossible[i] = true; break;
				}
			}
		}
    }
    
    public static void helper(String s, Set<String> wordDict, List<String> list, List<String> inner, boolean[][] isWord, boolean[] isPossible, int start) {
    	if (!isPossible[start]) {
    		return;
    	}
    	
    	if (start == s.length()) {
    		list.add(buildSentence(inner));
    		return;
    	}
    	
    	for (int i = start; i < s.length(); i++) {
    		String word = (i < s.length() - 1) ? s.substring(start, i + 1): s.substring(start);
			if (isWord[start][i]) {
				inner.add(word);
				helper(s, wordDict, list, inner, isWord, isPossible, i + 1);
				inner.remove(inner.size() - 1);
			}
		}
    }
    
    public static String buildSentence(List<String> inner) {
    	StringBuffer sentence = new StringBuffer();
    	for (int i = 0; i < inner.size(); i++) {
    		sentence.append(inner.get(i));
			if (i < inner.size() - 1) {
				sentence.append(" ");
			}
		}
    	return sentence.toString();
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		s = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		String[] dict = {"cat", "cats", "and", "sand", "dog"};
		String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> wordDict = new HashSet<>();
		for (String string : dict) {
			wordDict.add(string);
		}		
		List<String> list = wordBreak(s, wordDict);
		for (String string : list) {
			System.out.println("\"" + string + "\"");
		}
		
		
	}

}
