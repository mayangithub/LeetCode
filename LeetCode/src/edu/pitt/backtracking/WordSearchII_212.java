/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.pitt.datastructure.Trie;

/**
 * Word Search II #212 --- Accepted 732ms
 *  Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
	  ['o','a','a','n'],
	  ['e','t','a','e'],
	  ['i','h','k','r'],
	  ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z. 
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. 
 * What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? 
 * If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 * @author yanma
 * @since 2015-06-10
 * @version 2015-06-10
 */
public class WordSearchII_212 {	
	
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
        	return list;
        }
        
        Trie tree = new Trie();
        for (String string : words) {
			tree.insert(string);
		}
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				StringBuffer bf = new StringBuffer();
				bf.append(board[i][j]);
				char c = board[i][j];
				board[i][j] = '0';
				findword(board, tree, bf, i, j, list);
				board[i][j] = c;
			}
		}
        
        return list;
    }
    
    public static void findword(char[][] board, Trie tree, StringBuffer word, int row, int col, List<String> list) {
    	if (!tree.startsWith(word.toString())) {
			return;
		}
    	
    	if (!list.contains(word.toString()) && tree.search(word.toString())) {
			list.add(word.toString()); //not return, will have prefix tree
		}
    	
    	char c = ' ';
    	if (row > 0 && board[row - 1][col] != '0') {
			word.append(board[row - 1][col]);
			c = board[row - 1][col];
			board[row - 1][col] = '0';
			findword(board, tree, word, row - 1, col, list);
			word.deleteCharAt(word.length() - 1);
			board[row - 1][col] = c;
		}
    	if (row < board.length - 1 && board[row + 1][col] != '0') {
    		word.append(board[row + 1][col]);
    		c = board[row + 1][col];
    		board[row + 1][col] = '0';
			findword(board, tree, word, row + 1, col, list);
			word.deleteCharAt(word.length() - 1);
			board[row + 1][col] = c;
    	}
    	if (col > 0 && board[row][col - 1] != '0') {
    		word.append(board[row][col - 1]);
    		c = board[row][col - 1];
    		board[row][col - 1] = '0';
			findword(board, tree, word, row, col - 1, list);
			word.deleteCharAt(word.length() - 1);
			board[row][col - 1] = c;
    	}
    	if (col < board[0].length - 1 && board[row][col + 1] != '0') {
    		word.append(board[row][col + 1]);
    		c = board[row][col + 1];
    		board[row][col + 1] = '0';
			findword(board, tree, word, row, col + 1, list);
			word.deleteCharAt(word.length() - 1);
			board[row][col + 1] = c;
    	}
    }
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		
		List<String> list = findWords(board, words);
		for (String string : list) {
			System.out.println(string);
		}
		
		String[] list1 = {"stow","stob","seer","seen","embow","neem","wadna","wave","wene","reem","reest","renew","rine","rive","riva","inerm","irene","vine","vire","avener","avine","bowl","sise","besa","bend","bena","daven","wots","myst","send","teil","sand","sane","sang","anda","anes","anesis","nane"};
		String[] list2 = {"anda","anes","anesis","avener","avine","bena","bend","benda","besa","besan","bowl","daven","embow","inerm","irene","myst","nane","nanes","neem","reem","reest","renew","rine","riva","rive","riven","sand","sane","sang","seen","seer","send","sise","stob","stow","teil","vine","viner","vire","wadna","wave","wene","wots"};
		System.out.println(list1.length + " " + list2.length);
		Arrays.sort(list1);
		for (String string : list1) {
			System.out.print(string + " ");
		}
		System.out.println();
		Arrays.sort(list2);
		for (String string : list2) {
			System.out.print(string + " ");
		}
		
	}

}
