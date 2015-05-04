/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Linked List Cycle II #142 --- Accepted 288ms
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 *  Can you solve it without using extra space? 
 * @author yanma
 * @since 2015-05-03
 * @version 2015-05-03
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null) {
        	return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) { //sometimes exceed time limit
        	// (fast != null && fast.next != null) ---- also works
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if (slow == fast) {
        		slow = head;
        		while (slow != fast) {
        			slow = slow.next;
        			fast = fast.next;
        		}
        		return slow;
        	}
        }
        
        return null;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
