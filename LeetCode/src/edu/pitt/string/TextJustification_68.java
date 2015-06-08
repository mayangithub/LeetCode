/**
 * 
 */
package edu.pitt.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification #68 --- Accepted 280ms
 * Given an array of words and a length L, 
 * format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
    "This    is    an",
    "example  of text",
    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * Corner Cases:
    A line other than the last line might contain only one word. What should you do in this case?
    In this case, that line should be left-justified.
 * @author yanma
 * @since 2015-06-08
 * @version 2015-06-08
 */
public class TextJustification_68 {
	
	
	/**
	 * Thoughts:
	 * 1. int[] to store each word length or word.length()
	 * 2. from 0 to last, add word length together, n: # of words, len: total word length, 
	 *    start index, end index, n = end - start + 1
	 *    len + (n - 1) <= L, if add another word, len + (n - 1) > L, decide the n
	 *    spaces = L - len, if spaces % (n - 1) == 0, each spaces are spaces / (n - 1);
	 *    if spaces % (n - 1) != 0, first left slots have spaces / (n - 1) + 1 space, 
	 *    the right slots have spaces / (n - 1) space
	 * 3. when index point to last, len + (n - 1) <= L, iterately output word with one space in between.
	 * 
	 */

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        if (words == null || words.length == 0) {
        	return list;
        }
        
        int n = 0;
        int startindex = 0;
        int endindex = 0;
        int strlen = words[startindex].length();
        
        while (endindex < words.length - 1) {
        	n = endindex - startindex + 1; //include end index
			if (strlen + words[endindex + 1].length() + n > maxWidth) { // exclude endindex, add spaces and add to list
				buildLine(list, words, startindex, endindex, maxWidth, strlen);
				startindex = endindex + 1;
				endindex = startindex;
				strlen = words[startindex].length();
			} else if (strlen + words[endindex + 1].length() + n == maxWidth) {//include endindex, add spaces and add to list
				strlen += words[endindex + 1].length();
				buildLine(list, words, startindex, endindex + 1, maxWidth, strlen);
				startindex = endindex + 2;
				endindex = startindex;
				strlen = words[startindex].length();
			
			} else {//not enough word, endindex++;
					strlen += words[endindex + 1].length();
					endindex++;
			}
		}
        if (endindex == words.length - 1) {//last word included
			buildlast(list, words, startindex, maxWidth);
			return list;
		}
        
    	
    	return list;
    }
	
    
    public static void buildLine(List<String> list, String[] words, int start, int end, int maxWidth, int len) {//include end
    	if (start > end) {
    		return;
    	} else {
    		String line = addSpaces(words, start, end, maxWidth, len);
    		System.out.println(line);
    		list.add(line);
    	}    	
    }
    
    public static void buildlast(List<String> list, String[] words, int start, int maxWidth) {
    	StringBuffer bfBuffer = new StringBuffer();
    	for (int i = start; i < words.length; i++) {
    		bfBuffer.append(words[i]);
    		if (i < words.length - 1) bfBuffer.append(" ");
    		
		}
    	int left = maxWidth - bfBuffer.length();
    	for (int i = 1; i <= left; i++) {
			bfBuffer.append(" ");
		}
    	System.out.println(bfBuffer.toString());
    	list.add(bfBuffer.toString());
    }
    
    public static String addSpaces(String[] words, int start, int end, int maxWidth, int len) {
    	if (start == end) {
    		StringBuffer bfBuffer = new StringBuffer();
    		bfBuffer.append(words[start]);
    		int left = maxWidth - bfBuffer.length();
        	for (int i = 1; i <= left; i++) {
    			bfBuffer.append(" ");
    		}
    		return bfBuffer.toString();
    	}
    	int n = end - start; //num of spaces
    	int spaces = maxWidth - len;
    	int mod = spaces % n;
    	int numsp = spaces / n;
    	StringBuffer stringBuffer = new StringBuffer();
    	StringBuffer sp = new StringBuffer();
    	for (int i = 1; i <= numsp; i++) {
			sp.append(" ");
		}
    	if (mod == 0) {
    		for (int i = start; i <= end; i++) {
				stringBuffer.append(words[i]);
				if (i < end) {
					stringBuffer.append(sp);
				}
			}
    	} else {
    		int count = 0;
    		int i = start;
    		while (i <= end) {
    			stringBuffer.append(words[i]);
    			if (i < end) {
    				stringBuffer.append(sp);
    			}
    			if (count < mod) {
    				stringBuffer.append(" ");
    				count++;
    			}
    			i++;
			}
    	}
    	
    	return stringBuffer.toString();
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		int maxwidth = 16;
//		String[] words = {"a","b","c","d","e"};
		int maxwidth = 3;
//		String[] words = {"Listen","to","many,","speak","to","a","few."};
		String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		maxwidth = 30;
		
		fullJustify(words, maxwidth);
		
	}

}
