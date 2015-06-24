/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Interleaving String #97 --- accepted 308ms
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false. 
 * @author yanma
 * @since 2015-06-23
 * @version 2015-06-23
 */
public class InterleavingString_97 {
	/**
	 * Accepted 308ms
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
    public static boolean isInterleave(String s1, String s2, String s3) {
    	if (s3 == null || (s1 == null && s2 == null) || s1.length() + s2.length() != s3.length()) {
        	return false;
        }
        if (s1 == null || s1.length() == 0) {
        	return s3.equals(s2);
        }
        if (s2 == null || s2.length() == 0) {
        	return s1.equals(s3);
        }
        
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i) && matrix[i][0]) {
				matrix[i + 1][0] = true;
			}
		}
        
        for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == s3.charAt(i) && matrix[0][i]) {
				matrix[0][i + 1] = true;
			}
		}
        
        for (int i = 0; i < s1.length(); i++) {
        	for (int j = 0; j < s2.length(); j++) {
        		if ((s1.charAt(i) == s3.charAt(i + j + 1) && matrix[i][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && matrix[i + 1][j])) {
        			matrix[i + 1][j + 1] = true;
        		}
        	}
        }
        
        return matrix[s1.length()][s2.length()];
    }
	
	
	
	
	
	
	/**
	 * TLE
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s3 == null || (s1 == null && s2 == null) || s1.length() + s2.length() != s3.length()) {
        	return false;
        }
        if (s1 == null || s1.length() == 0) {
        	return s3.equals(s2);
        }
        if (s2 == null || s2.length() == 0) {
        	return s1.equals(s3);
        }
        
        return helper(s1, s1.length() - 1, s2, s2.length() - 1, s3, s3.length() - 1);
    }
    
    public static boolean helper(String s1, int s1index, String s2, int s2index, String s3, int s3index) {
    	if (s3index == -1 && s1index == -1 && s2index == -1) {
    		return true;
    	}
    	
    	if (s1index >= 0 && s2index >= 0 && s3index >= 0) {
    		if (s3.charAt(s3index) != s1.charAt(s1index) && s3.charAt(s3index) != s2.charAt(s2index)) {
        		return false;
        	}
        	
        	if (s3.charAt(s3index) == s1.charAt(s1index) && s3.charAt(s3index) != s2.charAt(s2index)) {
        		return helper(s1, s1index - 1, s2, s2index, s3, s3index - 1);
        	}
        	
        	if (s3.charAt(s3index) != s1.charAt(s1index) && s3.charAt(s3index) == s2.charAt(s2index)) {
        		return helper(s1, s1index, s2, s2index - 1, s3, s3index - 1);
        	}
        	
    		if (helper(s1, s1index - 1, s2, s2index, s3, s3index - 1)) {
    			return true;
    		} else {
    			return helper(s1, s1index, s2, s2index - 1, s3, s3index - 1);
    		}
    	} else if (s1index < 0) {
    		return isSame(s3, s3index, s2, s2index);
    	} else if (s2index < 0) {
    		return isSame(s3, s3index, s1, s1index);
    	}
    	
    	System.out.println("impossible");
    	return false;
    }
    
    public static boolean isSame(String first, int start1, String second, int start2) {
    	if (start1 != start2) {
    		return false;
    	}
    	
    	for (int i = start1; i >= 0; i--) {
    		if (first.charAt(i) != second.charAt(i)) {
    			return false;
    		}
    	}
    	return true;
    }
	
    
    public static void main(String[] args) {
    	String s1 = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab";
    	String s2 = "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb";
//    	String s3 = "aadbbcbcac";
    	String s3 = "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaabababbababaaaaaabbababaaabbaabbbbaaaaabbbaaabbbabbbbaaabaababbaabababbbbababbaaabbbabbbab";
    	
    	System.out.println(isInterleave(s1, s2, s3));
    }

}
