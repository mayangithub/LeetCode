/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Nth Node From End of List #19 
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass. 
 * 
 * @author yanma
 * @since 2015-02-22
 * @version 2015-02-22
 */
public class RemoveNthNodeFromEndOfList_19 {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        /**
         * --- accepted 241ms
         * 思路1：
         * 1. find out the length of list
         * 2. find the node before nth from the end
         * 3. set its next link
         * 4. set the nth from the end next link
         * ***********
         * 1. delete the only element in the list
         */
    	if (head == null || n == 0) {
    		return head;
    	}
    	
    	int length = 0;
    	ListNode node = head;
    	while (node != null) {
    		length++;
    		node = node.next;
    	}
    	
    	if (n == length) {
    		ListNode temp = head;
    		head = head.next;
    		temp.next = null;
    	} else {
    		for (int i = 0; i < length - n; i++) {
	    		if (i == 0) {
	    			node = head;
	    		} else {
	    			node = node.next;
	    		}
	    	}
	    	
	    	ListNode next = node.next;
	    	node.next = next.next;
	    	next.next = null;
    	}
    	
    	return head;
    	
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
    	/**
    	 * 思路：--- accepted 238ms
    	 * 1. two pointers, i and j
    	 * 2. j is faster than i, j go first, go to the nth from the head 0
    	 * 3. i then start, when j at the end, i is the n+1th from the end
    	 * 4. set i next and i+1 next
    	 * ** in this way, just need to go one pass of the list
    	 */
    	if (head == null || n == 0) {
    		return head;
    	}
    	
    	int j = 0;
    	ListNode nodej = head;
    	while (j < n) {
    		j++;
    		nodej = nodej.next;
    	}
    	
    	if (nodej == null) {
    		ListNode temp = head;
        	head = head.next;
        	temp.next = null;
        	return head;
    	}
    	
    	ListNode nodei = head;
    	while (nodej.next != null) {
    		nodei = nodei.next;
    		nodej = nodej.next;
    	}
    	
    	ListNode temp = nodei.next;
    	nodei.next = temp.next;
    	temp.next = null;
    	
    	return head;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
