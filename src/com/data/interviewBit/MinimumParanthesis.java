package com.data.interviewBit;

import java.util.Stack;

//https://www.interviewbit.com/problems/minimum-parantheses/
public class MinimumParanthesis {
	
	public class Solution {
	    public int solve(String A) {
	        Stack<Character> stk = new Stack<>();
	        for(char c:A.toCharArray()){
	            if(c == '(')
	                stk.push(c);
	            else
	                {
	                    if(!stk.isEmpty() && stk.peek()=='(')
	                        stk.pop();
	                    else
	                        stk.push(')');
	                }
	        }
	        return stk.size();
	      
	    }
	    
	}
	
	public int solve(String A) {
	       int open = 0;
	       int balance  = 0;
	       int extra = 0;
	       for(char c:A.toCharArray()){
	           if(c == '(')
	           {
	               open++;
	               balance++;
	           }else{
	               if(balance == 0)
	                    extra++;
	                else    
	                    balance--;
	           }
	       }
	       
	       return (balance)+extra;
	      
	    }


}
