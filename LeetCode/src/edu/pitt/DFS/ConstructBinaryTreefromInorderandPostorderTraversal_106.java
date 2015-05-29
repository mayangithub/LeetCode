/**
 * 
 */
package edu.pitt.DFS;

import edu.pitt.tree.TreeNode;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal #106 --- Accepted 316ms
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * @author Yan-PC
 * @since 2015-05-29
 * @version 2015-05-29
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
    		return null;
    	} 
    	return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
    	if (poststart > postend || instart > inend) {
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(postorder[postend]);
    	int position = findIndex(inorder, postorder[postend], inend);
    	
    	/**
    	 * root left:
    	 * - postorder: how to decide where to end? ** find the length of left part first, (position - instart), start from poststart, remember to minus 1 
    	 * - inorder: end before root
    	 * root right:
    	 * - postorder: start right after left part, end before root
    	 * - inorder: start after root
    	 */
    	
    	root.left = helper(postorder, poststart, poststart + position - instart - 1, inorder, instart, position - 1);
    	root.right = helper(postorder, poststart + position - instart, postend - 1, inorder, position + 1, inend);
    	
    	return root;
    }
    
    public int findIndex(int[] array, int target, int end) {
    	if (array == null || array.length == 0 || end >= array.length) {
    		return -1;
    	}
    	for (int i = end; i >= 0; i--) {
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
