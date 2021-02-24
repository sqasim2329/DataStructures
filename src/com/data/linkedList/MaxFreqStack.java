package com.data.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {
	
	class FreqStack {
	    
	    Map<Integer,Integer> freqMap;
	    Map<Integer, Stack<Integer>> freqStack;
	    int maxFreq = 0;

	    public FreqStack() {
	        freqMap = new HashMap<>();
	        freqStack = new HashMap<>();
	    }
	    
	    public void push(int x) {
	        
	        freqMap.put(x,freqMap.getOrDefault(x,0)+1);
	        int freq = freqMap.get(x);
	        maxFreq = Math.max(maxFreq,freq);
	        freqStack.putIfAbsent(freq,new Stack<>());
	        freqStack.get(freq).push(x);
	    }
	    
	    public int pop() {
	        int x = freqStack.get(maxFreq).pop();
	        if(freqStack.get(maxFreq).isEmpty())
	            maxFreq--;
	        freqMap.put(x,freqMap.get(x)-1);
	        if(freqMap.get(x)==0)
	            freqMap.remove(x);
	        return x;
	        
	    }
	}

	/**
	 * Your FreqStack object will be instantiated and called as such:
	 * FreqStack obj = new FreqStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 */

}
