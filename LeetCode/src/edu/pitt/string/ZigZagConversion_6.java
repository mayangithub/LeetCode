package edu.pitt.string;

/**
 * ZigZag Conversion #6 -- accepted 451ms
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 * 
 * @author yanma
 * @since 2015-02-15
 * @version 2015-02-15
 */
public class ZigZagConversion_6 {
	public static String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		
		int length = s.length();
		
		String[] stringArray = new String[length]; 
		for (int i = 0; i < length; i++) {
			stringArray[i] = s.substring(i, i+1);
		}
				
		String[] linesStrings = new String[nRows];
		java.util.Arrays.fill(linesStrings, "");
		int k = 2 * nRows - 2;
		
		for (int n = 0; n < length / nRows + 1; n++) {
			for (int t = 0; t < nRows; t++) {
				if ((n*k + t) < length) {
					linesStrings[t] += stringArray[n*k + t]; 
					if (t != 0 && t != nRows - 1 && (n*k + k - t) < length) {
						linesStrings[t] += stringArray[n*k + k - t]; 
					}
				}	
			}
		}
		
        String result = "";
        for (int i = 0; i < nRows; i++) {
        	result += linesStrings[i];  
        }
        
        return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "PAYPALISHIRING";
		String result = convert(s,3);
		
		System.out.println(result);
		
	}

}
