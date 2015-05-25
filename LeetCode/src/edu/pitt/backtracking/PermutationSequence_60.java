/**
 * 
 */
package edu.pitt.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutation Sequence #60 --- Accepted 244ms
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * @author yanma
 * @since 2015-05-24
 * @version 2015-05-24
 */
public class PermutationSequence_60 {

	/**
	 * Accepted 244ms
	 * @param n
	 * @param k
	 * @return
	 */
    public static String getPermutation1(int n, int k) {
    	if (n <= 0 || k <= 0) {
        	return "";
        }
        int[] facArray = factorial(n);
        if (k > facArray[n]) {
        	return "";
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
        	list.add(i);
        }        
        StringBuffer string = new StringBuffer();
        k = k - 1;
        for (int pos = 1; pos <= n; pos++) {
        	int digit = k / facArray[n - pos];
			string.append(list.get(digit));
			list.remove(digit);
			k %= facArray[n - pos];
        }
        return string.toString();
    }
	
    public static int[] factorial(int n) {
    	int[] facArray = new int[n + 1];
    	facArray[0] = 1;
    	for (int i = 1; i <= n; i++) {
    		facArray[i] = facArray[i - 1] * i;
    	}
    	return facArray;
    }
	
	
	//TLE
    public static String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
        	return "";
        }
        int[] facArray = factorial(n);
        if (k > facArray[n]) {
        	return "";
        }
        
        StringBuffer string = new StringBuffer();
        if (k == 1) {
        	for (int i = 1; i <= n; i++) {
        		string.append(i);
        	}
        	return string.toString();
        }
        
        List<String> list = new ArrayList<String>();
        helper(n, k, list, string.toString());
        
        return list.get(k - 1);
    }
    
    
    
    
    public static void helper(int n, int k, List<String> list, String str) {
    	if (str.length() == n) {
    		list.add(str);
    	}
    	for (int i = 1; i <= n; i++) {
    		if (str.indexOf(i + "") == -1) {
    			StringBuffer strbuffer = new StringBuffer(str);
    			helper(n, k, list, strbuffer.append(i).toString());
    		}
    		if (list.size() >= k) {
    			break;
    		}
    	}
    }
	
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int k = 17223;//  273815
	
//		int n = 3;
//		int k = 2;
		
		System.out.println(getPermutation1(n, k));
		
		
		
	}

}
