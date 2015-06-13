/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reverse Nodes in k-Group #25 --- Accepted 356ms
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5 
 * @author yanma
 * @since 2015-06-12
 * @version 2015-06-12
 */
public class ReverseNodesinkGroup_25 {
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
        	return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode pointer = head;
        int count = 1;
        while (pointer != null) {
			while (count < k) {
				if (pointer == null) {break;}
				pointer = pointer.next;
				count++;
			} 
			if (count == k) {
				if (pointer == null) {
					break;
				}
				pointer = pointer.next;
				ListNode newpre = helper(pre, pointer);
				if (pre == dummy) {
					dummy.next = pre.next;
				}
				pre = newpre;
				count = 1;
			}
		}
        
        return dummy.next;
    }
    
    
    public static ListNode helper(ListNode pre, ListNode tail) {
    	ListNode first = pre.next;
    	if (first == null || first.next == null) {
    		return null;
    	}
    	
    	while (first.next != tail) {
			ListNode next = first.next;
			first.next = next.next;
			next.next = pre.next;
			pre.next = next;
			
		}
    	
    	return first;
    }
    
    
    public static ListNode reverse(ListNode head) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode pointer = head;
    	while (pointer != null && pointer.next != null) {
			ListNode next = pointer.next;
			pointer.next = next.next;
			next.next = dummy.next;
			dummy.next = next;
		}
    	return dummy.next;
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		int k = 0;
		
		ListNode head = n1;
		head = reverseKGroup(head, k);
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
		
		
		
	}

}
