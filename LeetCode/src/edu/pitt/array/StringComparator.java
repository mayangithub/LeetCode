/**
 * 
 */
package edu.pitt.array;

import java.util.Comparator;

/**
 * For LargestNumber_179 question 
 * @author yanma
 * @version 2015-05-01
 */
public class StringComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		String s1s2 = s1 + s2;
		String s2s1 = s2 + s1;
		if (s1s2.compareTo(s2s1) < 0) {
			return -1; // s1 put before s2, s1 < s2
		} 
		return 1;
	}
}
