/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Binary Tree Preorder Traversal #144 --- Accepted 262ms/258ms
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author yanma
 * @since 2015-05-02
 * @version 2015-05-02
 */
public class BinaryTreePreorderTraversal_144 {
	/**
	 * Accepted 262ms
	 * @param root
	 * @return
	 */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        } else if (root.left == null && root.right == null) {
        	list.add(root.val);
        	return list;
        }
        
        java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
        TreeNode node = root;
        
        while (node != null) {
        	stack.push(node);
        	list.add(node.val);
        	if (node.left != null) {
        		node = node.left;
        	} else {
        		node = stack.pop().right;
        		while (node == null && !stack.isEmpty()) {
        			node = stack.pop().right;
        		}
        	}
        }
        
        return list;
    }
    
    /**
     * Accepted 258ms
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        } else if (root.left == null && root.right == null) {
        	list.add(root.val);
        	return list;
        }
        
        list.add(root.val);
        list = preorder(root.left, list);
        list = preorder(root.right, list);
        
        return list;
    }
    
    public static List<Integer> preorder(TreeNode root, List<Integer> list) {
    	if (root == null) {
    		return list;
    	} else if (root.left == null && root.right == null) {
    		list.add(root.val);
        	return list;
    	}
    	
    	list.add(root.val);
        list = preorder(root.left, list);
        list = preorder(root.right, list);    	
    	
    	return list;
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
		
		List<Integer> list = preorderTraversal1(node1);
		
		for (Integer val : list) {
			System.out.println(val);
		}

	}

}
