/**
 * 
 */
package edu.pitt.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Word Ladder II #126 --- Accepted 884ms
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 * @author yanma
 * @since 2015-06-07
 * @version 2015-06-07
 */
public class WordLadderII_126 {

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> list = new ArrayList<List<String>>();
        if (start == null || end == null || start.length() != end.length()) {
        	return list;
        } else if (start.equals(end)) {
        	List<String> inner = new ArrayList<>();
        	inner.add(start);
        	inner.add(end);
        	list.add(inner);
        	return list;
        }
        dict.add(start); dict.add(end);
        
        java.util.HashMap<String, List<String>> transformation = new HashMap<>();
        Map<String, Integer> layer = new java.util.HashMap<>();
        transform(transformation, start, dict, layer);
        List<String> innerList = new ArrayList<String>();
        innerList.add(start);
        
        build(list, innerList, transformation, start, end, dict, layer);
        
        return list;
    }
    
    public static void build(List<List<String>> list, List<String> inner, java.util.HashMap<String, List<String>> transformation, 
 		   String start, String end, Set<String> dict, Map<String, Integer> layer) {
    	if (start.equals(end)) {
    		list.add(new ArrayList<>(inner));
    		return;
    	}
    	
    	for (String string : transformation.get(start)) {
			if (layer.get(string) == layer.get(start) + 1) {
				inner.add(string);
				build(list, inner, transformation, string, end, dict, layer);
				inner.remove(inner.size() - 1);
			}
		}
    }
    
    
    public static void transform(java.util.HashMap<String, List<String>> transformation, 
    		   String start, Set<String> dict, Map<String, Integer> layer) {
    	java.util.Queue<String> queue = new LinkedList<>();
    	queue.add(start);
    	layer.put(start, 0);
    	
    	while (!queue.isEmpty()) {
			String string = queue.poll();
			transformation.put(string, new ArrayList<String>());
			for (int i = 0; i < string.length(); i++) {
				for (char c = 'a'; c < 'z'; c++) {
					if (string.charAt(i) != c) {
						String newString = replace(string, i, c);
						if (dict.contains(newString)) {
							transformation.get(string).add(newString);
							if (!layer.containsKey(newString)) {
								layer.put(newString, layer.get(string) + 1);
								queue.offer(newString);
							}
						}
					}
				}
			}
		}
    	
    }
   

    public static String replace(String start, int pos, char c) {
    	char[] chararray = start.toCharArray();
    	chararray[pos] = c;
    	return new String(chararray);
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
//		String start = "a";
//		String end = "c";
//		Set<String> dict = new HashSet<>();
//		dict.add("a");
//		dict.add("b");
//		dict.add("c");
		
//		String start = "hot";
//		String end = "dog";
//		Set<String> dict = new HashSet<>();
//		dict.add("hot");
//		dict.add("dog");
//		dict.add("dot");
//		
//		String start = "red";
//		String end = "tax";
//		Set<String> dict = new HashSet<>();
//		dict.add("ted");
//		dict.add("tex");
//		dict.add("red");
//		dict.add("tax");
//		dict.add("tad");
//		dict.add("den");
//		dict.add("rex");
//		dict.add("pee");
		
//		String start = "qa";
//		String end = "sq";
//		Set<String> dict = new HashSet<>();
//		String[] array = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//		for (String string : array) {
//			dict.add(string);
//		}		
		
		
		List<List<String>> list = findLadders(start, end, dict);
		System.out.println("[");
		for (List<String> inner : list) {
			System.out.print("[");
			for (String string : inner) {
				System.out.print("\"" + string + "\", ");
			}
			System.out.println("],");
		}
		System.out.println("]");
		
	}

}
