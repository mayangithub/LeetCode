package edu.pitt.array;

/**
 * #27 Remove Element -- accepted
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 * Tags: array, two pointers
 * @author yanma
 * @since 2015-02-10
 * @version 2015-02-10
 */


public class RemoveElement_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,3};
		System.out.println("old length: " + A.length);
		
		for (int i : A) {
			System.out.print(i + ", ");
		}
		
		int length = removeElement(A, 3);
		
		System.out.println("new length: " + length);
		for (int i : A) {
			System.out.print(i + ", ");
		}
	}
	
	
	public static int removeElement(int[] A, int elem) {
        int length = A.length;
        
        /**
         * main pointer i from the front
         * second pointer j from the rear
         * when equals to the required value
         * if the j pointer value is also equal to required value
         * remove the j pointer value
         * and move j to the front
         * if not equal to required value
         * replace the i pointer value with the j pointer value
         * and change j value to -1
         * reduce length correspondingly 
         * if the j points to i
         * set the i pointer value to -1
         * reduce length and return
         * 
         */
        
        
        for (int i = 0; i<=length-1; i++) {
        	if (A[i] == elem) {
        		int j = length - 1;
        		while(j > i && A[j]==elem) {
        			A[j]=-1;
        			j--;
        			length--;
        		}
        		if (j > i) {
        			A[i] = A[j];
        			A[j] = -1;
        		}else {
        			A[i] = -1;
        		}     
        		
        		length--;
        	}
        }
        
        return length;
    }

}
