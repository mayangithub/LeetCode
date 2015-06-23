/**
 * 
 */
package edu.pitt.divideandconquer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.pitt.linkedlist.ListNode;

/**
 * Merge k Sorted Lists #23 --- Accepted 348ms
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 * @author yanma
 * @since 2015-06-22
 * @version 2015-06-22
 */
public class MergekSortedLists_23 {
	private Comparator<ListNode> comparator = new Comparator<ListNode>() {
		public int compare(ListNode leftnode, ListNode rightnode) {
			if (leftnode == null) {
				return 1; //put right
			} else if (rightnode == null) {
				return -1; // put left
			} else {
				return leftnode.val - rightnode.val; // > 0 right, < 0 left
			}
		}
	};
	
	
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
        	return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, comparator);
        for (ListNode listNode : lists) { // listNode can be null, when lists = [[]]
			if (listNode != null) {
				heap.add(listNode);
			}
		}
        
        ListNode dummyListNode = new ListNode(0);
        ListNode tail = dummyListNode;
        while (!heap.isEmpty()) {
			ListNode topNode = heap.poll();
			tail.next = topNode;
			tail = topNode;
			if (topNode.next != null) {
				heap.add(topNode.next); // auto sort when adding
			}
		}
        
        return dummyListNode.next;
    }
}
