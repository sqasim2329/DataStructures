package com.data.stack;

import java.util.Stack;

public class paranthesisChecker {
	
	public static void main(String args[]) {
		String exp = "[()]{}{[()()]()}";
		System.out.println(checkBalancedOrnot(exp));
	}

	private static String checkBalancedOrnot(String exp) {
		Stack<Character> stk = new Stack<>();
		String balancedOrNot = "B";
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if(c == '{' || c == '[' || c == '(') {
				stk.push(c);
			} else if(c == ']') {
				balancedOrNot = checkForOpenBraces(balancedOrNot,stk,'[');
				
			}
			else if(c == ')') {
				balancedOrNot = checkForOpenBraces(balancedOrNot,stk,'(');
			}
			else if(c == '}') {
				balancedOrNot = checkForOpenBraces(balancedOrNot,stk,'{');
			}
			if(balancedOrNot.equals("NB")) {
				break;
			}
		}
		return balancedOrNot;
		
	}

	private static String checkForOpenBraces(String balancedOrNot,Stack<Character> stk, char c) {
		while(!stk.isEmpty() && stk.peek()!=c) {
			stk.pop();
		}
		if(!stk.isEmpty() && stk.peek()!=c ) {
			balancedOrNot =  "NB";
		}else if(stk.isEmpty()){
			balancedOrNot = "NB";
		}else {
			stk.pop();
		}
		return balancedOrNot;
	}

}
