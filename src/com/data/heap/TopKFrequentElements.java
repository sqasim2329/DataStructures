package com.data.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopKFrequentElements {
	
public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int max = Collections.max(freq.values());
        Set<Integer>[] res = new HashSet[max+1];
        List<Integer> result = new ArrayList<>();
        
        for(int i=1;i<=max;i++){
            res[i]=new HashSet<>();
        }
        
        for(int i:nums){
            int count = freq.get(i);
            res[count].add(i);
        }
        
        
        while(k>0 && max>0){
        	if(res[max].size()>0) {
            result.addAll(res[max]);
            k = k-result.size();
        	}
        	max--;
        }
        
       return result.stream().mapToInt(i->i).toArray();
        
        
        
    }

	public static void main(String args[]) {
	int nums[]= {5,3,1,1,1,3,73,1};
	int k=2;
	topKFrequent(nums,k);
	}

}
