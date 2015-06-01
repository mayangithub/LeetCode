/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Remove Duplicates from Sorted List II #82 --- Accepted 304ms
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author Yan-PC
 * @since 2015-05-31
 * @version 2015-05-31
 */
public class RemoveDuplicatesfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode pointer = head;
        ListNode next = pointer.next;
        ListNode end = new  ListNode(head.val - 1);
        end.next = head;
        
        while (pointer != null && next != null) {
			if (pointer.val != next.val) { // different
				if (pointer.next != next) { //has duplicates between pointer and next
					if (next.next != null &&next.val != next.next.val) { // consider next.next as well, next != next.next
						if (end.next == head) {//special situation for head value is duplicate
							head = next;
						}
						end.next = next;
						pointer = next;
						next = next.next;
					} else if (next.next != null && next.val == next.next.val) { // next == next.next, omit values between pointer and next, create new pointer
						pointer = next;
						next = pointer.next;
					} else { //next.next == null //after pointer and before next, all are same value, next is different
						if (end.next == head) {//special situation for head value is duplicate
							head = next;
						}
						end.next = next;
						break;
					}
				} else { //pointer.next == next // different adjacent  values
					end = pointer;
					pointer = next;
					next = pointer.next;
				}
			} else { // duplicate 
				next = next.next;
			}
		}
        
        if (pointer != null && next == null && pointer.next != next) {
        	if (end.next == head) {//special situation for head value is duplicate
        		head = null;
        	}
        	end.next = null;
        }
        
        return head;
    }
	
	/**
	 * Test cases:
	 * [1,2,3,3,4,4,5,null]
	 * [1,1,1,2,3,3,null]
	 * [1,1,1,2,2,3,null]
     * [1,1,null]
     * [1,2,3,3,null]
     * [1,2,3,3,4,4,5]
     * [1,2,3,3,4,null]
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
