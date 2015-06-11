/**
 * 
 */
package edu.pitt.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues #225 --- Accepted 136ms
 * Implement the following operations of a stack using queues.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
 * Notes:
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
    Depending on your language, queue may not be supported natively. 
    You may simulate a queue by using a list or deque (double-ended queue), 
    as long as you use only standard operations of a queue -- which means only push to back, pop from front, size, and is empty operations are valid.
 * @author yanma
 * @since 2015-06-10
 * @version 2015-06-10
 */
public class ImplementStackusingQueues_225 {
	class MyStack {
		Queue<Integer> queue;
		
		public MyStack() {
			// TODO Auto-generated constructor stub
			queue = new LinkedList<Integer>();
		}
		
	    // Push element x onto stack.
	    public void push(int x) {
	        queue.add(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        if (!empty()) {
	        	int size = queue.size();
	        	for (int i = 1; i < size; i++) {
					push(queue.poll().intValue());
				}
	        	queue.poll();
	        }
	    }

	    // Get the top element.
	    public int top() {
	        if (!empty()) {
	        	int size = queue.size();
	        	for (int i = 1; i < size; i++) {
	        		push(queue.poll().intValue());
				}
	        	size = queue.poll();
	        	push(size);
	        	return size;
	        } else {
	        	return -1;
	        }
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        if (queue.size() == 0) {
	        	return true;
	        }
	        return false;
	    }
	}
}
