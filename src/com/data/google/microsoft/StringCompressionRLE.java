package com.data.google.microsoft;
//https://leetcode.com/problems/string-compression/
public class StringCompressionRLE {
	
	class Solution {
	    public int compress(char[] chars) {
	        
	        StringBuilder sb = new StringBuilder("");
	        int count =1;
	        char c=chars[0];
	        for(int i=1;i<chars.length;i++){
	            if(c == chars[i]){
	                count++;
	            }else{
	                sb.append(c);
	                if(count > 1)
	                    sb.append(count);
	                c = chars[i];
	                count =1;
	            }
	        }
	        
	        sb.append(c);
	        if(count > 1)
	            sb.append(count);
	        int index =0;
	        for(char ch:sb.toString().toCharArray()){
	            chars[index++]=ch;
	        }
	        
	        return index;
	       
	    }
	}




}
