package com.data.stack;

import java.util.Stack;

public class NextLargerElement {
	
	public static void main(String args[]) {
		int arr[] = {1,5,2,4};
		findNextLargerElement(arr);
		
	}

	private static void findNextLargerElement(int[] arr) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stk = new Stack<>();
		for(int i=0; i< arr.length ; i++) {
//			if(i >= arr.length )
//				break;
			int next = arr[i];
			while(!stk.isEmpty() && stk.peek() < next) {
					System.out.println(stk.peek()+" next greater element is :"+next);
					stk.pop();
			}
			stk.push(next);
		}
		
		while(!stk.isEmpty()) {
			System.out.println(stk.pop()+" next greater element is :-1");
		}
		
	}

}
;