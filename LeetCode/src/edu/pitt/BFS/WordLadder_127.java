/**
 * 
 */
package edu.pitt.BFS;

import java.util.Set;

/**
 * Word Ladder #127 --- Accepted 876ms/524ms
 *  Given two words (beginWord and endWord), and a dictionary, 
 *  find the length of shortest transformation sequence from beginWord to endWord, such that:
 *    Only one letter can be changed at a time
 *    Each intermediate word must exist in the dictionary
 * For example,
 *  Given:
 *   start = "hit"
 *   end = "cog"
 *   dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 * @author yanma
 * @since 2015-05-21
 * @version 2015-05-21
 */
public class WordLadder_127 {

	//BFS: using queue 
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0) {
        	return 0;
        } else if (beginWord.equals(endWord)) {
        	return 1;
        }
        
        java.util.Queue<String> queue = new java.util.LinkedList<String>();
        queue.add(beginWord);
        wordDict.remove(beginWord);
        int length = 1;
        
        while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String headString = queue.poll();
				for (int pos = 0; pos < headString.length(); pos++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (headString.charAt(pos) != c) {
							String replaceString = replace(headString, pos, c);
							if (replaceString.equals(endWord)) {
								return length + 1;
							}
							if (wordDict.contains(replaceString)) {
								queue.add(replaceString);
								wordDict.remove(replaceString);
							}
						}
					}
				}
			}
			length++;
		}
                
        return 0;
    }
    
    //use roCharArray() 524ms
    //use String concatenation 876ms
    public static String replace(String pre, int pos, char c) {
//    	String newString = pre.substring(0, pos) + c + pre.substring(pos + 1, pre.length());
//    	return newString;
    	char[] array = pre.toCharArray();
    	array[pos] = c;
    	return new String(array);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "nape";
		String end = "mild";
		
		Set<String> wordDict = new java.util.HashSet<String>();
		String[] setStrings = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		for (int i = 0; i < setStrings.length; i++) {
			wordDict.add(setStrings[i]);
		}
		
		System.out.println(ladderLength(start, end, wordDict));
		
	}

}
