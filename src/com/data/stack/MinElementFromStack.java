package com.data.stack;

public class MinElementFromStack {
	
	public static void main(String args[]) {
		
//		MinStack stk = new MinStack();
		MinStackWithConstantEnqueueDequeue stk =new MinStackWithConstantEnqueueDequeue();
		stk.push(2);
		stk.push(3); 
		System.out.println(stk.pop());
		System.out.println(stk.getMin());
		stk.push(1);
		stk.push(10);
		System.out.println(stk.getMin());
		stk.push(0);
		System.out.println(stk.getMin());
		stk.pop();
		System.out.println(stk.getMin());
	}

}

