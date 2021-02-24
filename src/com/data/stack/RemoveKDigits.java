package com.data.stack;

public class RemoveKDigits {
	
	class Solution {
	    public String removeKdigits(String num, int k) {
	        
	        Stack<Integer> stk = new Stack<>();
	        for(char c:num.toCharArray()){
	            while(!stk.isEmpty() && k>0 && stk.peek()>(c-'0')){
	                stk.pop();
	                k--;
	            }
	            stk.push(c-'0');
	        }
	        
	        while(!stk.isEmpty() && k>0)
	        {
	            stk.pop();
	            k--;
	        }   
	        
	        
	        StringBuilder sb = new StringBuilder();
	        while(!stk.isEmpty()){
	            sb.insert(0,stk.pop());
	        }
	        
	        
	        
	        while(sb.length()> 1 && sb.charAt(0)=='0')
	            sb.deleteCharAt(0);
	        
	        if(sb.length()==0)
	            return "0";
	        return sb.toString();
	    }
	}







}
