/**
 * 
 */
package edu.pitt.tree;

import edu.pitt.tree.TreeNode;

/**
 * Maximum Depth of Binary Tree #104 --- Accepted 250ms
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * @author yanma
 * @since 2015-03-06
 * @version 2015-03-06
 *
 */
public class MaximumDepthOfBinaryTree_104 {
	
	/**
	 * Thoughts:
	 * 1. if root is null or doesn't have child, return 0
	 * 2. left is not null, leftDepth + 1
	 * 3. right is not null, rightDepth + 1
	 * 4. return max(leftDepth, rightDepth)
	 */
	
	public static int maxDepth(TreeNode root) {
        if (root == null ) {
        	return 0;
        } else if (root != null && root.left == null && root.right == null){
			return 1;
		}
        
        
        int leftDepth = 0;
        int rightDepth = 0;
        
        if (root.left != null) {
        	leftDepth = 1 + maxDepth(root.left);
        }
        
        if (root.right != null) {
        	rightDepth = 1 + maxDepth(root.right);
        }
        
        return Math.max(leftDepth, rightDepth);
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(8);
		TreeNode a9 = new TreeNode(9);
		
		a3.left = a1;
		a3.right = a2;
		a8.left = a3;
		a8.right = a4;
		a7.left = a5;
		a7.right = a6;
		a9.left = a8;
		a9.right = a7;
		
		System.out.println("a1 depth: " + maxDepth(a1));
		System.out.println("a2 depth: " + maxDepth(a2));
		System.out.println("a3 depth: " + maxDepth(a3));
		System.out.println("a4 depth: " + maxDepth(a4));
		System.out.println("a5 depth: " + maxDepth(a5));
		System.out.println("a6 depth: " + maxDepth(a6));
		System.out.println("a7 depth: " + maxDepth(a7));
		System.out.println("a8 depth: " + maxDepth(a8));
		System.out.println("a9 depth: " + maxDepth(a9));
		

	}

}
