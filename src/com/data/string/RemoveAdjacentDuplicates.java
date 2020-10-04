package com.data.string;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
	
	static class Node{
		char ch;
		int c;
		
		public Node(char ch,int c) {
			this.ch =ch;
			this.c=c;
		}
		
		
	}
	
	public static void main(String args[]) {
		String str="geeksforgeeg";
		Stack<Node> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		for(char ch: str.toCharArray()) {
			if(!stack.isEmpty() && stack.peek().ch==ch) {
				stack.peek().c++;
			}else {
				stack.push(new Node(ch,1));
			}
			if(stack.peek().c>1) stack.pop();
			
		}
		
		while(!stack.isEmpty()) {
			
			sb.append(stack.pop().ch);
			
		}
		                                                   
		System.out.print(sb.reverse());
	}

}
