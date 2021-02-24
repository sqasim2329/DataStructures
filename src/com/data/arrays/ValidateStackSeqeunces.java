package com.data.arrays;

import java.util.Stack;

public class ValidateStackSeqeunces {
	
	class Solution {
	    public boolean validateStackSequences(int[] pushed, int[] popped) {
	        
	        Stack<Integer> stk = new Stack<>();
	        int j=0;
	        for(int x:pushed){
	            stk.push(x);
	            while(!stk.isEmpty() && stk.peek()==popped[j]){
	                stk.pop();
	                j++;
	            }
	        }
	        
	        return j==pushed.length;
	        
	    }
	}

}
