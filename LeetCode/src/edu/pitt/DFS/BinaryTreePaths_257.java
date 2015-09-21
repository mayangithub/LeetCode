/**
 * 
 */
package edu.pitt.DFS;

import java.util.ArrayList;
import java.util.List;

import edu.pitt.tree.TreeNode;

/**
 * Binary Tree Paths #257 --- Accepted
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
	   1
	 /   \
	2     3
	 \
	  5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * @author yanma 
 * @category Easy
 * @version 2015-09-21
 */
public class BinaryTreePaths_257 {
	
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        StringBuffer path = new StringBuffer();
        path.append(root.val);
        helper(root, path, result);
        
        return result;
    }
    
    public void helper(TreeNode root, StringBuffer path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path.toString());
            return;
        }
        
        if (root.left != null) {
            StringBuffer bf = new StringBuffer(path.toString());
            bf.append("->" + root.left.val);
            helper(root.left, bf, result);
        }  
        if (root.right != null) {
            StringBuffer bf = new StringBuffer(path.toString());
            bf.append("->" + root.right.val);
            helper(root.right, bf, result);
        }
    }

}
