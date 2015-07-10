/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Palindrome Linked List #234 --- Accepted 468ms
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @author yanma
 * @since 2015-07-09
 * @version 2015-07-09
 */
public class PalindromeLinkedList_234 {
	
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        second = reverse(second);
        
        while (head != null && second != null) {
            if (head.val == second.val) {
                head = head.next;
                second = second.next;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            dummy.next = head;
            tail = head;
            head = next;
        }
        
        return dummy.next;
    }

}
