package edu.pitt.linkedlist;

/**
 * Merge Two Sorted Lists #21 --- accepted 280ms
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author yanma
 * @since 2015-02-22
 * @version 2015-02-22
 */
public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 思路：
         * 1. if l1.val < l2.val, return l1 finally, otherwise, return l2
         * 2. while node1 != null and node2 != null, 
         * 3. if node1 < node2, tail.next = node1, node1 = node1.next
         * 4. if node2 < node1, tail.next = node2, node2 = node2.next
         * 5. if node1 == null, tail.next = node2
         * 6. if node2 == null, tail.next = node1.
         */
    	if (l2 == null) {
    		return l1;
    	} else if (l1 == null) {
    		return l2;
    	}
    	
    	ListNode node1 = l1;
    	ListNode node2 = l2;
    	
    	ListNode temp1;
    	ListNode temp2;
    	
    	ListNode taiListNode;
    	if (node1.val < node2.val) {
    		taiListNode = node1;
    		node1 = node1.next;
    	} else {
			taiListNode = node2;
			node2 = node2.next;
		}
    	
    	while (node1 != null && node2 != null) {
    		if (node1.val < node2.val) {
    			temp1 = node1;
    			taiListNode.next = temp1;
    			node1 = temp1.next;
    			temp1.next = null;
    			taiListNode = temp1;
    		} else {
    			temp2 = node2;
    			taiListNode.next = temp2;
    			node2 = temp2.next;
    			temp2.next = null;
    			taiListNode = temp2;
    		}
    	}
    	
    	if (node1 == null) {
    		taiListNode.next = node2;
    	} else {
    		taiListNode.next = node1;
    	}
    	
    	
    	return (l1.val < l2.val)? l1 : l2;
    	
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
