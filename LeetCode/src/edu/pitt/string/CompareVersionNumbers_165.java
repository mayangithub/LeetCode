package edu.pitt.string;

/**
 * Compare Version Numbers #165 --- accepted 237ms
 * 
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author yanma
 * @since 2015-02-16
 * @version 2015-02-17
 */
public class CompareVersionNumbers_165 {
	
	public static int compareVersion(String version1, String version2) {
        
		/**
		 * 思路： 
		 * 1. when either of two strings is null or empty, return 0; if contains letters, return 0
		 * 2. set two strings temp1 and temp2, add each char to the string read until each '.', compare the string integers
		 * 	if temp1 > temp2, return 1, < return -1, 
		 *  if temp1 = temp2, clear temp1 and temp2, read the following chars and add to temp1, temp2
		 * 3. if one version is out of chars and another one still has chars, the latter version is larger
		 * 
		 */
        if (version1 == null || version2 == null || version1.isEmpty() || version2.isEmpty()) {
        	return 0;
        }
        
        for (int j = 0; j < version1.length(); j++) {
			if (java.lang.Character.isLetter(version1.charAt(j))) {
				return 0;
			}
		}
        for (int j = 0; j < version2.length(); j++) {
			if (java.lang.Character.isLetter(version2.charAt(j))) {
				return 0;
			}
		}
        
        String temp1 = "";
        String temp2 = "";
        
        version1 += ".0";
        version2 += ".0";

        int i = 0;
        int j = 0;
        int end1 = version1.indexOf('.', i);
        
        int end2 = version2.indexOf('.', j);
        
        
        do {
        	if (end1 < 0) {
        		temp1 = version1.substring(i);
        	} else {
        		temp1 = version1.substring(i, end1);
        		i = end1+1;
        		end1 = version1.indexOf('.', i);
        	}
        	if (end2 < 0) {
        		temp2 = version2.substring(j);
        	} else {
        		temp2 = version2.substring(j, end2);
        		j = end2+1;
        		end2 = version2.indexOf('.', j);
        	}
        	
        	if (Integer.valueOf(temp1) > Integer.valueOf(temp2)) {
        		return 1;
        	} else if (Integer.valueOf(temp1) < Integer.valueOf(temp2)) {
        		return -1;
        	} 
        	
         } while (end1 > 0 || end2 > 0);
        
        temp1 = version1.substring(i);
        temp2 = version2.substring(j);
        
        if (Integer.valueOf(temp1) > Integer.valueOf(temp2)) {
    		return 1;
    	} else if (Integer.valueOf(temp1) < Integer.valueOf(temp2)) {
    		return -1;
    	} else {
        	return 0;
        }
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String v1 = "1.1";
		String v2 = "1.1.0";
		String v3 = "1.2";
		String v4 = "13.37";
		
		System.out.println(v1 + " VS " + v2 + ": " + compareVersion(v1, v2));
		System.out.println(v2 + " VS " + v3 + ": " + compareVersion(v2, v3));
		System.out.println(v3 + " VS " + v4 + ": " + compareVersion(v3, v4));
		System.out.println(v1 + " VS " + v3 + ": " + compareVersion(v1, v3));
		
		
		System.out.println(v3 + " VS " + v2 + ": " + compareVersion(v3, v2));
		System.out.println(v4 + " VS " + v3 + ": " + compareVersion(v4, v3));
		System.out.println(v2 + " VS " + v4 + ": " + compareVersion(v2, v4));
		System.out.println(v3 + " VS " + v3 + ": " + compareVersion(v3, v3));
		
	}

}
