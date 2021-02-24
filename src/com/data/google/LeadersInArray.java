package com.data.google;

import java.util.Stack;

public class LeadersInArray {
	public static void main(String args[]) {
	int arr[]= {7,4,5,7,3};
	Stack<Integer> stk=new Stack<>();
	for(int i=arr.length-1;i>=0;i--) {
		if(stk.isEmpty())
			stk.push(arr[i]);
		else
		{
			if(stk.peek() <= arr[i])
				stk.push(arr[i]);
		}
		
		}
	
	while(!stk.isEmpty()) {
		System.out.println(stk.pop());
	}
	}

}
