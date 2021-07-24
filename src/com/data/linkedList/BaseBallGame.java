 6b45package com.data.linkedList;

public class BaseBallGame {
	
	class Solution {
	    public int calPoints(String[] ops) {
	        
	        Stack<Integer> stk = new Stack<>();
	        for(String s:ops){
	            
	            if(s.equals("D")){
	                int val = stk.peek()*2;
	                stk.push(val);
	            }else if(s.equals("C")){
	                stk.pop();
	            }else if(s.equals("+")){
	                int second = stk.pop();
	                int first = stk.pop();
	                stk.push(first);
	                stk.push(second);
	                stk.push(first+second);
	                
	            }else{
	                int sign = 1;
	                if(s.charAt(0)=='-'){
	                    sign=-1;
	                    stk.push(Integer.valueOf(s.substring(1))*sign);
	                }else{
	                    stk.push(Integer.valueOf(s.substring(0)));
	                }
	            }
	            
	            
	        }
	        int sum=0;
	        while(!stk.isEmpty()){
	            sum+=stk.pop();
	        }
	        
	        return sum;
	        
	    }
	}

}
