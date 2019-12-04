package com.data.stack;

import java.util.Stack;

public class IncreasingDecreasingSequence {
	
	
	public static void main(String args[]) {
		
	 String s = "DIDI";
	 printMinNumberFromSeq(s);
	}

	private static void printMinNumberFromSeq(String s) {
		// TODO Auto-generated method stub
		String result = "";
		Stack<Integer> stk = new Stack<>();
		for(int i = 0; i <= s.length() ; i++) {
			stk.push(i+1);
			if((i < s.length() && s.charAt(i)=='I' ) || i == s.length()) {
			while(!stk.isEmpty()) {
				result += stk.peek();
				stk.pop();
			 }
		   }
		}
		
		for(int i = 0 ; i <= s.length();i++) {
			System.out.println(result.charAt(i));
		}
		
		
	}

}
