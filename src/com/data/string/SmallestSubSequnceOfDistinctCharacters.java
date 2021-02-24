package com.data.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SmallestSubSequnceOfDistinctCharacters {
	
	class Solution {
	    public String removeDuplicateLetters(String s) {
	        
	        HashMap<Character,Integer> lastOccurrence = new HashMap<>();
	        Set<Character> seen = new HashSet<>();
	        for(int i=0;i<s.length();i++)
	            lastOccurrence.put(s.charAt(i),i);
	        
	        Stack<Character> stk = new Stack<>();
	        for(int i=0;i<s.length();i++){
	            if(!seen.contains(s.charAt(i))){
	                
	                while(!stk.isEmpty() && stk.peek() > s.charAt(i) && lastOccurrence.get(stk.peek()) > i){
	                    seen.remove(stk.pop());
	                }
	                stk.push(s.charAt(i));
	                seen.add(s.charAt(i));
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        while(!stk.isEmpty()){
	            sb.insert(0,stk.pop());
	        }
	        return sb.toString();
	    }
	}

}
