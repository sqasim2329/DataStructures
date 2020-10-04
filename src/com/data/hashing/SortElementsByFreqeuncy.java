package com.data.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortElementsByFreqeuncy {
	
	public static void main(String args[]) {
		int a[]={2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		Map<Integer,Integer> freqMap = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			freqMap.put(a[i],freqMap.getOrDefault(a[i],0)+1);
		}
		StringBuffer result = new StringBuffer(); 
		freqMap.entrySet().stream().sorted(Map.Entry.<Integer,Integer> comparingByValue().reversed())
		.forEach(e -> { 
            int key = e.getKey(); 
            int val = e.getValue(); 
            for (int i = 0; i < val; i++) { 
                result.append(key + " "); 
            } 
        });
		System.out.println(result);
		
		
		Map<Character, Integer> counts = new HashMap<>();
	    for (char c : s.toCharArray()) {
	        counts.put(c, counts.getOrDefault(c, 0) + 1);
	    }
	            
	    // Make a list of the keys, sorted by frequency.
	    List<Character> characters = new ArrayList<>(counts.keySet());        
	    Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

	    // Convert the counts into a string with a sb.
	    StringBuilder sb = new StringBuilder();
	    for (char c : characters) {
	        int copies = counts.get(c);
	        for (int i = 0; i < copies; i++) {
	            sb.append(c);
	        }
	    }
	    return sb.toString();
	}
	//bucket sort
	class Solution {
	    public String frequencySort(String s) {
	        if(s == null || s.length()==0) return s;
	        
	        Map<Character,Integer> freqMap = new HashMap<>();
	        for(char c:s.toCharArray()){
	            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
	        }
	        
	        int maxValue = Collections.max(freqMap.values());
	        List<List<Character>> bucket = new ArrayList<>();
	        for(int i=0;i<=maxValue;i++){
	            bucket.add(new LinkedList<Character>());
	        }
	        
	        for(char c:freqMap.keySet()){
	            int freq=freqMap.get(c);
	            for(int i=0;i<freq;i++)
	            bucket.get(freq).add(c);
	        }
	        StringBuilder sb= new StringBuilder();
	        for(int i=bucket.size()-1;i>=1;i--){
	            for(char c:bucket.get(i)){
	                sb.append(c);
	            }
	        }
	        
	        return sb.toString();
	        
	    }
	}

}
