package com.data.stack;

import java.util.Stack;

public class MinStack {
	
	private int min = Integer.MAX_VALUE;
	Stack<Integer> stk = new Stack<>();
	
	public void push(int x) {
		stk.push(x);
		int minValue = findMin(stk,min);
		min = minValue;
	}
	
	public int pop() {
		if(stk.isEmpty()) {
			return -1;
		}
			int val = stk.pop();
			if(val == min) { // once I pop the min value i might still consider previous val as min , hence set min to max value;
				min = Integer.MAX_VALUE;
			}
			int minValue = findMin(stk,min);
			min = minValue;
			return val;
	}
	

	public int getMin() {
		if(stk.isEmpty()) {
			System.out.println("No Elements hence printing max value of Integer");
		}
		return min;
	}

	private int findMin(Stack<Integer> stk2, int min2) {
		if(stk2.isEmpty()) {
			return min2;
		}
		else{
				int val = stk2.pop();
				if(min2 > val) {
					min2=val;
				}
				min2 = findMin(stk2,min2);
				stk2.push(val);
			}
		return min2;
	}

}
