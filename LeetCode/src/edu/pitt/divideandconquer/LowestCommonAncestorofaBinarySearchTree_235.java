/**
 * 
 */
package edu.pitt.divideandconquer;

import edu.pitt.tree.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree #235 --- Accepted 452ms
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 * @author yanma
 * @version 2015-07-11
 * @since 2015-07-11
 */
public class LowestCommonAncestorofaBinarySearchTree_235 {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        
        TreeNode proot = null;
        TreeNode qroot = null;
        
        if (inTree(root.left, p)) {
            proot = root.left;
        } else if (inTree(root.right, p)) {
            proot = root.right;
        }
        
        if (inTree(root.left, q)) {
            qroot = root.left;
        } else if (inTree(root.right, q)) {
            qroot = root.right;
        }
        
        if (proot == qroot) {
            return lowestCommonAncestor(proot, p, q);
        } else if (proot != null && qroot != null) {
            return root;
        } else if (proot != null) {
            return proot;
        } else if (qroot != null) {
            return qroot;
        }
        
        return null;
    }
    
    public boolean inTree(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        
        if (node == root) {
            return true;
        }
        
        return inTree(root.left, node) || inTree(root.right, node);
    }

}
