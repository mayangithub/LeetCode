/**
 * 
 */
package edu.pitt.dynamicprogramming;

/**
 * Unique Binary Search Trees #96 --- Accepted 222ms
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author yanma
 * @since 2015-05-08
 * @version 2015-05-08
 */
public class UniqueBinarySearchTrees_96 {
	
	/**
	 * Accepted 222ms
	 * @param n
	 * @return
	 */
    public static int numTrees(int n) {
        if (n  < 2) {
        	return 1;
        } 
        
        int[] numbers = new int[n + 1];
        numbers[0] = 1;
        numbers[1] = 1;
        
        for (int total = 2; total < n + 1; total++) {
        	int count = 0;
        	//root use 1 node, left total - 1 nodes to arrange
        	//put all total - 1 nodes on left branch
        	count += numbers[total - 1];
        	//put all total - 1 nodes on right branch
        	count += numbers[total - 1];
        	//put total-1 nodes on both sides, each side start from putting 1 node to putting total - 2
        	for (int left = 1; left < total - 1; left++) {
        		count += numbers[left] * numbers[total - 1 - left];
        	}
        	
        	numbers[total] = count;
        }
        
        return numbers[n];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * case 2:
				return 2;
			case 3: 
				return 5;
			case 4: 
				return 14;
			case 5: 
			    return 42;
			case 6:
			    return 132;
			case 7:
			    return 429;
			case 8: 
			    return 1430;
			case 9:
			    return 4862;
			case 10:
			    return 16796;
		 */
		int num = 1;
		System.out.println("num = 1, trees: " + numTrees(num));
		num = 2;
		System.out.println("num = 2, trees: " + numTrees(num));
		num = 3;
		System.out.println("num = 3, trees: " + numTrees(num));
		num = 4;
		System.out.println("num = 4, trees: " + numTrees(num));
		num = 5;
		System.out.println("num = 5, trees: " + numTrees(num));
		num = 6;
		System.out.println("num = 6, trees: " + numTrees(num));
		num = 7;
		System.out.println("num = 7, trees: " + numTrees(num));
		num = 8;
		System.out.println("num = 8, trees: " + numTrees(num));
		num = 9;
		System.out.println("num = 9, trees: " + numTrees(num));
		num = 10;
		System.out.println("num = 10, trees: " + numTrees(num));
		
	}

}
