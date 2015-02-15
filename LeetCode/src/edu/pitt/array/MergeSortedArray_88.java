package edu.pitt.array;

/**
 * Merge Sorted Array #88
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * @author yanma
 *
 */
public class MergeSortedArray_88 {

	
	public static void merge(int A[], int m, int B[], int n) {
		/**
		 * 思路：
		 * 1. 如果n=0，返回A
		 * 2. 如果m=0, 将B复制进A
		 * 3. 如果m*n != 0, 指针k从最后第A[m+n-1]位开始，i指针在A[m-1], j指针在B[n-1]，------ i和j的声明应该在For loop之前
		 * 在i>=0 并且 j>=0 情况下，------- 要用if，不能用while， 用while需要对k进行递减操作
		 * 	4. 如果A[i]>=B[j], A[k] = A[i],i--, 
		 * 	5. 如果A[i]<B[j]，A[k] = B[j], j--, 
		 * 
		 * 6. 如果i<0, A[k] = B[j]
		 * 7. 如果j<0, A[k] = B[i]
		 */
        if (n == 0) {
        	return;
        }
        
        if (m == 0) {
        	for (int i = 0; i < n; i++) {
        		A[i] = B[i];
        	}
        	return;
        }
        
        int i = m - 1;
    	int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
        	
        	if ((i >= 0) && (j >= 0)) {
        		if (A[i] >= B[j]) {
        			A[k] = A[i];
        			i--;
        		}else {
        			A[k] = B[j];
        			j--;
        		}
        	} else if (i < 0) {
        		//if not test j >= 0, will be faster
        		A[k] = B[j];
        		j--;
        	} else if (j < 0) {
        		//if not test i >= 0, will be faster 
        		A[k] = A[i];
    			i--;
        	}
        }
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
