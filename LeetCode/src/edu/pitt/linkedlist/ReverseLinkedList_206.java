/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reverse Linked List #206 --- Accepted 305ms/291ms
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author yanma
 * @since 2015-05-04
 * @version 2015-05-05
 */
public class ReverseLinkedList_206 {
	/**
	 * Accepted 305ms iteratively
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode start = null;
        ListNode next = null;
        
        while (head != null) {
        	next = head.next;
        	head.next = start;
        	start = head;
        	head = next;
        }
        
        return start;
    }
    
    /**
     * recursively
     * Accepted 291ms
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode start = null;
        ListNode next = head.next;
        head.next = start;
        start = head;
        head = next;
        start = recursiveReverse(head, start);
        
        return start;
    }
    
    public ListNode recursiveReverse(ListNode head, ListNode newstart) {
    	if (head == null) {
    		return newstart;
    	} else {
    		ListNode next = head.next;
    		head.next = newstart;
    		newstart = head;
    		head = next;
    		newstart = recursiveReverse(head, newstart);
    	}
    	
    	return newstart;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
