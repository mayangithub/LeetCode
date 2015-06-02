/**
 * 
 */
package edu.pitt.datastructure;

/**
 * Trie #208 --- Accepted 596ms
 * @author yanma
 * @since 2015-06-02
 * @version 2015-06-02
 * 
 * 
 * Test cases:
 * Input:       insert("a"),search("a"),startsWith("a")
 * Output:      [false,true]
 * Expected:    [true,true]
 * remember to change hasWord status
 * 
 * Input:       insert("abc"),search("abc"),search("ab"),insert("ab"),search("ab"),insert("ab"),search("ab")
 * Output:      [true,false,false,false]
 * Expected:    [true,false,true,true]
 * remember to change prefix status if prefix becomes a word
 * 
 */
public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null || word.length() == 0) {
    		return;
    	}
    	TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
        	if (!node.children.containsKey(word.charAt(i))) {
        		TrieNode childNode = new TrieNode();
        		childNode.letter = word.charAt(i);
        		if (i == word.length() - 1) {
            		childNode.hasWord = true; // change childNode, not node
            	}
				node.children.put(word.charAt(i), childNode);
			}
        	node = node.children.get(word.charAt(i));
        	node.hasWord = (i == word.length() - 1 && !node.hasWord)? true: node.hasWord; // caution
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
        	return true;
        }
        
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				return false;
			} 
			node = node.children.get(word.charAt(i));
			if (i == word.length() - 1) {
				return node.hasWord;
			}
		}
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
        	return true;
        }
        
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
			if (!node.children.containsKey(prefix.charAt(i))) {
				return false;
			}
			node = node.children.get(prefix.charAt(i));
		}
        
        return true;
    }
    
 // Your Trie object will be instantiated and called as such:
 // Trie trie = new Trie();
 // trie.insert("somestring");
 // trie.search("key");
}
