package edu.pitt.stack;

import java.util.Stack;

/**
 * Min Stack #155 --- accepted 287ms
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author yanma
 * @since 2015-02-22
 * @version 2015-02-22
 */
public class MinStack_155 {
	static Stack<int[]> stack = new Stack<int[]>();
	 
	
	public static void push(int x) {
        int[] elementarray = new int[2];
        elementarray[0] = x;
        if (stack.isEmpty()) {
        	elementarray[1] = x;
        } else {
        	elementarray[1] = Math.min(x, getMin());
        }
        
        stack.push(elementarray);
        
    }

    public static void pop() {
    	if (stack.size() != 0) {
    		stack.pop();
    	}
    }

    public static int top() {
        if (!stack.isEmpty()) {
        	int[] result = new int[2];
        	result = stack.peek();
        	return result[0];
        }
        return 0;
    }

    public static int getMin() {
    	if (!stack.isEmpty()) {
        	int[] result = new int[2];
        	result = stack.peek();
        	return result[1];
        }
        return 0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(2);
		push(0);
		push(3);
		push(0);
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		
//		push(-1);
//		System.out.println(top());
//		System.out.println(getMin());
	}

}
