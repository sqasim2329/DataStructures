package com.data.google.microsoft;

public class EvaluateReversePolishNotation {
	
	class Solution {
	    public int evalRPN(String[] tokens) {
	        Stack<Integer> stk = new Stack<>();
	        for(String token:tokens){
	            if(isOperatorMatch(token)){
	                int second = stk.pop();
	                int first = stk.pop();
	                int val = appliedOperation(first,second,token);
	                stk.push(val);
	            }else{
	                stk.push(Integer.parseInt(token));
	            }
	        }
	        return stk.peek();
	    }
	    

	private int appliedOperation(int first,int second, String token){
	    switch(token){
	        case "+" : return first+second;
	        case "-" : return first-second;
	        case "/" : return first/second;
	        case "*" : return first*second;
	        default : return 1;    
	    }
	}
	    
	    private boolean isOperatorMatch(String token){
	        return token.equals("+") ||
	                token.equals("-") ||
	                token.equals("/") || 
	                token.equals("*");
	    }

	}

}
