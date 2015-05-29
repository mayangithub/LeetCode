/**
 * 
 */
package edu.pitt.DFS;

import edu.pitt.tree.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal #105 --- Accepted 368ms
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author Yan-PC
 * @since 2015-05-29
 * @version 2015-05-29
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
        	return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
    public TreeNode helper(int[]  preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
    	if (prestart > preend || instart > inend) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[prestart]);
    	int position = findIndex(inorder, preorder[prestart], instart);
    	
    	/**
    	 * root left: 
    	 * - preorder: start after root, end before right part
    	 * - inorder: end before root
    	 * root right:
    	 * - preorder: start after left part preorder end
    	 * - inorder: start after root 
    	 */
    	root.left = helper(preorder, prestart + 1, prestart + position - instart, inorder, instart, position - 1);
    	root.right = helper(preorder, prestart + position - instart + 1, preend, inorder, position + 1, inend);
    	
    	return root;
    }
    
    public int findIndex(int[] array, int target, int start) {
    	if (array == null || array.length == 0) {
    		return -1;
    	}
    	for (int i = start; i < array.length; i++) {
    		if (array[i] == target) return i;
    	}
    	return -1;
    }
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
