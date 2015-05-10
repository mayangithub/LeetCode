/**
 * 
 */
package edu.pitt.tree;

import java.util.Hashtable;

/**
 * Populating Next Right Pointers in Each Node #116 --- Accepted 328ms
 *  Given a binary tree
 *  struct TreeLinkNode {
 *  	TreeLinkNode *left;
 *  	TreeLinkNode *right;
 *  	TreeLinkNode *next;
 *  }
 *  Populate each next pointer to point to its next right node. 
 *  If there is no next right node, the next pointer should be set to NULL.
 *  Initially, all next pointers are set to NULL.
 *  Note:
 *      You may only use constant extra space.
 *      You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *  For example,
 *  Given the following perfect binary tree,
 *  	1
 *     /  \
 *    2    3
 *   / \  / \
 *  4  5  6  7
 *  After calling your function, the tree should look like:
 *      1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 * @author yanma
 * @since 2015-05-09
 * @version 2015-05-09
 */
public class PopulatingNextRightPointersinEachNode_116 {
	
    public void connect(TreeLinkNode root) {
    	if (root == null) {
    		return;
    	} else if (root.left == null && root.right == null) {
    		root.next = null;
    		return;
    	} 
        //use hashtable to store parent node for each node, key: node, value: parent node
    	java.util.Hashtable<TreeLinkNode, TreeLinkNode> nodeTable = new java.util.Hashtable<>();
    	
    	TreeLinkNode nullNode = new TreeLinkNode(-1);
    	nodeTable.put(root, nullNode);
    	
    	findParent(root.left, root, nodeTable);
    	findParent(root.right, root, nodeTable);
    	
    	root.next = null;
    	
    	setNext(root.left, nodeTable);
    	setNext(root.right, nodeTable);
    }
    
    public void findParent(TreeLinkNode node, TreeLinkNode parent, java.util.Hashtable<TreeLinkNode, TreeLinkNode> parentTable) {
    	if (node == null) {
    		return;
    	} 
		parentTable.put(node, parent);
		findParent(node.left, node, parentTable);
		findParent(node.right, node, parentTable);
    }
    
    public void setNext(TreeLinkNode node, java.util.Hashtable<TreeLinkNode, TreeLinkNode> parentTable) {
    	if (node == null) {
    		return;
    	}
    	
    	TreeLinkNode parent = parentTable.get(node);
    	if (node == parent.left) {
    		node.next = parent.right;
    	} else if (node == parent.right) {
    		TreeLinkNode neighborParent = parent.next;
    		if (neighborParent != null) {
    			node.next = neighborParent.left;
    		} else {
    			node.next = null;
    		}
    	}
    	
    	setNext(node.left, parentTable);
    	setNext(node.right, parentTable);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
