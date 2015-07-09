/**
 * 
 */
package edu.pitt.tree;

import java.util.Stack;

/**
 * Kth Smallest Element in a BST #230 --- accepted
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * Hint:
 *     Try to utilize the property of a BST.
 *     What if you could modify the BST node's structure?
 *     The optimal runtime complexity is O(height of BST).
 * @author yanma
 * @since 2015-07-09
 * @version 2015-07-09
 */
public class KthSmallestElementinaBST_230 {
	
	/**
	 * using O(k) space O(k) time
	 * inorder traversal
	 * @param root
	 * @param k
	 * @return
	 */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        
        int rank = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            rank++;
            if (rank == k) return curr.val;
            curr = curr.right;
        }
        
        return 0;
    }

}
