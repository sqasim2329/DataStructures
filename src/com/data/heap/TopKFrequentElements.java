package com.data.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	
public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int max = Collections.max(freq.values());
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<=max;i++){
            ls.add(new LinkedList<Integer>());
        }
        
        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
            int count = e.getValue();
            ls.get(count).add(e.getKey());
        }
        
        
        while(k>0){
            int size = ls.get(max).size();
            for(int i=0;i<size && k > 0 ; i++){
            result.add(ls.get(max).get(i));
            k --;
            }
        	max--;
        }
        
       return result.stream().mapToInt(i->i).toArray();
        
        
        
    
}

public List<String> topKFrequent(String[] words, int k) {
    
    Map<String,Integer> freq = new HashMap<>();
    for(String word:words){
        freq.put(word,freq.getOrDefault(word,0)+1);
    }
    
    List<List<String>> ls = new ArrayList<>();
    List<String> res = new ArrayList<>();
    int max = Collections.max(freq.values());
    for(int i = 0; i<=max;i++)
        ls.add(new LinkedList<>());
    
    for(Map.Entry<String,Integer> entry:freq.entrySet()){
        int level = entry.getValue();
        ls.get(level).add(entry.getKey());
    }
    
    while(k > 0){
        Collections.sort(ls.get(max));
        for(int i = 0;i< ls.get(max).size() && k>0; i++){
            res.add(ls.get(max).get(i));
            k--;
        }
        max--;
    }
    
    return res;
    
    
}


	public static void main(String args[]) {
	int nums[]= {5,3,1,1,1,3,73,1};
	int k=2;
	topKFrequent(nums,k);
	}

}
