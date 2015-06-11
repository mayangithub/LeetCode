/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Edit Distance #72 --- Accepted 328ms
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author yanma
 * @since 2015-06-11
 * @version 2015-06-11
 */
public class EditDistance_72 {

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
        	return 0;
        } else if (word1.equals(word2)) {
        	return 0;
        } else if (word1.length() == 0) {
        	return word2.length();
        } else if (word2.length() == 0) {
			return word1.length();
		}
        int[][] board = new int[word2.length() + 1][word1.length() +  1];
        board[0][0] = 0;
        for (int i = 1; i < board.length; i++) {
			board[i][0] = i;
		}
        for (int i = 0; i < board[0].length; i++) {
			board[0][i] = i;
		}
        for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				int min = Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1])); //min of: replace, add, delete
				board[i][j] = (word2.charAt(i - 1) == word1.charAt(j - 1)) ? board[i - 1][j - 1]: min + 1; //if same, same with length - 1
			}
		}
        
        return board[word2.length()][word1.length()];
        
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "ababd";
		word1 = "zoologicoarchaeologist";
				
		String word2 = "ccabab";
		word2 = "zoogeologist";
		System.out.println(minDistance(word1, word2));
		
	}

}
