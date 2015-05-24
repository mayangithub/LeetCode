/**
 * 
 */
package edu.pitt.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Anagrams #49 --- Accepted 384ms
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * can be multiple groups of anagrams, base strings can be different
 * @author yanma
 * @since 2015-05-24
 * @version 2015-05-24
 */
public class Anagrams_49 {

	/**
	 * @testcases
	 * 1. input: ["",""] expected: ["",""]
	 * 2. input: ["c","c"] expected: ["c","c"]
	 * 3. input: ["ant", "ant"] expected: ["ant", "ant"]
	 * 4. input: ["tea","and","ate","eat","dan"] expected: ["and","dan","tea","ate","eat"]
	 */
	
	
	
    public static List<String> anagrams(String[] strs) {
        /**
         * 1. use hash table to store all sorted strings as key, value, the first string with this key
         * 2. if same key string occurs, create a list, add the value first, then add this new word
         */
    	List<String> list = new ArrayList<String>();
    	if (strs == null || strs.length == 0) {
    		return list;
    	}
    	
    	java.util.Hashtable<String, String> hashtable = new java.util.Hashtable<>();
    	for (String word: strs) {
    		char[] array = word.toCharArray();
    		Arrays.sort(array);
    		String newword = charArraytoString(array);

    		if (hashtable.containsKey(newword)) {
    			if (!list.contains(hashtable.get(newword))) {
    				list.add(hashtable.get(newword));
    			} 
    			list.add(word);
    		} else {
    			hashtable.put(newword, word);
    		}
    	}
    	
    	return list;
    }
	
	public static String charArraytoString(char[] charArray) {
		StringBuffer buffer = new StringBuffer();
		for (char c: charArray) {
			buffer.append(c);
		}
		return buffer.toString();
	}
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a", "a"};
		List<String> list = anagrams(strs);
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("\"" + list.get(i));
			if (i != list.size() - 1) {
				System.out.print("\", ");
			} else {
				System.out.print("\"");
			}
		}
		System.out.println("]");
		
		
		
	}

}
