/**
 * 
 */
package edu.pitt.string;

/**
 * Reverse Words in a String #151 --- Accepted 335ms
 * Given an input string, reverse the string word by word.
 * For example, 
 * Given s = "the sky is blue",
 * return "blue is sky the". 
 * @author yanma
 * @since 2015-04-30
 * @version 2015-04-30
 */
public class ReverseWordsinaString_151 {

	
    public static String reverseWords(String s) {
        if (s == null || !s.contains(" ")) {
        	return s;
        }
        
        String result = "";
        s = s.trim();
        String[] splitArray = s.split("\\s+");
        
        for (int i = splitArray.length - 1; i >= 0; i--) {
        	if (splitArray[i] == " ") {
        		continue;
        	} else {
        		if (i == 0) {
        			result = result.concat(splitArray[i]);
        		} else {
        			result = result.concat(splitArray[i] + " ");
				}
			}
        }
        
       return result; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   a   b ";
		System.out.println(reverseWords(s));
	}

}
