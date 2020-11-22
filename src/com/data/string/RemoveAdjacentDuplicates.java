package com.data.string;

import java.util.Stack;
//The charAt method is O(1) . 
//The deleteCharAt method on StringBuilder and StringBuffer is O(N) on average, 
//assuming you are deleting a random character from an N character StringBuffer / StringBuilder . 
//(It has to move, on average, half of the remaining characters to fill up the "hole" left by the deleted character.
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
		String str="acaaabbbacdddd";
		Stack<Node> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		for(char ch: str.toCharArray()) {
			if(!stack.isEmpty() && stack.peek().ch!=ch && stack.peek().c>1) stack.pop();
			if(stack.isEmpty() || stack.peek().ch!=ch) {
				stack.push(new Node(ch,1));
			}else {
				stack.peek().c++;
			}
			
		}
		if(stack.isEmpty() && stack.peek().c>1) stack.pop();
		
		
		while(!stack.isEmpty()) {
			
			sb.append(stack.pop().ch);
			
		}
		                                                   
		System.out.print(sb.reverse());
	}
	
	//remove adjacent dulicates 2
		class Node1{
	        int freq;
	        char c;
	        public Node1(char c, int freq){
	            this.freq = freq;
	            this.c = c;
	        }
	    }
		public String removeDuplicates(String s, int k) {
	        if(s == null || s.length()==0 || (s!=null && s.trim().length()==0))
	            return s;
	        
	        Stack<Node1> stk = new Stack<>();
	        
	        for(char c:s.toCharArray()){
	            if(stk.isEmpty() || stk.peek().c!=c){
	                stk.push(new Node1(c,1));
	            }else{
	                stk.peek().freq++;
	                if(stk.peek().freq ==k)
	                    stk.pop();
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        while(!stk.isEmpty()){
	            Node1 n = stk.pop();
	            for(int i=0;i<n.freq;i++)
	            sb.append(n.c);
	        }
	        
	        return sb.reverse().toString();
	    }
}
