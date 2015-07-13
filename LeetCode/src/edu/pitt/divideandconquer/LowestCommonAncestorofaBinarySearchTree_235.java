/**
 * 
 */
package edu.pitt.divideandconquer;

import java.util.ArrayList;

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
	
	/**
	 * using BST properties
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        
        return null;
    }
	
	/**
	 * not using BST properties
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
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
    
    /**
     * Using arraylist to compare ancestors
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        
        ArrayList<TreeNode> plist = new ArrayList<TreeNode>();
        ArrayList<TreeNode> qlist = new ArrayList<TreeNode>();
        int psize = 0;
        int qsize = 0;
        
        if (inTree1(root, p, plist)) {
            psize = plist.size();
        } 
        
        if (inTree1(root, q, qlist)) {
            qsize = qlist.size();
        } 
        int i = psize - 1;
        int j = qsize - 1;
        while (i >= 0 && j >= 0) {
            if (plist.get(i).val == qlist.get(j).val) {
                i--; j--;
            } else {
                return plist.get(i + 1);
            }
        }
        
        if (i < 0 && plist.get(i + 1).val == qlist.get(j + 1).val) {
            return plist.get(i + 1);
        } else if (j < 0 && plist.get(i + 1).val == qlist.get(j + 1).val) {
            return plist.get(i + 1);
        }
        
        return null;
    }
    
    public boolean inTree1(TreeNode root, TreeNode node, ArrayList<TreeNode> ancesterList) {
        if (root == null) {
            return false;
        }
        
        if (root == node) {
            ancesterList.add(node);
            return true;
        }
        
        if (inTree1(root.left, node, ancesterList)) {
            ancesterList.add(root);
            return true;
        }
        
        if (inTree1(root.right, node, ancesterList)) {
            ancesterList.add(root);
            return true;
        }
        
        return false;
    }

}
