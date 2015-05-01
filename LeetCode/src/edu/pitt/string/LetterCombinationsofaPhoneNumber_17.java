/**
 * 
 */
package edu.pitt.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number #17 --- Accepted 244ms
 * Given a digit string, return all possible letter combinations that the number could represent. 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want. 
 * @author yanma
 * @since 2015-04-30
 * @version 2015-04-30
 */
public class LetterCombinationsofaPhoneNumber_17 {
    public static List<String> letterCombinations(String digits) {
    	/**
    	 * Thoughts:
    	 * 1. from left to right, from one digit to all digits, for each one digit add another digit after it
    	 * 2. use queue to store newly added string
    	 * 3. until final string length equals to digits length
    	 * 4. use linkedlist as queue, use its peek() and remove() method
    	 */
        LinkedList<String> list = new LinkedList<String>();
        if (digits.length() == 0) {
        	return list;
        }
        
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
        	while(list.peek().length() == i) {
        		String first = list.remove();
        		for (int j = 0; j < keypad[Character.getNumericValue(digits.charAt(i))].length(); j++) {
        			list.add(first + keypad[Character.getNumericValue(digits.charAt(i))].substring(j, j + 1));
        		}
        	}
        }
        
        return list;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "235";
		List<String> list = letterCombinations(digits);
		for (String string : list) {
			System.out.println(string);
		} 
		
	}

}
