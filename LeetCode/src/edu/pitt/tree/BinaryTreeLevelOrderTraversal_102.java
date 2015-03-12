/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal #102 --- Accepted 229ms
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
 * @author Yan Ma
 * @since 2015-03-11
 * @version 2015-03-12
 */
public class BinaryTreeLevelOrderTraversal_102 {
    
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> wholeList = new ArrayList<List<Integer>>();
		
        if (root == null) {
        	return wholeList;
        }
        
        List<Integer> innerList = new ArrayList<Integer>();
        List<TreeNode> preNodeList = new ArrayList<TreeNode>();
        List<TreeNode> currNodeList = new ArrayList<TreeNode>();
        
        preNodeList.add(root);
        innerList.add(Integer.valueOf(root.val));
        wholeList.add(innerList);
        while (preNodeList.size() > 0) {
        	currNodeList = new ArrayList<TreeNode>();
        	innerList = new ArrayList<Integer>();
        	for (TreeNode node: preNodeList) {
	    		if (node.left != null) {
	    			currNodeList.add(node.left);
	    			innerList.add(Integer.valueOf(node.left.val));
	    		}
	    		
	    		if (node.right != null) {
	    			currNodeList.add(node.right);
	    			innerList.add(Integer.valueOf(node.right.val));
	    		}	    		
	    	}
        	
        	if (innerList.size() > 0) {
        		wholeList.add(innerList);
        	}
        	preNodeList = currNodeList;
        }
    	
        return wholeList;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(9);
		TreeNode a3 = new TreeNode(20);
		TreeNode a4 = new TreeNode(15);
		TreeNode a5 = new TreeNode(7);
		
		a1.left = a2;
		a1.right = a3;
		a3.left = a4;
		a3.right = a5;
		
		List<List<Integer>> result = levelOrder(a1);
		System.out.println("[");
		for (List<Integer> innerL: result) {
			System.out.print("[");
			
			for (Integer value: innerL) {
				System.out.print(value.intValue()+ ", ");
			}
			
			System.out.println("]");
		}
		System.out.println("]");
	}

}
