/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II #113 --- Accepted 410ms
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *  For example:
 *  Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \    / \
 *      7    2  5   1
 *      
 * 	return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 * 
 * @author yanma
 * @since 2015-05-12
 * @version 2015-05-12
 */
public class PathSumII_113 {
	
	/**
	 * Accepted 410ms
	 * @param root
	 * @param sum
	 * @return
	 * Note: 
	 * negative node value and negative sum
	 */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        java.util.List<List<Integer>> list = new java.util.ArrayList<List<Integer>>();
        if (root == null) {
        	return list;
        } else if (root.left == null && root.right == null && sum != root.val) {
        	return list;
        } else if (root.left == null && root.right == null && sum == root.val) {
        	List<Integer> innerList = new ArrayList<>();
        	innerList.add(root.val);
        	list.add(innerList);
        	return list;
        }
        
    	java.util.List<Integer> leftList = new java.util.ArrayList<Integer>();
    	leftList.add(root.val);
    	java.util.List<Integer> rightList = new java.util.ArrayList<Integer>();
    	rightList.add(root.val);
    	list = calculatePathSum(root.left, sum, list, leftList, root.val);
    	list = calculatePathSum(root.right, sum, list, rightList, root.val);
        
        return list;
    }
    
    public static java.util.List<List<Integer>> calculatePathSum(TreeNode root, int sum, java.util.List<List<Integer>> list, 
    		java.util.List<Integer> pathList, int pathSum) {
    	if (root == null) {
    		return list;
    	} else if (root.left == null && root.right == null && root.val + pathSum != sum) {
    		return list;
    	} else if (root.left == null && root.right == null && root.val + pathSum == sum) {
    		java.util.List<Integer> path = new java.util.ArrayList<Integer>();
    		path.addAll(pathList);
    		path.add(root.val);
			list.add(path);
			return list;
		}
    	
		pathSum += root.val;
		java.util.List<Integer> leftpath = new java.util.ArrayList<Integer>();
		leftpath.addAll(pathList);
		leftpath.add(root.val);
		list = calculatePathSum(root.left, sum, list, leftpath, pathSum);
		
		java.util.List<Integer> rightpath = new java.util.ArrayList<Integer>();
		rightpath.addAll(pathList);
		rightpath.add(root.val);
		list = calculatePathSum(root.right, sum, list, rightpath, pathSum);
		
    	return list;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node0 = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
		
		java.util.List<List<Integer>> list = pathSum(node0, 10);
		System.out.println(list.size());
		
		for (List<Integer> innerList : list) {
			System.out.print("[");
			for (Integer integer : innerList) {
				System.out.print(integer + ", ");
			}
			System.out.println("]");
		}
		
		TreeNode node00 = new TreeNode(-2);
		TreeNode node01 = new TreeNode(-3);
		node00.right = node01;
		java.util.List<List<Integer>> list1 = pathSum(node00, -5);
		System.out.println(list1.size());
		
		for (List<Integer> innerList : list1) {
			System.out.print("[");
			for (Integer integer : innerList) {
				System.out.print(integer + ", ");
			}
			System.out.println("]");
		}
		
		TreeNode node000 = new TreeNode(1);
		TreeNode node001 = new TreeNode(-2);
		TreeNode node002 = new TreeNode(-3);
		TreeNode node003 = new TreeNode(1);
		TreeNode node004 = new TreeNode(3);
		TreeNode node005 = new TreeNode(-2);
		TreeNode node006 = new TreeNode(-1);
		
		node000.left = node001;
		node000.right = node002;
		node001.left = node003;
		node001.right = node004;
		node002.left = node005;
		node003.left = node006;
		
		java.util.List<List<Integer>> list2 = pathSum(node000, 2);
		System.out.println(list2.size());
		
		for (List<Integer> innerList : list2) {
			System.out.print("[");
			for (Integer integer : innerList) {
				System.out.print(integer + ", ");
			}
			System.out.println("]");
		}
	}

}
