/**
 * 
 */
package edu.pitt.hashtable;

/**
 * Isomorphic Strings #205 --- Accepted 418ms
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note: You may assume both s and t have the same length.
 * @author yanma
 * @since 2015-04-28
 * @version 2015-04-28
 */
public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
    	if (s.length() != t.length()) {
        	return false;
        }
        
        java.util.Hashtable<Character, Character> hashtableS = new java.util.Hashtable<Character, Character>();
        java.util.Hashtable<Character, Character> hashtableT = new java.util.Hashtable<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	if (hashtableS.containsKey(s.charAt(i)) && hashtableT.containsKey(t.charAt(i))) {
        		if (!hashtableS.get(s.charAt(i)).equals(t.charAt(i)) || !hashtableT.get(t.charAt(i)).equals(s.charAt(i))) {
            		return false;
            	}
        	} else {
        		if (!hashtableS.containsKey(s.charAt(i))) {
        			hashtableS.put(s.charAt(i), t.charAt(i));
        		}
        		
        		if (!hashtableT.containsKey(t.charAt(i))) {
        			hashtableT.put(t.charAt(i), s.charAt(i));
        		}
        		
        		i--;
        	}
        }
        
        return true;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "egg";
		String s2 = "foo";
		String s3 = "paper";
		String s4 = "ab";
		String t1 = "add";
		String t2 = "bar";
		String t3 = "title";
		String t4 = "aa";
		
		System.out.println("s1, t1: " + isIsomorphic(s1, t1));
		System.out.println("s2, t2: " + isIsomorphic(s2, t2));
		System.out.println("s3, t3: " + isIsomorphic(s3, t3));
		System.out.println("s4, t4: " + isIsomorphic(s4, t4));
	}

}
