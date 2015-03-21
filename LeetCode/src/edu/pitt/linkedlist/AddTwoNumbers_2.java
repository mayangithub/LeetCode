/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Add Two Numbers #2 --- Accepted 390ms
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author yanma
 * @since 2015-03-21
 * @version 2015-03-21
 */
public class AddTwoNumbers_2 {
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
	
	/**
	 * Accepted 434ms
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	}
    	
        int carry = 0;
        ListNode lastListNode = null;
        lastListNode = new ListNode((l1.val + l2.val) % 10);
        carry = (l1.val + l2.val) / 10;
        ListNode temp = lastListNode;
        l1 = l1.next;
        l2 = l2.next;
        
        while (l1 != null && l2 != null) {
        	ListNode newNode = new ListNode((l1.val + l2.val + carry) % 10);
        	carry = (l1.val + l2.val + carry) / 10;
        	temp.next = newNode;
        	temp = newNode;
        	l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode nextListNode = (l1 == null) ? l2 : l1;
        while (nextListNode != null) {
        	ListNode newNode = new ListNode((nextListNode.val + carry) % 10);
        	carry = (nextListNode.val + carry) / 10;
        	temp.next = newNode;
        	temp = newNode;
        	nextListNode = nextListNode.next;
        }
        
        if (carry != 0) {
        	ListNode newNode = new ListNode(carry);
        	temp.next = newNode;
        }
        
        return lastListNode;
    }
    
    /**
     * Accepted 390ms
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        } else if (l2 == null) {
        	return l1;
        }
        
        int carry = 0;
        ListNode node = new ListNode((l1.val + l2.val) % 10);
        carry = (l1.val + l2.val) / 10;
        node.next = addTwoNumbersWithCarry(l1.next, l2.next, carry);
        
        return node;
    }
    
    public static ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
    	if (l1 == null && l2 == null) {
    		if (carry != 0) {
    			ListNode node = new ListNode(carry);
    			return node;
    		} else {
    			return null;
    		}
    	}
    	
    	if (l1 != null && l2 == null) {
    		ListNode node = new ListNode((l1.val + carry) % 10);
    		carry = (l1.val + carry) / 10;
    		node.next = addTwoNumbersWithCarry(l1.next, l2, carry);
    		return node;
    	} else if (l1 == null && l2 != null) {
    		ListNode node = new ListNode((l2.val + carry) % 10);
    		carry = (l2.val + carry) / 10;
    		node.next = addTwoNumbersWithCarry(l1, l2.next, carry);
    		return node;
    	}
    	
    	ListNode node = new ListNode((l1.val + l2.val + carry) % 10);
    	carry = (l1.val + l2.val + carry) / 10;
    	node.next = addTwoNumbersWithCarry(l1.next, l2.next, carry);
    	
    	return node;
    	
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(1);
		ListNode n9 = new ListNode(1);
		ListNode n10 = new ListNode(6);
		ListNode n11 = new ListNode(9);
		
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		
		n7.next = n8;
		n8.next = n9;
		n10.next = n11;
		
		ListNode temp = n1;
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		temp = n4;
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		temp = addTwoNumbers(n1, n4);
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		temp = n7;
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		temp = n10;
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		temp = addTwoNumbers(n7, n10);
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
		
		/**
		 * test case
		 * {5} + {5} = {0} {1}
		 */
		ListNode n12 = new ListNode(5);
		temp = addTwoNumbers(n12, n12);
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
		
	}

}
