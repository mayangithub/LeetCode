/**
 * 
 */
package edu.pitt.DFS;

import edu.pitt.tree.TreeNode;

/**
 * Recover Binary Search Tree #99 --- Accepted 468ms
 *  Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
 * @author yanma
 * @since 2015-06-12
 * @version 2015-06-12
 * don't need to change node, just change value
 */
public class RecoverBinarySearchTree_99 {
	TreeNode pre = new TreeNode(Integer.MIN_VALUE); 
	TreeNode first = null; 
	TreeNode second = null;
	
    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
        	return;
        }
        
        inorderTraverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorderTraverse(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	inorderTraverse(root.left);
    	if (first == null && root.val < pre.val) {
    		first = pre;
    	}
    	if (first != null && root.val < pre.val) {
    		second = root;
    	}
    	pre = root;
    	inorderTraverse(root.right);
    }
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
