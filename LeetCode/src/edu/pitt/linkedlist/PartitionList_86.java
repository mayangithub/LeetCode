package edu.pitt.linkedlist;

/**
 * Partition List #86 --- Accepted 316ms
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * @author Yan-PC
 * @since 2015-05-30
 * @version 2015-05-30
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode less = new ListNode(-1);
        less.next = head;
        if (head.val < x) {
        	less = head; //first node is less than x
        } else { // find the first node less than x, make it less node
        	 while (head.next != null && head.next.val >= x) {
				head = head.next;
			}
	        if (head.next == null) {
	        	return less.next;
	        }
	        ListNode temp = less.next;
	        less.next = head.next;
	        less = less.next;
	        head.next = less.next;
	        less.next = temp;
	        head = less;
        }
        
        while (less.next != null && less.next.val < x) {
			less = less.next;
		} // find the first node larger than x
        
        ListNode pointer = less;
        while (pointer.next != null) {
			if (pointer.next.val >= x) {
				pointer = pointer.next;
			} else {
				ListNode temp = less.next;
				less.next = pointer.next;
				less = less.next;
				pointer.next = less.next;
				less.next = temp;
			}
		}
        
        return head;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
