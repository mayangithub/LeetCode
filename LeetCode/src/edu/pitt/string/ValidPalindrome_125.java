package edu.pitt.string;

/**
 * Valid Palindrome #125 --- accepted 248ms
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome. 
 * 
 * @author yanma
 * @since 2015-02-21
 * @version 2015-02-21
 *
 */
public class ValidPalindrome_125 {
	
	public static boolean isPalindrome(String s) {
        /**
         * 思路：
         * 1. pointer i from 0 , pointer j from length()-1, end when i = j (length % 2 = 1) or i + 1 = j (length % 2 = 0)
         * 2. only if points to alpha or number, compare i, j
         * 3. if i value = j value, i++, j--
         * 4. if not equal, return false directly
         * 
         * ******
         * 1. "" return true
         */
		if (s == null) {
			return false;
		}
		
		int i = 0; 
		int j = s.length() - 1;
		
		
		while (i <=j ) {
			if (!java.lang.Character.isLetter(s.charAt(i)) && !java.lang.Character.isDigit(s.charAt(i))) {
				i++;
			} else if (!java.lang.Character.isLetter(s.charAt(j)) && !java.lang.Character.isDigit(s.charAt(j))) {
				j--;
			} else {
				if (java.lang.Character.toLowerCase(s.charAt(i)) == java.lang.Character.toLowerCase(s.charAt(j))) {
					i++;
					j--;
				} else {
					return false;
				}
			}
			
		}
		
		return true;
		
		
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("A man, a plan, a canal: Panama---> " + isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("race a car---> " + isPalindrome("race a car"));
		System.out.println("---> " + isPalindrome(""));
	}

}
