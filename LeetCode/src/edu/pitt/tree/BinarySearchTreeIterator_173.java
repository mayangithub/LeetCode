/**
 * 
 */
package edu.pitt.tree;

/**
 * Binary Search Tree Iterator #173 --- Accepted 332ms
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
 * @author yanma
 * @since 2015-04-28
 * @version 2015-04-28
 */
public class BinarySearchTreeIterator_173 {
	public class BSTIterator { // Accepted 332ms
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
	    public BSTIterator(TreeNode root) {
	        while (root != null) {
	        	stack.push(root);
	        	root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return stack.isEmpty() ? false: true;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        int result = -1;
	        if (!stack.isEmpty()) {
	        	TreeNode minNode = stack.pop();
	        	result = minNode.val;
	        	minNode = minNode.right;
	        	while (minNode != null) {
	        		stack.push(minNode);
	        		minNode = minNode.left;
	        	}
	        }
	        return result;
	    }
	}
	

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
