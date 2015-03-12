/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal #102
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author yanma
 * @version 2015-03-11
 * @since 2015-03-11
 *
 */
public class BinaryTreeLevelOrderTraversal_102 {
    
	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
        	return null;
        }
		
        List<List<Integer>> wholeList = new ArrayList<List<Integer>>();
        List<Integer> innerList = new ArrayList<Integer>();
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        
        if (root != null && root.left == null && root.right == null) {
        	innerList.add(Integer.valueOf(root.val));
        	wholeList.add(innerList);
        	return wholeList;
        }
        
        innerList.add(Integer.valueOf(root.val));
    	wholeList.add(innerList);
    	nodeList.add(root);
    	
    	int full = 1;
    	int start = 0;
    	
    	while (full > 0) {
    		innerList.clear();
    		int empty = 0;
	    	for (int i = 0; i < full; i++) {
	    		TreeNode tempNode = nodeList.get(start + i);
//	    		if (tempNode != null) {
	    			if (tempNode.left == null) {
	    				empty++;
	    			} else {
	    				nodeList.add(tempNode.left);
	    			}
	    			
	    			
	    			if (tempNode.right == null) {
	    				empty++;
	    			} else {
	    				nodeList.add(tempNode.right);
	    			}
//	    		}
	    	}
    	}
    	
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
