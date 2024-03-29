package com.data.stack;

import java.util.Stack;

public class QueuesUsingStack {
	
	Stack<Integer> stk1 = new Stack<>();
	Stack<Integer> stk2 = new Stack<>();
	int front=0;
	
	
	private void enqeue(int x) {
		stk1.push(x);
	}
	
	private int deqeue() {
		if(stk2.isEmpty()) {
			while(!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
		int value = stk2.pop();
		while(!stk2.isEmpty()) {
			stk1.push(stk2.pop());
		}
		
		return value;
	}
	
	
	public static void main(String args[]) {
		QueuesUsingStack q = new QueuesUsingStack();
		q.enqeue(2);
		q.enqeue(3);
		System.out.println(q.deqeue());
		q.enqeue(1);
		q.enqeue(0);
		q.enqeue(4);
		System.out.println(q.deqeue());
		System.out.println(q.deqeue());
		q.enqeue(6);
		System.out.println(q.deqeue());
		System.out.println(q.deqeue());
	}
	
	//better solution
	private void push(int x) {
		if(stk1.isEmpty())
			front = x;
		stk1.push(x);
	}
	
	private int pop() {
		if(stk2.isEmpty()) {
			while(!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
		return stk2.pop();
	}
	
	private int peek() {
		return stk2.isEmpty()?front:stk2.peek();
	}
	
	private boolean isEmpty() {
		return stk1.isEmpty() && stk2.isEmpty();
	}

}
