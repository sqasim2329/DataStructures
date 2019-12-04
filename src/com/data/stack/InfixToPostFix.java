package com.data.stack;

import java.util.Stack;

public class InfixToPostFix {
	
	static int Prec(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
		}
	public static void main(String args[]) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp));
	}
	private static String infixToPostfix(String exp) {
			Stack<Character> stk = new Stack<>();
			String result = "";
			
			for(int i=0; i < exp.length();i++) {
				char c= exp.charAt(i);
				if(Character.isLetterOrDigit(c)) {
					result +=c;
				}
				else if(c=='(') {
					stk.push(c);
				}
				else if(c == ')') {
					while(!stk.isEmpty() && stk.peek()!='(') {
						result+=stk.pop();
					}
					if(stk.isEmpty()) 
						return "invalid expression";
					else
						stk.pop();
					
				}
				else  {
					while(!stk.isEmpty() && Prec(c) <= Prec(stk.peek())){
						result += stk.pop();
					}
					stk.push(c);
				}
			}
				while(!stk.isEmpty()) {
					result += stk.pop();
				}
			return result;
			}
	}




