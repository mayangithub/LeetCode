/**
 * 
 */
package edu.pitt.backtracking;

/**
 * Regular Expression Matching #10 --- Accepted 532ms
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * @author yanma
 * @since 2015-06-11
 * @version 2015-06-11
 */
public class RegularExpressionMatching_10 {
	
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0) {
        	return s.length() == 0;
        }
        
        if (p.length() == 1) {
        	if (s.length() != 1) return false;
        	if (p.equals(".")) return true;
        	else return s.equals(p);
        }
        
        if (p.charAt(1) != '*') {
        	if (p.charAt(0) == '.') {
        		if (s.length() == 0) return false;
        		String newS = (s.length() > 1) ? s.substring(1): "";
        		String newP = (p.length() > 1) ? p.substring(1): "";
        		return isMatch(newS, newP);
        	} else {
        		if (s.length() == 0 || p.charAt(0) != s.charAt(0)) return false;
        		String newS = (s.length() > 1) ? s.substring(1): "";
        		String newP = (p.length() > 1) ? p.substring(1): "";
        		return isMatch(newS, newP);
        	}
        	
        } else { //p.length >= 2
        	if (p.charAt(0) != '.') {
        		int i = 0;
        		char c = p.charAt(0);
        		while ( i < s.length() && s.charAt(i) == c) {
        			if (isMatch(s.substring(i), p.substring(2))) return true;
					i++;
				}
        		return isMatch(s.substring(i), p.substring(2));
        	} else {
        		int i = 0;
    			while (i < s.length()) {
    				if (isMatch(s.substring(i), p.substring(2))) return true;
    				i++;
    			}
    			return isMatch(s.substring(i), p.substring(2));
			}
		}
    }
    
    
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","a*a"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("a", ".*..a*"));
		System.out.println(isMatch("a","ab*"));

	}

}
