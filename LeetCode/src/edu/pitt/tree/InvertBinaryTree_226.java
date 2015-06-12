/**
 * 
 */
package edu.pitt.tree;

/**
 * Invert Binary Tree #226 --- Accepted 308ms
 * Invert a binary tree.
 * 
 * 	     4
 * 	   /   \
 * 	  2     7
 * 	 / \   / \
 * 	1   3 6   9
 * 
 * to
 * 
 * 	     4
 * 	   /   \
 * 	  7     2
 * 	 / \   / \
 * 	9   6 3   1
 * @author yanma
 * @since 2015-06-12
 * @version 2015-06-12
 */
public class InvertBinaryTree_226 {
	
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
        	return root;
        } if (root.left == null && root.right == null) {
        	return root;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
