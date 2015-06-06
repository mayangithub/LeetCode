/**
 * 
 */
package edu.pitt.tree;

/**
 * Count Complete Tree Nodes #222 --- Accepted 772ms
 * Given a complete binary tree, count the number of nodes.
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * @author yanma
 * @since 2015-06-05
 * @version 2015-06-05
 * 
 * Note: very large tree, Exceed Time Limit
 */
public class CountCompleteTreeNodes_222 {

	
    public static int countNodes(TreeNode root) {
         if (root == null) {
        	 return 0;
         } else if (root.left == null && root.right == null) {
        	 return 1;
         }
         
         int height = 0;
         int last = 0;
         TreeNode node = root;
         while (node != null) {
			if (node.left != null) {
				height++;
				node = node.left;
			} else {
				break;
			}
		 }
         
         last = findLast(root, height, 0, last);
         return (int) Math.pow(2, height) - 1 + last;
    }
    
    public static int findLast(TreeNode root, int maxheight, int currheight, int last) {
    	if (root == null) {
    		return last;
    	} else if (currheight == maxheight - 1) {
    		if (root.left != null && root.right == null) {
    			return last + 1;
    		} else if (root.right != null) {
    			return last + 2;
    		} else {
    			return last;
    		}
    	}
    	
    	if (currheight < maxheight - 1) {
    		last = findLast(root.left, maxheight, currheight + 1, last);
    		last = findLast(root.right, maxheight, currheight + 1, last);
    	}     	
    	return last;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		TreeNode node9 = new TreeNode(10);
		TreeNode node10 = new TreeNode(11);
		TreeNode node11 = new TreeNode(12);
		TreeNode node12 = new TreeNode(13);
		TreeNode node13 = new TreeNode(14);
		TreeNode node14 = new TreeNode(15);
		TreeNode node15 = new TreeNode(16);
		TreeNode node16 = new TreeNode(17);
		TreeNode node17 = new TreeNode(18);
		TreeNode node18 = new TreeNode(19);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		node6.right = node14;
		node7.left = node15;
		node7.right = node16;
		node8.left = node17;
		node8.right = node18;
		
		System.out.println(countNodes(root));
	}

}
