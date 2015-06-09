/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal #145 --- Accepted 324ms/286ms
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author yanma
 * @since 2015-06-08
 * @version 2015-06-08
 */
public class BinaryTreePostorderTraversal_145 {
	
	
	/**
	 * recursive Accepted 324ms
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
        	list.add(root.val);
        	return list;
        }
        
        helper(list, root);
        
        return list;
    }
    
    public void helper(List<Integer> list, TreeNode node) {
    	if (node == null) return;
    	if (node.left == null && node.right == null) {
    		list.add(node.val);
    		return;
    	}
    	
    	helper(list, node.left);
    	helper(list, node.right);
    	list.add(node.val);
    }
	
    
    /**
     * Iterative  Accepted 286ms
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        java.util.HashMap<TreeNode, Integer> hashMap = new java.util.HashMap<TreeNode, Integer>();//0:left,1:right
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode peekNode = stack.peek();
			if (!hashMap.containsKey(peekNode)) {//not push left
				if (peekNode.left != null) {
					stack.push(peekNode.left);
				}
				hashMap.put(peekNode, 0);
				continue;
			} else if (hashMap.get(peekNode).intValue() == 0) {
				if (peekNode.right != null) {
					stack.push(peekNode.right);
				}
				hashMap.put(peekNode, 1);
				continue;
			} else {
				list.add(peekNode.val);
				stack.pop();
			}
		}
        
        return list;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
