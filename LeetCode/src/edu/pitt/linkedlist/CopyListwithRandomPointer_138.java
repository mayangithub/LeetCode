/**
 * 
 */
package edu.pitt.linkedlist;

/**
 * Copy List with Random Pointer #138 --- Accepted 380ms
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list. 
 * @author yanma
 * @since 2015-06-10
 * @version 2015-06-10
 */
public class CopyListwithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        if (head.next == null && head.random == null) return new RandomListNode(head.label);
        java.util.HashMap<RandomListNode, RandomListNode> map = new java.util.HashMap<RandomListNode, RandomListNode>();
        RandomListNode newNode = head;
        while (newNode != null) {
			map.put(newNode, new RandomListNode(newNode.label));
			newNode = newNode.next;
		}
        
        newNode = head;
        while (newNode != null) {
        	if (newNode.next != null) {
        		map.get(newNode).next = map.get(newNode.next);
        	}
        	
			if (newNode.random != null) {
				if (map.containsKey(newNode.random)) {
					map.get(newNode).random = map.get(newNode.random);
				} else {
					map.put(newNode.random, new RandomListNode(newNode.random.label));
				}
			}
			newNode = newNode.next;
		}
        
        return map.get(head);
    }
}
