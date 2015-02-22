/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Intersection of Two Linked Lists #160  ---- accepted 366ms
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                   ↘
 *                     c1 → c2 → c3
 *                   ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * 		If the two linked lists have no intersection at all, return null.
 * 		The linked lists must retain their original structure after the function returns.
 * 		You may assume there are no cycles anywhere in the entire linked structure.
 * 		Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author yanma
 * @since 2015-02-22
 * @version 2015-02-22
 *
 */
public class IntersectionOfTwoLinkedLists_160 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 思路：
         * 1. first, find out the length of list A and list B
         * 2. let the longer list go first, until the rest part has the same length
         * 3. then go in each list, find the node is the same node, return the node
         * **************
         * 1. when two list have same length
         */
		if (headA == headB) {
			return headA;
		} else if (headA == null || headB == null) {
			return null;
		} 
		
		int lengthA = 1;
		ListNode nextA = headA.next;
		while (nextA != null) {
			lengthA++ ;
			nextA = nextA.next;
		}
		
		int lengthB = 1;
		ListNode nextB = headB.next;
		while (nextB != null) {
			lengthB++;
			nextB = nextB.next;
		}
		
		if (lengthA > lengthB) {
			for (int i = 1; i <= lengthA - lengthB; i++) {
				if (i == 1) {
					nextA = headA.next;
				} else {
					nextA = nextA.next;
				}
			}
			nextB = headB;
		} else if (lengthB > lengthA) {
			for (int i = 1; i <= lengthB - lengthA; i++) {
				if (i == 1) {
					nextB = headB.next;
				} else {
					nextB = nextB.next;
				}
			}
			nextA = headA;
		} else {
			nextA = headA;
			nextB = headB;
		}
		
		while (nextA != null) {
			if (nextA.val != nextB.val) {
				nextA = nextA.next;
				nextB = nextB.next;
			} else {
				return nextA;
			}
			
		}
		
		return null;
		
    }

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
