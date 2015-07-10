/**
 * 
 */
package edu.pitt.bitmanipulation;

/**
 * Power of Two #231 --- Accepted 264ms
 * Given an integer, write a function to determine if it is a power of two.
 * @author yanma
 * @since 2015-07-09
 * @version 2015-07-09
 */
public class PowerofTwo_231 {
	
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        String binary = Integer.toBinaryString(n);
        int length = binary.length();
        for (int i = length - 1; i > 0; i--) {
            if (binary.charAt(i) != '0') {
                return false;
            }
        }
        
        return true;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 = 0;
		int a2 = 1;
		int a3 = -1;
		int a4 = 64;
		int a5 = -64;
		int a6 = 63;
		int a7 = -12255;
		int a8 = 2147483647;
		int a9 = -2147483648;
		
		System.out.println("a1: " + a1 + ", binary: " + Integer.toBinaryString(a1));
		System.out.println("a2: " + a2 + ", binary: " + Integer.toBinaryString(a2));
		System.out.println("a3: " + a3 + ", binary: " + Integer.toBinaryString(a3) + ", length: " + Integer.toBinaryString(a3).length());
		System.out.println("a4: " + a4 + ", binary: " + Integer.toBinaryString(a4));
		System.out.println("a5: " + a5 + ", binary: " + Integer.toBinaryString(a5));
		System.out.println("a6: " + a6 + ", binary: " + Integer.toBinaryString(a6));
		System.out.println("a7: " + a7 + ", binary: " + Integer.toBinaryString(a7));
		System.out.println("a8: " + a8 + ", binary: " + Integer.toBinaryString(a8));
		System.out.println("a9: " + a9 + ", binary: " + Integer.toBinaryString(a9));
		
	}

}
