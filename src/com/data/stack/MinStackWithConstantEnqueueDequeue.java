package com.data.stack;

import java.util.Stack;

class Node{
	int val;
	int nextMin;
	
	public Node(int val, int nextMin) {
		this.val=val;
		this.nextMin =nextMin;
	}
}

public class MinStackWithConstantEnqueueDequeue {
	
	Stack<Node> s= new Stack<>();
	int min = Integer.MAX_VALUE;
	
	public void push(int val) {
		Node inp=new Node(val,min);
		if(min > val) {
			inp.nextMin = min;
			min = val;
			inp.val=val;
		}
		s.push(inp);
	}
	
	public int pop() {
		if(min == s.peek().val) {
			min = s.peek().nextMin;
		}
		return s.pop().val;
	}
	
	public int getMin() {
		return min;
	}

}
