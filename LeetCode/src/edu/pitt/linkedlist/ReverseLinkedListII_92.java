/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reverse Linked List II #92 --- Accepted 288ms
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * @author Yan-PC
 * @since 2015-05-31
 * @version 2015-05-31
 */
public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n || m < 1) {
        	return head;
        }
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode end = dummy;
        ListNode pointer = dummy;
        int count = 0;
        while (pointer.next != null && count < m) {
			count++;
			if (count == m) {
				end = pointer;
			}
			pointer = pointer.next;
		}
        ListNode start = pointer;
        while (pointer != null && count < n) {
        	ListNode next = pointer.next;
        	head = (end.next == head)? next: head; // if m = 1
			end.next = next;
			pointer.next = next.next;
			next.next = start;
			start = next;
			count++;
		}
       
        return head;
    }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
