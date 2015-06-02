/**
 * 
 */
package edu.pitt.datastructure;

/**
 * TrieNode  #208
 * @author yanma
 * @since 2015-06-02
 * @version 2015-06-02
 */
public class TrieNode {
	public boolean hasWord;
	public char letter;
	public java.util.HashMap<Character, TrieNode> children;
	// Initialize your data structure here.
    public TrieNode() {
        this.hasWord = false;
        this.letter = ' ';
        this.children = new java.util.HashMap<>(26);
    }
}
