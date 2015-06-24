/**
 * 
 */
package edu.pitt.DFS;

import edu.pitt.tree.TreeNode;

/**
 * Binary Tree Maximum Path Sum #124 --- accepted 484ms
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return 6. 
 * @author yanma
 * @since 2015-06-23
 * @version 2015-06-23
 */
public class BinaryTreeMaximumPathSum_124 {
	
	private class ResultType {
		// singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意点到任意点的最大路径，这条路径至少包含一个点（也就是root）
		int singlePath;
		int maxPath;
		ResultType(int sp, int mp) {
			this.singlePath = sp;
			this.maxPath = mp;
		}
	}
	
    public int maxPathSum(TreeNode root) {
        if (root == null) {
        	return 0;
        } else if (root.left == null && root.right == null) {
        	return root.val;
        }
        
        return helper(root).maxPath;
    }
    
    public ResultType helper(TreeNode root) {
    	if (root == null) {
    		return new ResultType(0, Integer.MIN_VALUE);
    	}
    	
    	ResultType left = helper(root.left);
    	ResultType right = helper(root.right);
    	
    	int singlepath = Math.max(left.singlePath, right.singlePath) + root.val;
    	singlepath = Math.max(singlepath, 0);
    	
    	int maxpath = Math.max(left.maxPath, right.maxPath);
    	maxpath = Math.max(maxpath, left.singlePath + right.singlePath + root.val);
    	
    	return new ResultType(singlepath, maxpath);
    }
    
}
