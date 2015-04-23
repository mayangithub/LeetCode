/**
 * 
 */
package edu.pitt.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View #199 --- Accepted 265ms
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *   
 * You should return [1, 3, 4]. 
 * @author yanma
 * @since 2015-04-23
 * @version 2015-04-23
 */
public class BinaryTreeRightSideView_199 {
	
	/**
	 * Accepted 265ms
	 * @param root
	 * @return
	 */
	public static List<Integer> rightSideView(TreeNode root) {
    	List<Integer> resultList = new ArrayList<Integer>();
        if (root == null) {
        	return resultList;
        } else if (root.left == null && root.right == null) {
        	resultList.add(root.val);
        	return resultList;
        }
                
        return rightSideView(root, resultList);
        
        
    }
    
    public static List<Integer> rightSideView(TreeNode root, List<Integer> nodeList) {
    	List<Integer> resultList = new ArrayList<Integer>();
    	resultList.addAll(nodeList);

    	if (root == null) {
        	return resultList;
        } else if (root.left == null && root.right == null) {
        	resultList.add(root.val);
        	return resultList;
        } else {
        	resultList.add(root.val);
        	List<Integer> leftList = rightSideView(root.left, resultList);
        	List<Integer> rightList = rightSideView(root.right, resultList);

        	if (leftList.size() > rightList.size()) {
        	    for (int i = rightList.size(); i < leftList.size(); i++) {
        	        rightList.add(leftList.get(i));
        	    }
        	    
        		return rightList;
        	} else {
        		return rightList;
        	}
        }    	
    	
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		
		root1.left = root2;
		root1.right = root3;
		root2.right = root5;
		root3.right = root4;
		root5.left = root6;
		
		for (Integer integer: rightSideView(root1)) {
			System.out.println(integer + " ");
		}
	}

}
