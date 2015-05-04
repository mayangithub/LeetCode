/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Reorder List #143 --- Accepted 407ms
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 * @author yanma
 * @since 2015-05-03
 * @version 2015-05-03
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
        	return;
        }
        ListNode stopNode = separateList(head);
        stopNode = reverseList(stopNode);
        mergeList(head, stopNode);
    }
    
    /**
     * to separate the second list
     * @param head
     * @return
     */
    public ListNode separateList(ListNode head) {
    	ListNode stopNode;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	stopNode = slow.next;
    	slow.next = null;
    	
    	return stopNode;
    }
    
    public ListNode reverseList(ListNode node) {
    	ListNode next = node.next;
    	node.next = null;
    	while (next != null) {
    		ListNode temp = next;
    		next = next.next;
    		temp.next = node;
    		node = temp;
    	}
    	
    	return node;
    }
    
    public void mergeList(ListNode firstHead, ListNode secondHead) {
    	ListNode l1node;
    	ListNode l2node;
    	
    	while (secondHead != null) {
    		l1node = firstHead.next;
    		l2node = secondHead.next;
    		
    		firstHead.next = secondHead;
    		firstHead = l1node;
    		
    		secondHead.next = l1node;
    		secondHead = l2node;
    	}
    	
    }
    
    
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
