/**
 * 
 */
package edu.pitt.datastructure;

/**
 * Add and Search Word - Data structure design #211 --- Accepted 660ms
 *  Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
 * A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z. 
 * @author yanma
 * @since 2015-06-03
 * @version 2015-06-03
 */
public class AddandSearchWordDatastructuredesign_211 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary dictionary  = new WordDictionary();
		dictionary.addWord("bad");
		dictionary.addWord("dad");
		dictionary.addWord("mad");
		dictionary.addWord("dade");
//		System.out.println("pad: " + dictionary.search("pad"));
//		System.out.println("bad: " + dictionary.search("bad"));
//		System.out.println(".ad: " + dictionary.search(".ad"));
//		System.out.println("b..: " + dictionary.search("b.."));
//		System.out.println("..:" + dictionary.search(".."));
//		System.out.println("b:" + dictionary.search("b"));
//		System.out.println("a:" + dictionary.search("a"));
//		System.out.println(".a.:" + dictionary.search(".a."));
		System.out.println("dads:" + dictionary.search("dads"));
		System.out.println("...:" + dictionary.search("..."));
	}
}
