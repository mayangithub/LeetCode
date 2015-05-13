/**
 * 
 */
package edu.pitt.tree;

/**
 * Flatten Binary Tree to Linked List #114 --- Accepted 343ms/332ms
 *  Given a binary tree, flatten it to a linked list in-place.
 *  For example,
 *  Given
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * Hints:
 * If you notice carefully in the flattened tree, 
 * each node's right child points to the next node of a pre-order traversal.
 * @author yanma
 * @since 2015-05-12
 * @version 2015-05-12
 */
public class FlattenBinaryTreetoLinkedList_114 {

	/**
	 * Accepted 343ms
	 * using queue
	 * @param root
	 */
    public void flatten(TreeNode root) {
        if (root == null) {
        	return;
        } else if (root.left == null && root.right == null) {
        	return;
        }
        
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        preorderTraversal(root, queue);
        
        if (!queue.isEmpty()) {
			root = queue.removeFirst();
			root.left = null;
		}
        
        while (!queue.isEmpty()) {
			root.right = queue.poll();
			root = root.right;
			root.left = null;
		}
    }
    
    public void preorderTraversal(TreeNode root, java.util.LinkedList<TreeNode> queue) {
    	queue.offer(root);
    	if (root.left != null) {
			preorderTraversal(root.left, queue);
		}
    	if (root.right != null) {
    		preorderTraversal(root.right, queue);
    	}
    }

    
    //using stack
    /**
     * Accepted 332ms
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
        	return;
        } else if (root.left == null && root.right == null) {
        	return;
        }
        
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        preorderTraversal1(root, stack);
        
        TreeNode headNode = null;
        if (!stack.isEmpty()) {
			headNode = stack.pop();
		}
        
        while (!stack.isEmpty()) {
			TreeNode tail = stack.pop();
			tail.left = null;
			tail.right = headNode;
			headNode = tail;
		}
    }
    
    public void preorderTraversal1(TreeNode root, java.util.Stack<TreeNode> stack) {
    	stack.push(root);
    	if (root.left != null) {
			preorderTraversal1(root.left, stack);
		}
    	if (root.right != null) {
    		preorderTraversal1(root.right, stack);
    	}
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
