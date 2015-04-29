/**
 * 
 */
package edu.pitt.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repeated DNA Sequences #187
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 *  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *  Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *  For example,
 *  Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *  Return:
 *  ["AAAAACCCCC", "CCCCCAAAAA"].
 * @author yanma
 * @since 2015-04-23
 * @version 2015-04-23
 */
public class RepeatedDNASequences_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<String>();
        if (s == null || s.length() <= 10) {
        	return list;
        }
    	
        java.util.Hashtable<String, Integer> hashtable = new java.util.Hashtable<String, Integer>();
        
        for (int i = 0; i < s.length() - 9; i++) {
        	String subString = s.substring(i, i + 10);
        	if (!hashtable.containsKey(subString)) {
        		hashtable.put(subString, Integer.valueOf(1));
        	} else {
        		if (!list.contains(subString)) {
        			if (hashtable.get(subString).intValue() == 1) {
	        			list.add(subString);
	        		}
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
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> list = findRepeatedDnaSequences(s);
		for (String string : list) {
			System.out.println(string);
		}
		
		
		
	}

}
