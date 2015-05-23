/**
 * 
 */
package edu.pitt.DFS;

import edu.pitt.tree.TreeNode;

/**
 * Validate Binary Search Tree #98 --- Accepted 396ms/348ms
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @author yanma
 * @since 2015-05-23
 * @version 2015-05-23
 */
public class ValidateBinarySearchTree_98 {

	//rightmost node value in left subtree less than root value
	//leftmost node value in right subtree more than root value
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        } else if (root.left == null && root.right == null) {
        	return true;
        } 
        
        if (root.left != null && root.left.val >= root.val) {
        	return false;
        } else if (root.right != null && root.right.val <= root.val) {
        	return false;
        }
        
        if (compare(root)) {
        	return isValidBST(root.left) && isValidBST(root.right);
        }
        
        return false;
    }
    
    public boolean compare(TreeNode root) {
    	long leftmost = mostvalue(root.left, 0);
    	long rightmost = mostvalue(root.right, 1);
    	
    	if (leftmost >= root.val || rightmost <= root.val) {
    		return false;
    	}
    	return true;
    }
    
    public long mostvalue(TreeNode root, int direction) { //0: left; 1: right;
    	if (root == null) {
    		return (direction == 0) ? Long.MIN_VALUE: Long.MAX_VALUE;
    	}
    	
    	if (direction == 0) {
    		while (root.right != null) {
				root = root.right;
			}
    	} else {
    		while (root.left != null) {
				root = root.left;
			}
    	}
    	return root.val;
    }
    
    /*****************************************************************************/
    /**
     * Accepted 348ms
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
    	if (root == null) {
        	return true;
        } else if (root.left == null && root.right == null) {
        	return true;
        } 
    	
    	if (root.left != null && root.left.val >= root.val) {
        	return false;
        } else if (root.right != null && root.right.val <= root.val) {
        	return false;
        }
    	
    	return isValidSubtree(root.left, Long.MIN_VALUE, root.val) && isValidSubtree(root.right, root.val, Long.MAX_VALUE);
    	    	
    }
    
    public boolean isValidSubtree(TreeNode root, long minValue, long maxValue) {
    	if (root == null) {
    		return true;
    	} 
    	
    	if (root.val >= maxValue || root.val <= minValue) {
    		return false;
    	}
    	
    	return isValidSubtree(root.left, minValue, root.val) && isValidSubtree(root.right, root.val, maxValue);
    }
    
    
    
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
