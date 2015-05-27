/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Rotate List #61 --- Accepted 320ms
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author yanma
 * @since 2015-05-27
 * @version 2015-05-27
 */
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
    	/**
    	 * Corner cases:
    	 * 1. {1, 2} 2
    	 * 2. {1, 2, 3} 2000000
    	 */
        if (head == null) {
        	return null;
        } 
    	int count = 0;
    	ListNode pListNode = head;
    	//find out list length
    	while (count < k) {
			pListNode = pListNode.next;
			count++;
			if (pListNode == null) {
				pListNode = head;
				k = k % count;
				count = 0;
			}
		}
    	
    	if (pListNode == head) {
    		return head;
    	}
    	
    	ListNode bListNode = head;
    	while (pListNode.next != null) {
			pListNode = pListNode.next;
			bListNode = bListNode.next;
		}
    	
    	ListNode resListNode = bListNode.next;
    	bListNode.next = null;
    	pListNode.next = head;
    	
        return resListNode;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
