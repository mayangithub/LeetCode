/**
 * 
 */
package edu.pitt.string;

/**
 * Valid Number #65 --- Accepted 320ms
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one. 
 * @author yanma
 * @since 2015-06-07
 * @version 2015-06-07
 */
public class ValidNumber_65 {
	
	
    public static boolean isNumber(String s) {
        /**
         * 1. no trailing and leading white space   Y
         * 2. can have only one e and only one '.'  Y
         * 3. when no '.', no 0 can before digit    ------- can be true
         * 4. no letter other than e                Y
         * 5. can have -, but - should be the first upfront or first after e   Y
         * 6. after e, should have no '.'           Y
         * 7. no white space in between             Y
         * 8. " " empty string
         * 9. only "e", before and after should has digits
         * 10. only '.' false, before '.' can be nothing
         * 11. '.e' no dot can directly before e
         */
    	s = trimspace(s);
    	if (s == null || s.length() == 0) {
    		return false;
    	} else if (s.length() == 1 && (s.equals(".") || s.equals("-") || s.equals("+") || s.equals("e"))) {
			return false;
		}
    	
    	boolean dot = false;
    	boolean e = false;
    	boolean neg = false;
    	boolean pos = false;
    	int index = 0;
    	while (index < s.length()) {
			if (s.charAt(index) == ' ') {
				return false;
			} else if (s.charAt(index) == '.') {
				if (dot || e || (index == 0 && s.length() > 1 && !isNum(s.charAt(1)))) {
					return false;
				} else if (index == s.length() - 1 && !isNum(s.charAt(index - 1))) {
				    return false;
				} else if (neg && index < s.length() - 1 && (s.charAt(index + 1) == '-') ) {
				    return false;
				} else if (!dot && s.length() != 1 && !e ) {
					dot = true;
				} 
			} else if (s.charAt(index) == 'e') {
				if (!e && index != 0 && index != s.length() - 1) {
					e = true;
					pos = false;
				} else {
					return false;
				}
			} else if (s.charAt(index) == '-') {
				if ((index > 0 && s.charAt(index - 1) != 'e') || index == s.length() - 1 || (index < s.length() - 1 && s.charAt(index + 1) == 'e')) {
					return false;
				}
				neg = index == 0? true: neg;
			} else if ((s.charAt(index) >= 'a' && s.charAt(index) < 'e') || s.charAt(index) > 'e' || (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')) {
				return false;
			} else if (s.charAt(index) == '+') {
				if (!pos && index == 0) {
					pos = true;
				} else if (!pos && index > 0 && s.charAt(index - 1) == 'e' && index < s.length() - 1) {
				    pos = true;
				} else {
					return false;
				}
			}
			index++;
		}
    	
    	return true;
    }
    
    public static boolean isNum(char c) {
    	if (c >= '0' && c <= '9') {
    		return true;
    	} else if (c == '+') {
    	    return true;
    	}
    	return false;
    }
    
    public static String trimspace(String s) {
    	int start = 0;
    	while (start < s.length() && s.charAt(start) == ' ') {
			start++;
		}
    	int end = s.length() - 1;
    	while (end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
    	
    	return (start > end) ? "": s.substring(start, end + 1);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s0 = " ";
		String s1 = "0";
		String s2 = " 0.1 ";
		String s3 = "abc";
		String s4 = "1 a";
		String s5 = "2e10";
		String s6 = "e";
		String s7 = "1e";
		String s8 = "e4";
		String s9 = "1e-2";
		String s10= ".";
		String s11= ".1";
		String s12= "1.";
		String s13= "123.";
		String s14= ".e1";
		String s15= "010";
		String s16= "1e.";
		String s17= "Re7";
		String s18= "+++";
		String s19= "6+1";
		String s20= " -.";
		String s21= "3.";
		
		
		System.out.println("s0: " + s0 + " " + isNumber(s0));
		System.out.println("s1: " + s1 + " " + isNumber(s1));
		System.out.println("s2: " + s2 + " " + isNumber(s2));
		System.out.println("s3: " + s3 + " " + isNumber(s3));
		System.out.println("s4: " + s4 + " " + isNumber(s4));
		System.out.println("s5: " + s5 + " " + isNumber(s5));
		System.out.println("s6: " + s6 + " " + isNumber(s6));
		System.out.println("s7: " + s7 + " " + isNumber(s7));
		System.out.println("s8: " + s8 + " " + isNumber(s8));
		System.out.println("s9: " + s9 + " " + isNumber(s9));
		System.out.println("s10: " + s10 + " " + isNumber(s10));
		System.out.println("s11: " + s11 + " " + isNumber(s11));
		System.out.println("s12: " + s12 + " " + isNumber(s12));
		System.out.println("s13: " + s13 + " " + isNumber(s13));
		System.out.println("s14: " + s14 + " " + isNumber(s14));
		System.out.println("s15: " + s15 + " " + isNumber(s15));
		System.out.println("s16: " + s16 + " " + isNumber(s16));
		System.out.println("s17: " + s17 + " " + isNumber(s17));
		System.out.println("s18: " + s18 + " " + isNumber(s18));
		System.out.println("s19: " + s19 + " " + isNumber(s19));
		System.out.println("s20: " + s20 + " " + isNumber(s20));
		System.out.println("s21: " + s21 + " " + isNumber(s21));
	}

}
