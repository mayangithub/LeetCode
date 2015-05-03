/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Binary Tree Preorder Traversal #144 --- Accepted 262ms
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.right = node2;
		node2.left = node3;
		
		List<Integer> list = preorderTraversal(node1);
		
		for (Integer val : list) {
			System.out.println(val);
		}

	}

}
