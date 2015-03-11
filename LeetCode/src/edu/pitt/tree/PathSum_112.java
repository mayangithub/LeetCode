/**
 * 
 */
package edu.pitt.tree;

/**
 * Path Sum #112 --- Accepted 246ms
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *                5
 *               / \
 *              4   8
 *             /   / \
 *            11  13  4
 *           /  \      \
 *          7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author yanma
 * @since 2015-03-10
 * @version 2015-03-10
 * 
 * ****
 * Test case:
 * 1. {} sum 0, return false
 *
 */
public class PathSum_112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
    	
        if (root == null) {
        	return false;
        } 
//        System.out.println("root: " + root.val);
        if (root != null && root.left == null && root.right == null) {
        	if (sum != root.val) return false;
        	if (sum == root.val) return true;
        }
        
        boolean left = false;
        if (root.left != null) {
        	left = hasPathSum(root.left, sum - root.val);
        }
        
        boolean right = false;
        if (root.right != null) {
        	right = hasPathSum(root.right, sum - root.val);
        }
        
//        System.out.println("left: " + left);
//        System.out.println("right: " + right);
        
        if (left || right) {
        	return true;
        } else {
			return false;
		}
        
        
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a1 = new TreeNode(5);
		TreeNode a2 = new TreeNode(4);
		TreeNode a3 = new TreeNode(8);
		TreeNode a4 = new TreeNode(11);
		TreeNode a5 = new TreeNode(13);
		TreeNode a6 = new TreeNode(4);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(2);
		TreeNode a9 = new TreeNode(1);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a3.left = a5;
		a3.right = a6;
		a4.left = a7;
		a4.right = a8;
		a6.right = a9;
		
		System.out.println("root: a1, sum: 22; " + hasPathSum(a1, 22));
		
		
	}

}
