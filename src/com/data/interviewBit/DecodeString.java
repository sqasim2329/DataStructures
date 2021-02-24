package com.data.interviewBit;

public class DecodeString {
	
	class Solution {
	    public String decodeString(String s) {
	       Queue<Character> q = new LinkedList<>();
	        for(char c:s.toCharArray())
	            q.add(c);
	        return solve(q);
	    }
	    
	    private String solve(Queue<Character> q){
	        StringBuilder sb = new StringBuilder();
	        int num=0;
	        while(!q.isEmpty()){
	            char c = q.poll();
	            if(Character.isDigit(c)){
	                num=num*10+(c-'0');
	            }else if(c == '['){
	                String substring = solve(q);
	                for(int i=0;i<num;i++)
	                    sb.append(substring);
	                num=0;
	            }else if(c == ']'){
	                break;
	            }
	            else{
	                sb.append(c);
	            }
	        }
	        
	        return sb.toString();
	    }
	}

	    



}
