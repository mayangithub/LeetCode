/**
 * 
 */
package edu.pitt.math;

/**
 * Add Digits #258 --- Accepted
 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime? 
 * @author yanma
 * @version 2015-09-15
 * @week 7 0914-0920
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        
        int answer = num;
        while (answer >= 10) {
            num = answer;
            answer = 0;
            while (num > 0) {
                answer += num % 10;
                num /= 10;
            }
        }
        return answer;
    }
    
    /**
     * O(1) time
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        if (num < 10) {
            return num;
        }
        
        return num - 9 * ((num - 1) / 9);
    }

}
