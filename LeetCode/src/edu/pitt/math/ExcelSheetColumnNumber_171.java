/**
 * 
 */
package edu.pitt.math;

/**
 * Excel Sheet Column Number #171 --- Accepted 238ms
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * @author yanma
 * @since 2015-03-17
 * @version 2015-03-17
 */
public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String s) {
        if (s.equals("")) {
        	return 0;
        }
        
        String positionString = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int length = s.length();
        if (length > 1) {
        	int last = positionString.indexOf(s.charAt(length-1));
        	int front = 0;
        	s = s.substring(0, length-1);
	        front += titleToNumber(s) * 26;
	        return front + last;
        } else {
        	return positionString.indexOf(s);
        }
        
        
        
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AAZ"));
	}

}
