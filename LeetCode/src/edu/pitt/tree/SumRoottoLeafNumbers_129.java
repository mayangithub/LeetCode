/**
 * 
 */
package edu.pitt.tree;

/**
 * Sum Root to Leaf Numbers #129 --- Accepted 304ms
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 *   
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25. 
 * @author yanma
 * @since 2015-05-07
 * @version 2015-05-07
 */
public class SumRoottoLeafNumbers_129 {
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        } else if (root.left == null && root.right == null) {
        	return root.val;
        }
        
        int total = sumBranch(root, root.val + "", 0);
  
        return total;
    }
    
    public static int sumBranch(TreeNode root, String upperPath, int total) {
    	if (root == null) {
        	return total;
        } else if (root.left == null && root.right == null) {
        	total += Integer.valueOf(upperPath);
        	return total;
        }
    	
    	if (root.left != null) {
    		total = sumBranch(root.left, upperPath + root.left.val, total);
    	}
    	if (root.right != null) {
    		total = sumBranch(root.right, upperPath + root.right.val, total);
    	}
    	
    	return total;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		
		int total = sumNumbers(node1);
		System.out.println(total);
	}

}
