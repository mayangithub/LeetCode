/**
 * 
 */
package edu.pitt.backtracking;

/**
 * Palindrome Partitioning II #132 --- Accepted 293ms
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 * @author yanma
 * @since 2015-06-18
 * @version 2015-06-18
 */
public class PalindromePartitioningII_132 {
	
	/**
	 * Accepted 293ms
	 * @param s
	 * @return
	 */
    public static int minCut(String s) {
        if (s == null || s.length() < 2) {
        	return 0;
        }
        
        int[] cut = new int[s.length() + 1]; // min cut for first k chars
        for (int i = 0; i <= s.length(); i++) {
			cut[i] = i - 1;
		}
        
        for (int i = 0; i < s.length(); i++) {
        	//odd length palindrome
			for (int j = 0; j <= i && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1); 
			}
			//even length palindrome
			for (int j = 1; i - j + 1 >= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j) ; j++) {
				cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
			}
		}
        
        return cut[s.length()];
    }
	
	
	
	/**
	 * TLE
	 * @param s
	 * @return
	 */
    public static int minCut1(String s) {
        if (s == null || s.length() < 2 || isPalindrome(s)) {
        	return 0;
        }
        
        return helper(s, 0, s.length() - 1);
        
    }
    
    
    public static int helper(String s, int cut, int min) {
    	if (s.length() < 2 || isPalindrome(s)) {
    		min = Math.min(min, cut);
    		return min;
    	}
    	
    	for (int i = 1; i < s.length(); i++) {
    		String substring = s.substring(0, i);
    		if (isPalindrome(substring)) {
    			min = helper(s.substring(i), cut + 1, min);
    		}
    	}
    	return min;
    }
    
    
    
    public static boolean isPalindrome(String s) {
    	int start = 0;
    	int end = s.length() - 1;
    	while (start <= end) {
    		char left = s.charAt(start);
    		char right = s.charAt(end);
			if (left == right) {
				start++;
				end--;
			} else {
				return false;
			}
		}
    	return true;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		System.out.println(minCut(s));
		
	}

}
