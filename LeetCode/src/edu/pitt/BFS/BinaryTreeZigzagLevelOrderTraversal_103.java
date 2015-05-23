/**
 * 
 */
package edu.pitt.BFS;

import java.util.ArrayList;
import java.util.List;

import edu.pitt.tree.TreeNode;

/**
 * Binary Tree Zigzag Level Order Traversal #103 --- Accepted 348ms
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author yanma
 * @since 2015-05-23
 * @version 2015-05-23
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
	
	
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
        	return list;
        } else if (root.left == null && root.right == null) {
        	List<Integer> innerList = new ArrayList<>();
        	innerList.add(root.val);
        	list.add(innerList);
        	return list;
        }
        
    	java.util.Stack<TreeNode> stackeven = new java.util.Stack<>();
    	stackeven.push(root);
    	java.util.Stack<TreeNode> stackodd = new java.util.Stack<>();
    	
        
        for (int depth = 0; depth <= list.size(); depth++) {
        	List<Integer> newinnerList = new ArrayList<>();
        	if (depth % 2 == 0) {
        		stackodd.clear();
        		while (!stackeven.isEmpty()) {
					TreeNode node = stackeven.pop();
					newinnerList.add(node.val);
					if (node.left != null) {
						stackodd.push(node.left);
					}
					
					if (node.right != null) {
						stackodd.push(node.right);
					}					
				}
        	} else {
        		stackeven.clear();
        		while (!stackodd.isEmpty()) {
					TreeNode node = stackodd.pop();
					newinnerList.add(node.val);
					if (node.right != null) {
						stackeven.push(node.right);
					} 
					if (node.left != null) {
						stackeven.push(node.left);
					}
				}
        	}        	
        	if (!newinnerList.isEmpty()) {
        		list.add(newinnerList);
        	}
        }
        
    	return list;
    }
    
    
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		List<List<Integer>> list = zigzagLevelOrder(node1);
		System.out.println("[");
		for (List<Integer> inner: list) {
			System.out.print("[");
			for (Integer val: inner) {
				System.out.print(val + ", ");
			}
			System.out.println("]");
		}
		System.out.println("]");
		
	}

}
