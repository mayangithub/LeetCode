package edu.pitt.tree;

import edu.pitt.tree.TreeNode;
/**
 * Same Tree #100 --- Accepted 209ms
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 * 
 * @author yanma
 * @since 2015-03-06
 * @version 2015-03-06
 *
 */
public class SameTree_100 {
	
	/**
	 * Thoughts:
	 * "structurally identical": both have or not have child
	 * 1. if just one of tree nodes is null, return false
	 * 2. if values are different, return false
	 * 3. if values are same, go to left and right child then.
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	
        if (p == null && q == null) {
        	return true;
        } 
        
        if (p == null ^ q == null) {
        	return false; // if one is not null, but the other is null
        }
        
        if (p != null && q != null && p.val != q.val) {
        	return false;
        } else {
        	boolean left = isSameTree(p.left, q.left);
	        boolean right = isSameTree(p.right, q.right);
	    	
	    	return (left && right);
        }
        
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(1);
		TreeNode a3 = new TreeNode(6);
		TreeNode a4 = new TreeNode(6);
		TreeNode a5 = new TreeNode(1);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(7);
		TreeNode a9 = new TreeNode(9);
		
		a3.left = a1;
		a3.right = a2;
		a8.left = a3;
		a8.right = a4;
		a7.left = a5;
		a7.right = a6;
		a9.left = a8;
		a9.right = a7;
		
		System.out.println("a1 and a2: " + isSameTree(a1, a2)); // true
		System.out.println("a3 and a4: " + isSameTree(a3, a4)); // false
		System.out.println("a5 and a6: " + isSameTree(a5, a6)); // false
		System.out.println("a7 and a8: " + isSameTree(a7, a8)); // false
		System.out.println("a1 and a4: " + isSameTree(a1, a4)); // false
		System.out.println("a3 and a5: " + isSameTree(a3, a5)); // false
		System.out.println("a3 and a6: " + isSameTree(a3, a6)); // false
		System.out.println("a4 and a6: " + isSameTree(a4, a6)); // true
		System.out.println("a3 and a7: " + isSameTree(a3, a7)); // false
	}

}
