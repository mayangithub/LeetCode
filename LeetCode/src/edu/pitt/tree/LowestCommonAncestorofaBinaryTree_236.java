/**
 * 
 */
package edu.pitt.tree;

/**
 * Lowest Common Ancestor of a Binary Tree #236 --- Accepted 416ms
 *      _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6       2       0       8
          /  \
         7    4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
 * since a node can be a descendant of itself according to the LCA definition.
 * @author yanma
 * @since 2015-07-12
 * @version 2015-07-12
 */
public class LowestCommonAncestorofaBinaryTree_236 {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }
        
        return (left != null) ? left: right;
    }

}
