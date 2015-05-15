/**
 * 
 */
package edu.pitt.math;

/**
 * Count Primes #204 --- Accepted 243ms
 * Count the number of prime numbers less than a non-negative number, n
 * @author yanma
 * @since 2015-05-15
 * @version 2015-05-15
 */
public class CountPrimes_204 {

	/**
	 * Accepted 243ms
	 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
	 * Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
	 * Initially, let p equal 2, the first prime number.
	 * Starting from p, enumerate its multiples by counting to n in increments of p, 
	 * and mark them in the list (these will be 2p, 3p, 4p, ... ; the p itself should not be marked).
	 * Find the first number greater than p in the list that is not marked. 
	 * If there was no such number, stop. 
	 * Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
	 * When the algorithm terminates, all the numbers in the list that are not marked are prime.
	 * @param n
	 * @return
	 */
    public static int countPrimes(int n) {
        if (n <= 2) {
        	return 0;
        } 
        
        boolean[] table = new boolean[n];
        
        for (int start = 2; start < n; start++) {
        	if (table[start]) {
				continue; // not prime
			}
        	
        	int prime = start;
        	for (int index = 2; index * prime < n; index++) { //2p, 3p, 4p, .......
        		if (!table[index * prime]) {
        			table[index * prime] = true;
        		}
        	}
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
        	if (!table[i]) {
//        		System.out.print(i + "  ");
        		count++;
        	}
        }
        
        return count;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1 = 5;
		int n2 = 10; 
		int n3 = 15;
		int n4 = 499979;
		int n5 = 1;
		int n6 = 2;
		int n7 = 3;
		int n8 = 4;
		
		System.out.println("< n1: 5 " + countPrimes(n1));
		System.out.println("< n2: 10 " + countPrimes(n2));
		System.out.println("< n3: 15 " + countPrimes(n3));
		System.out.println("< n4: 499979 " + countPrimes(n4));
		System.out.println("< n5: 1 " + countPrimes(n5));
		System.out.println("< n6: 2 " + countPrimes(n6));
		System.out.println("< n7: 3 " + countPrimes(n7));
		System.out.println("< n8: 4 " + countPrimes(n8));
		
		
	}

}
