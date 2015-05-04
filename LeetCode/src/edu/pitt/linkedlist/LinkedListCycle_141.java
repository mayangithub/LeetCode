/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Linked List Cycle #141 --- Accepted 351ms
 *  Given a linked list, determine if it has a cycle in it.
 * Follow up:
 *  Can you solve it without using extra space? 
 * @author yanma
 * @since 2015-05-03
 * @version 2015-05-03
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) {
        	return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next; // fast = head; also works
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		return true;
        	}
        }
        
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
