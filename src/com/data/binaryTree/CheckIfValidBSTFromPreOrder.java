package com.data.binaryTree;

import java.util.Stack;

public class CheckIfValidBSTFromPreOrder {
	
	public static void main(String args[]) {
		int[] pre = new int[]{40, 30, 35, 80, 100,80};
		System.out.println(isValid(pre));
		
	}
	
	private static boolean isValid(int[] pre) {
		Stack<Integer> stk =  new Stack<>();
		int root = Integer.MIN_VALUE;
		for(int i:pre) {
			if(i < root) {
				return false;
			}
			
			while(!stk.isEmpty() && stk.peek() < i) {
				root = stk.pop();
			}
			stk.push(i);
		}
		
		return true;
	}

}
