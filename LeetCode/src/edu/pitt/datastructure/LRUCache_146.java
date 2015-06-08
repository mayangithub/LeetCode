/**
 * 
 */
package edu.pitt.datastructure;

/**
 * LRU Cache #146 --- Accepted 456ms
 *  Design and implement a data structure for Least Recently Used (LRU) cache. 
 *  It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 *  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 * @author yanma
 * @since 2015-06-08
 * @version 2015-06-08
 */
public class LRUCache_146 {
	private class Node {
		int key;
		int value;
		Node next;
		Node pre;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.pre = null;
			this.next = null;
		}
	}
	
    int capacity;
    Node headNode;
    Node tailNode;
    java.util.HashMap<Integer, Node> hashMap;
    
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.headNode = new Node(-1, -1);
        this.tailNode = new Node(-1, -1);
        headNode.next = tailNode;
        tailNode.pre = headNode;
        this.hashMap = new java.util.HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
        	return -1;
        }
        
        Node node = hashMap.get(key);
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = tailNode.pre;
        node.next = tailNode;
        node.pre.next = node;
        tailNode.pre = node;
        
        return node.value;
    }
    
    public void set(int key, int value) {
        if (hashMap.containsKey(key)) {
        	hashMap.get(key).value = value;
        	get(key);
        	return;
        }
        
        if (hashMap.size() == capacity) {
        	int temp = headNode.next.key;
        	headNode.next = headNode.next.next;
        	headNode.next.pre = headNode;
        	hashMap.remove(temp);
        }
        
    	Node newnode = new Node(key, value);
    	newnode.pre = tailNode.pre;
    	newnode.next = tailNode;
    	newnode.pre.next = newnode;
    	tailNode.pre = newnode;
    	hashMap.put(key, newnode);
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
