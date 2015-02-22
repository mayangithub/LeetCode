/**
 * 
 */
package edu.pitt.string;

/**
 * Longest Common Prefix #14 --- accepted 314ms
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * 
 * @author yanma
 * @since 2015-02-20
 * @version 2015-02-20
 *
 */
public class LongestCommonPrefix_14 {

	public String longestCommonPrefix(String[] strs) {
		/**
		 * 思路：
		 * 1. if strs is null or empty, return ""
		 * 2. set prefix = strs[0]
		 * 3. pointer k goes from strs[1] to strs[length - 1], pointer i points to prefix, pointer j = i points to strs[k]
		 * 4. if the strs[k].charAt(j) != prefix.charAt(i), prefix = prefix.subString(0, i)
		 * 5. i in range [0, prefix.length()-1], j = i
		 * 6. if the strs[k].charAt(j) == prefix.charAt(i), keep the prefix, k++
		 * 
		 * 
		 * *******
		 * 1. if prefix has more chars than strs[k]
		 */
		
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		String prefix = strs[0];
		for (int k = 1; k < strs.length; k++) {
			if (prefix.length() == 0) {
				break;
			}
			
			if (prefix.length() > strs[k].length()) {
				prefix = prefix.substring(0, strs[k].length());
			}
			for (int i = 0; i < prefix.length(); i++) {
				if (prefix.charAt(i) != strs[k].charAt(i)) {
					prefix = prefix.substring(0, i);
					break;
				}
			}
			
		}
		
		
	    return prefix;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
