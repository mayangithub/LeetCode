/**
 * 
 */
package edu.pitt.hashtable;

/**
 * Longest Substring Without Repeating Characters  #3 --- Accepted 317ms
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author yanma
 * @since 2015-03-25
 * @version 2015-03-25
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        
        int maxlength = 0;
        int length = 0;
        
        java.util.Hashtable<String, Integer> hashtable = new java.util.Hashtable<String, Integer>();
        int i = 0;
        int j = i;
                
        while (i < s.length() - 1 && j < s.length()) {
            if (hashtable.containsKey(s.substring(j, j+1))) {
                if (hashtable.get(s.substring(j, j+1)) < i){
                    length++;
                    if (length > maxlength) {
                        maxlength = length;
                    }
                } else {
                    if (length > maxlength) {
                        maxlength = length;
                    }
                    i = hashtable.get(s.substring(j, j+1)) + 1;
                    length = j - i + 1;
                }
            } else {
                length++;
                if (length > maxlength) {
                    maxlength = length;
                }
            }
            hashtable.put(s.substring(j, j+1), j);
            j++;
        }
        if (length > maxlength) {
            maxlength = length;
        }
        
        
       return maxlength; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
