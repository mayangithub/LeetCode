/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Delete Node in a Linked List #237 --- Accepted 328ms
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * @author yanma
 * @since 2015-07-15
 * @version 2015-07-15
 */
public class DeleteNodeinaLinkedList_237 {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }

}
