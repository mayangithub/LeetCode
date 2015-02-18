/**
 * 
 */
package edu.pitt.string;

/**
 * Length of Last Word #58 --- accepted 198ms
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5. 
 * 
 * @author yanma
 * @since 2015-02-17
 * @version 2015-02-17
 */
public class LengthOfLastWord_58 {

	public static int lengthOfLastWord(String s) {
        /**
         * 思路： 
         * 1. if s.length = 0 or s = null, return 0
         * 2. delete the white spaces leading and trailing the string
         * 3. find the last index of " " in the string
         * 4. the last word length will be str.length - last index - 1
         */
		
		if (s == null || s.length() == 0) {	return 0; }
		
		s = s.trim();
		int lastindex = s.lastIndexOf(' ');
		return s.length() - lastindex - 1;
		
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Hello World";
		int length = lengthOfLastWord(string);
		System.out.println(string + ": " + length);
		
	}

}
