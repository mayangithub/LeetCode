/**
 * 
 */
package edu.pitt.datastructure;

/**
 * WordDictionary #211 --- Accepted 660ms
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("word");
 * wordDictionary.search("pattern");
 * @author yanma
 * @since 2015-06-03
 * @version 2015-06-03
 */
public class WordDictionary {

	public class TrieNode {
		public boolean hasWord;
		public char letter;
		public java.util.HashMap<Character, TrieNode> children;
	    public TrieNode() {
	        this.hasWord = false;
	        this.letter = ' ';
	        this.children = new java.util.HashMap<>(26);
	    }
	}
	private TrieNode rootNode;

	public WordDictionary() {
		this.rootNode = new TrieNode();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
        	return;
        }
        TrieNode node = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				TrieNode childNode = new TrieNode();
				childNode.letter = word.charAt(i);
				childNode.hasWord = (i == word.length() - 1) ? true: childNode.hasWord;
				node.children.put(word.charAt(i), childNode);
			}
			node = node.children.get(word.charAt(i));
		}
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if (word == null || word.length() == 0) {
    		return true;
    	}
        TrieNode node = this.rootNode;
        return searchHelper(word, 0, node);
    }
    
    public boolean searchHelper(String word, int index, TrieNode parentNode) {
    	if (index >= word.length()) {
    		return false;
    	}
    	
    	for (int i = index; i < word.length(); i++) {
			if (word.charAt(i) == '.') {
				return isThereAWord(word, i, parentNode);
			} else {
				if (!parentNode.children.containsKey(word.charAt(i))) {
					return false;
				} else {
					parentNode = parentNode.children.get(word.charAt(i));
					if (i == word.length() - 1) {
						return parentNode.hasWord;
					}
				}
			}
		}
    	return false;
    }
    
    
	public boolean isThereAWord(String word, int index, TrieNode parentNode) {
		if (index >= word.length()) {
			return false;
		} else if (parentNode.children == null || parentNode.children.isEmpty()) {
			return false;
		} 
		char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
				        'r','s','t','u','v','w','x','y','z'};
		for (char c : chars) {
			if (parentNode.children.containsKey(c)) {
				TrieNode node = parentNode.children.get(c);
				if (index == word.length() - 1) {
					if (node.hasWord) { //is find the word, return true; if not, continue to next available char.
						return node.hasWord;
					}
				}
				if (index < word.length() - 1 && searchHelper(word, index + 1, node)) { // if find word, return true; it not, continue to next available char
					return true;
				}
			}
		}
		return false;
	}

}
