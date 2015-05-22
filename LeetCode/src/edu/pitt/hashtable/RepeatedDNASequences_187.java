/**
 * 
 */
package edu.pitt.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repeated DNA Sequences #187 --- Accepted 524ms/484ms
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 *  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *  Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *  For example,
 *  Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *  Return:
 *  ["AAAAACCCCC", "CCCCCAAAAA"].
 * @author yanma
 * @since 2015-04-23
 * @version 2015-05-22
 */
public class RepeatedDNASequences_187 {
	
	/**
	 * Accepted 524ms
	 * @param s
	 * @return
	 */
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
     * Accepted 484ms
     * @param s
     * @return
     * using bit manipulation to transform String to integer
     * comparing integers would be faster than comparing Strings
     */
    public static List<String> findRepeatedDnaSequences1(String s) {
    	List<String> list = new ArrayList<String>();
        if (s == null || s.length() <= 10) {
        	return list;
        }
        
        java.util.Hashtable<Integer, Integer> hashtable = new java.util.Hashtable<>();
        
        for (int start = 0; start < s.length() - 9; start++) {
        	int number = 0;
        	for (int end = start; end < start + 10; end++) {
        		switch (s.charAt(end)) {
					case 'A':
						number |= 0;
						break;
					case 'C':
						number |= 1;
						break;
					case 'G':
						number |= 2;
						break;
					default: // 'T'
						number |= 3;
						break;
				} 
        		number = number << 2;
        	}
        	
        	if (!hashtable.containsKey(number)) {
        		hashtable.put(number, 1);
        	} else {
        		switch (hashtable.get(number)) {
				case 1:
					list.add(s.substring(start, start + 10));
        			hashtable.put(number, 2);
					break;
				default:
					break;
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
		List<String> list = findRepeatedDnaSequences1(s);
		for (String string : list) {
			System.out.println(string);
		}
		
		
		
	}

}
