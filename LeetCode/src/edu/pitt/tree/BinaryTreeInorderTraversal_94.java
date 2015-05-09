package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal #94 --- Accepted 267ms/257ms
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author yanma
 * @since 2015-05-08
 * @version 2015-05-09
 */
public class BinaryTreeInorderTraversal_94 {
	
	/**
	 * Accepted 267ms
	 * using iteration
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        if (root == null) {
        	return nodeList;
        } else if (root.left == null && root.right == null) {
        	nodeList.add(root.val);
        	return nodeList;
        }
        
        java.util.Hashtable<TreeNode, Boolean> visitTable = new java.util.Hashtable<>();
        java.util.Stack<TreeNode> nodeStack = new java.util.Stack<>();
        TreeNode node = root;
        
        while (node != null) {
			if (!visitTable.containsKey(node)) { //unvisited 
				if (node.left != null) {
					nodeStack.push(node);
					node = node.left;
				} else {
					nodeList.add(node.val);
					visitTable.put(node, true);					
				}
			} else { // visited
				if (node.right != null) {
					node = node.right;
				} else {
					if (!nodeStack.isEmpty()) {
						node = nodeStack.pop();
						nodeList.add(node.val);
						visitTable.put(node, true);
					} else {
						node = null;
					}
				}
			}
		}
        
        return nodeList;
    }
    
    /**
     * Accepted 257ms
     * using recursion
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
    	List<Integer> nodeList = new ArrayList<Integer>();
        if (root == null) {
        	return nodeList;
        } else if (root.left == null && root.right == null) {
        	nodeList.add(root.val);
        	return nodeList;
        }
        
        subInorderTraverse(root, nodeList);
        
        return nodeList;
    }
    
    public static void subInorderTraverse(TreeNode root, List<Integer> nodeList) {
    	if (root == null) {
    		return;
    	} else if (root.left == null) {
    		nodeList.add(root.val);
    		subInorderTraverse(root.right, nodeList);
    	} else {
    		subInorderTraverse(root.left, nodeList);
    		nodeList.add(root.val);
    		subInorderTraverse(root.right, nodeList);
    	}
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node7;
		node7.right = node9;
		node9.left = node10;
		node9.right = node11;
		node5.right = node8;
		node3.right = node6;
		
		List<Integer> list = inorderTraversal1(node1);
		
		for (Integer val : list) {
			System.out.println(val);
		}
	}

}
