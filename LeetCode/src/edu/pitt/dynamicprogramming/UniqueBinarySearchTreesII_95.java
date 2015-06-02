/**
 * 
 */
package edu.pitt.dynamicprogramming;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import edu.pitt.tree.TreeNode;

/**
 * Unique Binary Search Trees II #95 --- Accepted 304ms
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author yanma
 * @since 2015-06-01
 * @version 2015-06-01
 */
public class UniqueBinarySearchTreesII_95 {

	/**
	 * Caution: should build a BST, [2, #, 1] is not a BST
	 * Thoughts: ith num in [1, n] as root, left tree in [1, i - 1], right tree in [i + 1, n]
	 * -----------------------------------------------------
	 * n = 1       1
	 * -----------------------------------------------------
	 * n = 2    1       2
	 *           \     /
	 *            2   1
	 * -----------------------------------------------------
	 * n = 3    1        1        2          3          3
	 *           \        \      / \        /          /
	 *            2        3    1   3      2          1
	 *             \      /               /            \
	 *              3    2               1              2
	 * -----------------------------------------------------
	 * n = 4    1        1        1         1          1   
	 *           \        \        \         \          \
	 *            2        2        3         4          4
	 *             \        \      / \        /         /
	 *              3        4    2   4      2         3
	 *               \       /                \       /
	 *                4     3                  3     2
	 * -----------------------------------------------------
	 *          2        2       
	 *         / \      / \
	 *        1   3    1   4
	 *             \      /
	 *              4    3
	 * -----------------------------------------------------         
	 *          3        3
	 *         / \      / \ 
	 *        2   4    1   4
	 *       /          \
	 *      1            2
	 * -----------------------------------------------------         
	 *          4        4        4          4          4
	 *         /        /        /          /          /
	 *        3        2        1          1          3
	 *       /        / \        \          \        /
	 *      2        1   3        2          3      1
	 *     /                       \        /        \
	 *    1                         3      2          2
	 * -----------------------------------------------------
	 * @param n
	 * @return
	 */
	
	
    public static List<TreeNode> generateTrees(int n) {
    	List<TreeNode> list = new ArrayList<>();
    	if (n == 0) {
    		TreeNode root = null;
    		list.add(root);
    		return list;
    	} else if (n == 1) {
    		TreeNode root = new TreeNode(n);
    		list.add(root);
    		return list;
    	}
    	helper(1, n, list);
    	return list;
    }
    
    public static void helper(int start, int end, List<TreeNode> list) {
    	if (start > end) {
    		return;
    	}
    	
    	for (int i = start; i <= end; i++) {
    		TreeNode root = new TreeNode(i);
    		List<TreeNode> leftTree = new ArrayList<>();
    		helper(start, i - 1, leftTree);
    		
    		List<TreeNode> rightTree = new ArrayList<>();
    		helper(i + 1, end, rightTree);
    		
    		if (leftTree.size() > 0 && rightTree.size() > 0) {
    			for (TreeNode left: leftTree) {
        			for (TreeNode right: rightTree) {
        				TreeNode rooTreeNode = new TreeNode(root.val);
        				rooTreeNode.left = left;
        				rooTreeNode.right = right;
        				list.add(rooTreeNode);
        			}
        		}
    		} else if (leftTree.size() > 0 && rightTree.size() == 0) {
    			for (TreeNode left: leftTree) {
    				TreeNode rooTreeNode = new TreeNode(root.val);
    				rooTreeNode.left = left;
    				rooTreeNode.right = null;
    				list.add(rooTreeNode);
        		}
    		} else if (leftTree.size() == 0 && rightTree.size() > 0) {
    			for (TreeNode right: rightTree) {
    				TreeNode rooTreeNode = new TreeNode(root.val);
    				rooTreeNode.left = null;
    				rooTreeNode.right = right;
    				list.add(rooTreeNode);
    			}
    		} else {
    			TreeNode rooTreeNode = new TreeNode(root.val);
    			rooTreeNode.left = null;
    			rooTreeNode.right = null;
				list.add(rooTreeNode);
			}
    	}
    }
    
    
    public static void printTree(TreeNode root) {
    	Deque<TreeNode> deque = new LinkedList<TreeNode>();
    	System.out.print("[");
    	deque.offer(root);
    	if (root != null) {
    		System.out.print(root.val + ", ");
		}
    	
    	while (!deque.isEmpty()) {
    		TreeNode node = deque.pollFirst();
    		if (node != null) {
    			deque.offerLast(node.left);
    			deque.offerLast(node.right);
    			if (node.left != null || node.right != null) {
    				if (node.left != null) {
        				System.out.print(node.left.val + ", ");
        			} else {
        				System.out.print("#, ");
    				}
        			
        			if (node.right != null) {
        				System.out.print(node.right.val + ", ");
        			} else {
        				System.out.print("#, ");
    				}
    			}
    			
    		}			
		}
    	System.out.println("]");
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n0 = 0;
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int n4 = 4;
		
		System.out.println("n0: 0");
		List<TreeNode> list0 = generateTrees(n0);
		for (TreeNode treeNode : list0) {
			printTree(treeNode);
		}
		
		System.out.println("n1: 1");
		List<TreeNode> list1 = generateTrees(n1);
		for (TreeNode treeNode : list1) {
			printTree(treeNode);
		}
		
		System.out.println("n2: 2");
		List<TreeNode> list2 = generateTrees(n2);
		for (TreeNode treeNode : list2) {
			printTree(treeNode);
		}
		
		System.out.println("n3: 3");
		List<TreeNode> list3 = generateTrees(n3);
		for (TreeNode treeNode : list3) {
			printTree(treeNode);
		}
		
		System.out.println("n4: 4");
		List<TreeNode> list4 = generateTrees(n4);
		for (TreeNode treeNode : list4) {
			printTree(treeNode);
		}
		
		/**
		 * n0: 0
		 * []
		 * n1: 1
		 * [1]
		 * n2: 2
		 * [1, #, 2]
		 * [2, 1, #]
		 * n3: 3
		 * [1, #, 2, #, 3]
		 * [1, #, 3, 2, #]
		 * [2, 1, 3, ]
		 * [3, 1, #, #, 2]
		 * [3, 2, #, 1, #]
		 * n4: 4
		 * [1, #, 2, #, 3, #, 4]
		 * [1, #, 2, #, 4, 3, #]
		 * [1, #, 3, 2, 4]
		 * [1, #, 4, 2, #, #, 3]
		 * [1, #, 4, 3, #, 2, #]
		 * [2, 1, 3, #, 4]
		 * [2, 1, 4, 3, #]
		 * [3, 1, 4, #, 2]
		 * [3, 2, 4, 1, #]
		 * [4, 1, #, #, 2, #, 3]
		 * [4, 1, #, #, 3, 2, #]
		 * [4, 2, #, 1, 3]
		 * [4, 3, #, 1, #, #, 2]
		 * [4, 3, #, 2, #, 1, #]
		 */
	}

}
