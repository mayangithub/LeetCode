/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code #89 --- Accepted 256ms
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author yanma
 * @since 2015-05-24
 * @version 2015-05-24
 */
public class GrayCode_89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n <= 0) {
        	list.add(n);
        	return list;
        }
        
    	if (n == 1) {
			list.add(0);
			list.add(1);
			return list;
		} else {
			list.add(0);
			list.add(1);
			for (int digits = 2; digits <= n; digits++) {
				int base = (int) Math.pow(2, digits - 1);
				for (int pos = list.size() - 1; pos >= 0; pos--) {
					list.add(list.get(pos) + base);
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
		int n1 = 4;
		List<Integer> list1 = grayCode(n1);
		System.out.print("[");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(Integer.toBinaryString(list1.get(i)));
			if (i != list1.size() - 1) {
				System.out.print(", ");
			} 
		}
		System.out.println("]");
	}

}
