/**
 * 
 */
package edu.pitt.tree;

/**
 * Populating Next Right Pointers in Each Node II #117 --- Accepted 312ms
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 *     You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * @author yanma
 * @since 2015-06-09
 * @version 2015-06-09
 */
public class PopulatingNextRightPointersinEachNodeII_117 {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode parent = root;
        while (parent != null) {
			TreeLinkNode pointer = parent;
			while (pointer != null) {
				if (pointer.right != null) {
					pointer.right.next = findMostLeft(pointer.next);
				}
				if (pointer.left != null) {
					if (pointer.right != null) {
						pointer.left.next = pointer.right;
					} else {
						pointer.left.next = findMostLeft(pointer.next);
					}
				}
				pointer = pointer.next;
			}
			
			parent = findMostLeft(parent);
			
		}
    }
    
    public TreeLinkNode findMostLeft(TreeLinkNode root) {
    	if (root == null) return null;
    	while (root != null) { //do this trimming in here, not in main method
    		if (root.left != null) return root.left;
    		if (root.right != null) return root.right;
    		root = root.next;
		}
    	return null;
    }
    
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
