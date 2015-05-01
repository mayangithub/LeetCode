/**
 * 
 */
package edu.pitt.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses #93 --- Accepted 277ms
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 * @author yanma
 * @since 2015-04-30
 * @version 2015-04-30
 */
public class RestoreIPAddresses_93 {
	
	/**
	 * Accepted 302ms
	 * @param s
	 * @return
	 */
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        
        if (s.length() < 4) {
        	return list;
        }
        
        for (int i = 1; i < 4 && i < s.length() - 2; i++) {
        	for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
        		for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
        			String piece1 = s.substring(0, i);
        			String piece2 = s.substring(i, j);
        			String piece3 = s.substring(j, k);
        			String piece4 = s.substring(k, s.length());
        			if (isValid(piece1) && isValid(piece2) && isValid(piece3) && isValid(piece4)) {
        				list.add(piece1 + "." + piece2 + "." + piece3 + "." + piece4);
        			}
        		}
        	}
        }
        
        return list;
    }
    
    /**
     * Accepted 277ms
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses1(String s) {
        List<String> list = new ArrayList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
        	return list;
        }
        
        for (int i = s.length() - 1; i > 2; i--) {
        	for (int j = i - 1; j > 1; j--) {
        		for (int k = j - 1; k > 0; k--) {
        			String piece1 = s.substring(0, k);
        			String piece2 = s.substring(k, j);
        			String piece3 = s.substring(j, i);
        			String piece4 = s.substring(i, s.length());
        			if (isValid(piece1) && isValid(piece2) && isValid(piece3) && isValid(piece4)) {
        				list.add(piece1 + "." + piece2 + "." + piece3 + "." + piece4);
        			}
        		}
        	}
        }
        
        return list;
    }
    
    public static boolean isValid(String piece) {
    	if (piece.length() <= 0 || piece.length() > 3 || (piece.charAt(0) == '0' && piece.length() > 1) 
    			|| Integer.valueOf(piece).intValue() > 255) {
    		return false;
    	}
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "11112";
		List<String> list = restoreIpAddresses(s);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
