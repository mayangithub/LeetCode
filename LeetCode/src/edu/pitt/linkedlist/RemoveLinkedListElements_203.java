/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Linked List Elements #203 --- Accepted 398ms 455ms
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5 
 * @author yanma
 * @since 2015-04-23
 * @version 2015-04-23
 */
public class RemoveLinkedListElements_203 {
	
	/**
	 * Accepted 398ms
	 * @param head
	 * @param val
	 * @return
	 */
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) {
            return head;
        } else if (head.next == null && head.val != val) {
            return head;
        }
        
        while (head != null && head.val == val) {
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        
        if (head != null) {
            ListNode left = head;
            ListNode right = head.next;
            while (right != null) {
                if (right.val == val) {
                    left.next = right.next;
                    right.next = null;
                    right = left.next;
                } else {
                    right = right.next;
                    left = left.next;
                }
            }
        }
        
        
        return head;
    }
    
    /**
     * Accepted 455ms
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        } else if (head.next == null && head.val != val) {
            return head;
        }
        
        while (head != null && head.val == val) {
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        
        if (head != null) {
            head.next = removeElements(head.next, val);
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
