/**
 * 
 */
package edu.pitt.linkedlist;


/**
 * Remove Duplicates from Sorted List #83 --- accepted 235ms
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3. 
 * @author yanma
 * @since 2015-02-22
 * @version 2015-02-22
 *
 */
public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 思路：
         * 1. two pointers, nodeslow and nodefast, and a temp node to collect garbage 
         * 2. if nodefast.val = nodeslow.val, nodefast the next set to null, nodefast go to next node, 
         * 3. if nodefast.val != nodeslow.val, nodeslow.next = nodefast, nodeslow, nodefast go to next node
         * 4. if nodefast = null, nodeslow.next set to null
         */
    	
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode nodeslowListNode = head;
    	ListNode nodefastListNode = head.next;
    	ListNode nodeTemp;
    	
    	while (nodefastListNode != null) {
    		if (nodeslowListNode.val == nodefastListNode.val) {
    			nodeTemp = nodefastListNode;
    			nodefastListNode = nodeTemp.next;
    			nodeTemp.next = null;
    		} else {
    			nodeslowListNode.next = nodefastListNode;
    			nodeslowListNode = nodefastListNode;
    			nodefastListNode = nodeslowListNode.next;
    		}
    	}
    	
    	nodeslowListNode.next = null;
    	
    	return head;
    	
    }
}
