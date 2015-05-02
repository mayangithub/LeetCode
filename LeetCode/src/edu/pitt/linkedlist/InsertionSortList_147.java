/**
 * 
 */
package edu.pitt.linkedlist;

import java.util.ArrayList;

/**
 * Insertion Sort List #147
 * Sort a linked list using insertion sort.
 * @author yanma
 * @since 2015-05-01
 * @version 2015-05-01
 */
public class InsertionSortList_147 {
	
	/**
	 * Accepted 351ms
	 * @param head
	 * @return
	 */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
        	 list.add(head.val);
        	 head = head.next;
        }
        
        int[] intarray = new int[list.size()];
        
        for (int i = 0; i < intarray.length; i++) {
        	intarray[i] = list.get(i);
        }
        
        java.util.Arrays.sort(intarray);
        
        ListNode start = new ListNode(0);
        ListNode cur = start;
        for (int i = 0; i < intarray.length; i++) {
        	ListNode node = new ListNode(intarray[i]);
        	cur.next = node;
        	cur = cur.next;
        }
        
        return start.next;
    }
    
    /**
     * Accepted 414ms
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode curr = head;
        
        while (curr != null) {
        	ListNode next = curr.next;
        	while (pre.next != null && pre.next.val < curr.val) {
        		pre = pre.next;
        	}
        	
        	curr.next = pre.next;
        	pre.next = curr;
        	pre = helper;
        	curr = next;
        }
        
        
        return helper.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
