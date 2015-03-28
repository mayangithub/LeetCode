/**
 * 
 */
package edu.pitt.array;

/**
 * Next Permutation #31 --- Accepted 240 ms
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author yanma
 * @since 2015-03-27
 * @version 2015-03-27
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] num) {
    	if (num == null || num.length <= 1) {
    		return;
    	}
    	
        int temp = 0;
        for (int j = num.length - 1; j > 0; j--) {
        	if (num[j] > num[j - 1]) {
        		//find the min digit which is bigger than num[j - 1] but the min of rest of array from j to length-1
        		int min = j;
        		for (int i = j; i < num.length; i++) {
        			if (num[i] > num[j - 1] && num[i] < num[min]) {
        				min = i;
        			}
        		}
        		temp = num[j - 1];
        		num[j - 1] = num[min];
        		num[min] = temp;
        		
        		//sort the rest of the array, from j to last digit
        		java.util.Arrays.sort(num, j, num.length);
        		
        		break;
        	}
        	
        	if (j == 1) {
        		java.util.Arrays.sort(num);
        	}
        }
        
    }
    
     
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
