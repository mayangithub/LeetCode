/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Swap Nodes in Pairs #24 --- Accepted 276ms
 *  Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed. 
 * @author yanma
 * @since 2015-05-06
 * @version 2015-05-06
 */
public class SwapNodesinPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode lead = new ListNode(-1);
        lead.next = head;
        ListNode tempLead = lead;
        ListNode first = head;
        ListNode second = head.next;
        
        while (second != null) {
        	first.next = second.next;
        	tempLead.next = second;
        	second.next = first;
        	tempLead = first;
        	first = first.next;
        	if (first == null) {
        		break;
        	}
        	second = first.next;
        }
        
        return lead.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
