/**
 * 
 */
package edu.pitt.math;

/**
 * *******Divide Two Integers #29 --- Accepted 279ms
 *  Divide two integers without using multiplication, division and mod operator.
 *  If it is overflow, return MAX_INT. 
 * @author yanma
 *
 */
public class DivideTwoIntegers_29 {
    public static int divide(int dividend, int divisor) {
        if (divisor == 1) // Trivial case 1
            return dividend;

        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);

        if (dividend > divisor) // Trivial case 2
            return 0;

        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) // Overflow case
            return Integer.MAX_VALUE;

        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }

        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }

        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divide(10, 5);
		
	}

}
