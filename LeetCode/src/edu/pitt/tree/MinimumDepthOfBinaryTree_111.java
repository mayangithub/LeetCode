/**
 * 
 */
package edu.pitt.tree;

/**
 * Minimum Depth of Binary Tree #111 --- Accepted 263 ms
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node 
 * down to the nearest leaf node.
 * @author yanma
 * @since 2015-03-09
 * @version 2015-03-09
 */
public class MinimumDepthOfBinaryTree_111 {
	
    public static int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        if (root != null && root.left == null && root.right == null) {
        	return 1;
        }
        
        if (root.left != null && root.right == null) {
        	return 1 + minDepth(root.left);
        }
        
        if (root.left == null && root.right != null) {
        	return 1 + minDepth(root.right);
        }
        
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        System.out.println("left: " + left);
    	
    	System.out.println("right: " + right);
    	return Math.min(left, right) + 1;

    }
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(2);
//		TreeNode a4 = new TreeNode(3);
		TreeNode a5 = new TreeNode(3);
//		TreeNode a6 = new TreeNode(4);
		TreeNode a7 = new TreeNode(4);
		
		a1.left = a2;
		a1.right = a3;
		a3.left = a5;
		a5.right = a7;
		
		System.out.println(minDepth(a1));
		
	}

}
