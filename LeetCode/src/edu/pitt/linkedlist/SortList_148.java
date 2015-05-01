/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Sort List #148 --- accepted 347ms
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author yanma
 * @since 2015-04-30
 * @version 2015-04-30
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        
        head = mergeSort(left, right);
        
        return head;
    }
    
    public ListNode findMid(ListNode head) {
    	if (head == null || head.next == null) {
    		return null;
    	}
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
    
    public ListNode mergeSort(ListNode left, ListNode right) {
    	ListNode first = new ListNode(-1);
    	ListNode curr = first;
    	while (left != null && right != null) {
    		if (left.val <= right.val) {
    			curr.next = left;
    			left = left.next;
    		} else {
    			curr.next = right;
    			right = right.next;
    		}
    		curr = curr.next;
    	}
    	
    	if (left == null) {
    		curr.next = right;
    	} else {
    		curr.next = left;
    	}
    	
    	return first.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
