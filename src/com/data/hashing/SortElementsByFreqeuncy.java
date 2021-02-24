package com.data.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortElementsByFreqeuncy {
	
	class Pair implements Comparable<Pair>{
		
		int data;
		int freq;
		int index;
		@Override
		public int compareTo(Pair o) {
			int comp = Integer.compare(this.freq, o.freq);
			if(comp == 0)
				
		}
		
	}
	
	public static void main(String args[]) {
		int a[]={2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		Map<Integer,Integer> map = new HashMap<>();
		for(int n:a) {
			map.put(n,map.getOrDefault(null, 0)+1);
		}
		
		
		
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
