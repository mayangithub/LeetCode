/**
 * 
 */
package edu.pitt.datastructure;

import java.util.Stack;

/**
 * Implement Queue using Stacks #232 --- Accpeted 248ms
 *  Implement the following operations of a queue using stacks.
 *     push(x) -- Push element x to the back of queue.
 *     pop() -- Removes the element from in front of queue.
 *     peek() -- Get the front element.
 *     empty() -- Return whether the queue is empty.
 * Notes:
    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. 
    You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * @author yanma
 * @since 2015-07-09
 * @version 2015-07-09
 */
public class ImplementQueueusingStacks_232 {
	
	class MyQueue {
	    Stack<Integer> prep = new Stack<Integer>();
	    Stack<Integer> queue = new Stack<Integer>();
	     
	    
	    // Push element x to the back of queue.
	    public void push(int x) {
	        while (!queue.isEmpty()) {
	            prep.push(queue.pop());
	        }
	        
	        prep.push(x);
	        
	        while (!prep.isEmpty()) {
	            queue.push(prep.pop());
	        }
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if (!queue.isEmpty()) {
	            queue.pop();
	        }
	    }

	    // Get the front element.
	    public int peek() {
	        if (!queue.isEmpty()) {
	            return queue.peek();
	        }
	        return -1;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return queue.size() == 0;
	    }
	}

}
