package edu.pitt.tree;

import edu.pitt.tree.TreeNode;
/**
 * Balanced Binary Tree #110 --- Accepted 241ms
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
 * the two subtrees of every node never differ by more than 1. 
 * @author yanma
 * @since 2015-03-06
 * @version 2015-03-06
 *
 */
public class BalancedBinaryTree_110 {
	/**
	 * Thoughts:
	 * balanced: |leftheight - rightheight| <= 1 
	 * Plan A: 
	 * 		?? if the node has sibling and two children or null child, its parent is balanced
	 * 		?? if the node has only one child, and its only child has only one child, the node is unbalanced.
	 * Plan B: 
	 * 		use another function to calculate height of left and right child, then compare
	 * Plan C:
	 * 		use inner function to calculate subtree height
	 */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        } 
        
        if (root != null && root.left == null && root.right == null) {
        	return true;
        }
         
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        
        if (isBalanced(leftNode) && isBalanced(rightNode)) {
        	int leftHeight = 0;
	        int rightHeight = 0;
	        
	        leftHeight = heightOfTree(leftNode);
	        rightHeight = heightOfTree(rightNode);
	        if (Math.abs(leftHeight - rightHeight) > 1) {
	        	return false;
	        }
	        
	        return true;
			
        } 
        
        return false;
        
    }
    
    
    public static int heightOfTree(TreeNode root) {
    	if (root == null) return 0;
    	
    	if (root != null && root.left == null && root.right == null) {
    		return 1;
    	}
    	
    	int left = heightOfTree(root.left) + 1;
    	int right = heightOfTree(root.right) + 1;
    	return Math.max(left, right);
    }
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Test case 1: {}
		//Test case 2: 1,2,2,3,3,#,#,4,4
		//Test case 3: 1,2,2,3,#,#,3,4,#,#,4
		
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(2);
		TreeNode a4 = new TreeNode(3);
		TreeNode a5 = null;
		TreeNode a6 = null;
		TreeNode a7 = new TreeNode(3);
		TreeNode a8 = new TreeNode(4);
		TreeNode a9 = null;
		TreeNode a10 = null;
		TreeNode a11 = new TreeNode(4);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		a4.left = a8;
		a4.right = a9;
		a7.left = a10;
		a7.right = a11;
		
		System.out.println("a1: " + isBalanced(a1));
		System.out.println("a2: " + isBalanced(a2));
		System.out.println("a3: " + isBalanced(a3));
		System.out.println("a4: " + isBalanced(a4));
		System.out.println("a5: " + isBalanced(a5));
		System.out.println("a6: " + isBalanced(a6));
		System.out.println("a7: " + isBalanced(a7));
		System.out.println("a8: " + isBalanced(a8));
		System.out.println("a9: " + isBalanced(a9));
		System.out.println("a10: " + isBalanced(a10));
		System.out.println("a11: " + isBalanced(a11));
	}

}
