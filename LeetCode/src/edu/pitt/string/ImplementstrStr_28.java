/**
 * 
 */
package edu.pitt.string;

/**
 * Implement strStr() #28 --- accepted 301ms
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
 * @author yanma
 *
 */
public class ImplementstrStr_28 {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
        	return -1;
        }
        
        /**
         * test case:
         * 1. "" , "" 
         * 2. "a", ""
         */
        
        if (needle.equals(haystack) || needle.length() == 0) {
        	return 0;
        }
        
        /**
         * 思路:
         * 1. 一个指针i指向needle， 一个指针j指向haystack，如果发现needle的一个字符与j一样，移动i,j指针
         * i的范围[0,needle.length()-1], j的范围[0, haystack.length()-1]
         * 2. 如果ij一样，继续移动，如果不一样，i回到needle第一位，j回到haystack的j-i+1位，继续比较；
         * 3. 如果i到needle的最后一位，字符都还一样，则返回j-needle.length()+1
         * 4. 如果j==haystack.length()-needle.length()+2时，i==0，return-1；
         * 5. 没找到，返回-1
         */
        int j = 0;
        int i = 0;
        char h;
        char n;
        while (j <= haystack.length() - 1) {
        	h = haystack.charAt(j);
        	n = needle.charAt(i);
        	
        	if (h == n) {
        		i++;
        		j++;
        	} else {
        		j = j - i + 1;
        		i = 0;
        	}
        	
        	if (i == needle.length()) {
        		return j - needle.length();
        	}
        	
        	if (j >= haystack.length() - needle.length() + 2 && i == 0) {
        		return -1;
        	}
        	
        	
        }
        
        
        
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String needleString = "";
		String haystackString = "";
		
		System.out.println(strStr(haystackString, needleString));
		
		
		
		
	}

}
