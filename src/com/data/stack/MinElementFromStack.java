package com.data.stack;

import java.util.Stack;

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
		System.out.println(stk.getMin(x));
		stk.pop();
		System.out.println(stk.getMin());
	}
	
	
	class MinNode{
	    int val;
	    int min;
	    
	    public MinNode(int val,int min){
	        this.val = val;
	        this.min = min;
	    }
	}

	class MinStack {

	    Stack<MinNode> stk = new Stack<>();
	    int min = Integer.MAX_VALUE;
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	        stk.push(new MinNode(x,min));//push current min onto stack 
	        if(x < min)
	            min = x;
	        
	    }
	    
	    public void pop() {
	        if(min == stk.peek().val){
	            min = stk.peek().min;// if pop is removing the min val, then previous os assigned to min
	        }
	        stk.pop();
	    }
	    
	    public int top() {
	        return stk.peek().val;
	    }
	    
	    public int getMin() {
	        return min;
	    }
	}

}

