/**
 * 
 */
package edu.pitt.linkedlist;

import edu.pitt.tree.TreeNode;

/**
 * Convert Sorted List to Binary Search Tree #109 --- Accepted 380ms
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author yanma
 * @since 2015-05-15
 * @version 2015-05-15
 */
public class ConvertSortedListtoBinarySearchTree_109 {
	private ListNode currNode;
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public TreeNode sortedListToBST(ListNode head) {
    	//find middle list element, make it root
    	//to left side, repeat; to right side, repeat
        if (head == null) {
        	return null;
        } else if (head.next == null) {
        	TreeNode node = new TreeNode(head.val);
        	return node;
        }
        
        int size = getSize(head);
        currNode = head;
        TreeNode rootNode = construct(size);
        return rootNode;
    }
    
    public int getSize(ListNode head) {
    	int size = 0;
    	while (head != null) {
    		size++;
    		head = head.next;
    	}
    	return size;
    }
    
    /**
     * 
     * @param size
     * @return
     */
    public TreeNode construct(int size) {
    	if (size <= 0) {
    		return null;
    	}
    	
    	TreeNode left = construct(size / 2);
    	// to list[0] node, as leftmost node, then, list[1] node as root, then list[2] node as right
    	// then currNode to list[3], as root, next three nodes as right branch
    	// then currNode to list[7] as root, next seven nodes as right branch
    	// then currNode to list[14] as root......
    	TreeNode root = new TreeNode(currNode.val);
    	currNode = currNode.next;
    	TreeNode right = construct(size - 1 - size / 2); //size left
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		
		node1.next = node2;
		
		
		
	}

}
