package edu.pitt.tree;

import java.util.ArrayList;

/**
 * Symmetric Tree #101 --- Accepted 246ms
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric: 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *   1
 *  / \
 * 2   2
 *  \   \
 *   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * confused what "{1,#,2,3}" means?
 * 
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, 
 * where '#' signifies a path terminator where no node exists below.
 * Here's an example:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
 * 
 * @author yanma
 * @since 2015-03-07
 * @version 2015-03-07
 *
 *
 * Test cases:
 * 1. {} true
 * 2. {1} true
 * 3. {7,10,10,#,22,22,#,-8,35,35,-8,#,57,-66,26,26,-66,57} true
 */
public class SymmetricTree_101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }
        
        if (root != null && root.left == null && root.right == null) {
        	return true;
        }
        
        ArrayList<TreeNode> nodelist = new ArrayList<TreeNode>();
        nodelist.add(root);
        TreeNode curr = root;
        int index = 0;
        int length = 1;
        
        while (index <= length - 1) {
        	curr = nodelist.get(index);
        	if (curr != null) {
        		nodelist.add(curr.left);
            	nodelist.add(curr.right);
            	length = length + 2;
            	index = index + 1;
        	} else if (curr == null && index <= length - 1) {
        		index = index + 1;
        	}
        }
        
        
        String[] valArray = new String[length];
        
        for (int j = 0; j < length; j++) {
        	if (nodelist.get(j) == null) {
        		valArray[j] = "#";
        	} else {
				valArray[j] = String.valueOf(nodelist.get(j).val);
			}
		}
        
        
//        for (int j = 0; j < length; j++ ) {
//        	System.out.print(valArray[j] + ", ");
//        }
//        
//        System.out.println(length);
        
        int empty = 0;
        int full = 2;
        int start = 1;
        while (start + full <= length - 1) {
        	for (int j = 0; j < full / 2 ; j++) {
        		if (!valArray[start + j].equals(valArray[start + full - j - 1])) {
        			return false;
        		} 
        		if (valArray[start + j].equals("#")) {
        			empty = empty + 2;
        		}
        	}
        	start = start + full;
            full = 2 * (full - empty);
            empty = 0;
        }
        return true;
    }
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		TreeNode a1 = new TreeNode(1);
//		TreeNode a2 = new TreeNode(2);
//		TreeNode a3 = new TreeNode(2);
//		TreeNode a4 = new TreeNode(3);
//		TreeNode a5 = new TreeNode(3);
//		TreeNode a6 = new TreeNode(4);
//		TreeNode a7 = new TreeNode(4);
		
//		a1.left = a2;
//		a1.right = a3;
//		a2.right = a4;
//		a3.left = a5;
//		a4.left = a6;
//		a5.right = a7;
		
//		TreeNode a1 = new TreeNode(1);
//		TreeNode a2 = new TreeNode(2);
//		TreeNode a3 = new TreeNode(2);
//		TreeNode a4 = new TreeNode(4);
//		TreeNode a5 = new TreeNode(5);
//		
//		a1.left = a2;
//		a1.right = a3;
//		a3.left = a4;
//		a4.right = a5;
		
		
		TreeNode a1 = new TreeNode(7);
		TreeNode a2 = new TreeNode(10);
		TreeNode a3 = new TreeNode(10);
		TreeNode a4 = new TreeNode(22);
		TreeNode a5 = new TreeNode(22);
		TreeNode a6 = new TreeNode(-8);
		TreeNode a7 = new TreeNode(35);
		TreeNode a8 = new TreeNode(35);
		TreeNode a9 = new TreeNode(-8);
		TreeNode a10 = new TreeNode(57);
		TreeNode a11 = new TreeNode(-66);
		TreeNode a12 = new TreeNode(26);
		TreeNode a13 = new TreeNode(26);
		TreeNode a14 = new TreeNode(-66);
		TreeNode a15 = new TreeNode(57);
		
		a1.left = a2;
		a1.right = a3;
		a2.right = a4;
		a3.left = a5;
		a4.left = a6;
		a4.right = a7;
		a5.left = a8;
		a5.right = a9;
		a6.right = a10;
		a7.right = a12;
		a7.left = a11;
		a8.right = a14;
		a8.left = a13;
		a9.left = a15;
		
		System.out.println(isSymmetric(a1));
		
	}

}
