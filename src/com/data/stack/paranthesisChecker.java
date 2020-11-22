package com.data.stack;

import java.util.Stack;

public class paranthesisChecker {
	
	public static void main(String args[]) {
		String exp = "[()]{}{[()()]()}";
		System.out.println(checkBalancedOrnot(exp));
	}

	private static boolean checkBalancedOrnot(String s) {
		 Stack<Character> stk = new Stack<>();
	        boolean flag = false;
	        for(char c:s.toCharArray()){
	            if(c=='('||c=='{'||c=='['){
	                stk.push(c);
	            }else{
	                if(c==')')
	                    flag = checkForValidity('(',stk);
	                else if(c == ']')
	                    flag = checkForValidity('[',stk);
	                else if(c == '}')
	                    flag = checkForValidity('{',stk);
	                if(!flag)
	                    break;
	                
	            }
	        }
	        return flag&&stk.isEmpty();
		
	}

	private static boolean checkForValidity(char c,Stack<Character> stk) {
		if(!stk.isEmpty() && stk.peek()==c){
            stk.pop();
            return true;
        }
        return false;
	}

}
