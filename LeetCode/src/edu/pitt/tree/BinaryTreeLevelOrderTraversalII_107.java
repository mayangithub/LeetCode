/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Level Order Traversal II #107 --- Accepted 237ms
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author Yan Ma
 * @since 2015-03-12
 * @version 2015-03-12
 *
 *
 * **** 
 * Test case:
 * 1. {} return []
 */
public class BinaryTreeLevelOrderTraversalII_107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> wholeList = new ArrayList<List<Integer>>();
		
        if (root == null) {
        	return wholeList;
        }
        Stack<List<Integer>> wholeStack = new Stack<List<Integer>>();
        
        List<Integer> innerList = new ArrayList<Integer>();
        List<TreeNode> preNodeList = new ArrayList<TreeNode>();
        List<TreeNode> currNodeList = new ArrayList<TreeNode>();
        
        preNodeList.add(root);
        innerList.add(Integer.valueOf(root.val));
        wholeStack.push(innerList);
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
        		wholeStack.push(innerList);
        	}
        	preNodeList = currNodeList;
        }
        
        while(!wholeStack.isEmpty()) {
        	wholeList.add(wholeStack.pop());
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
		
		List<List<Integer>> result = levelOrderBottom(a1);
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
