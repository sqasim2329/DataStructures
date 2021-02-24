package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
	
	 public int totalFruit(int[] tree) {
	        
	        int l =0;
	        int r =0;
	        int count =0;
	        int len =0;
	        Map<Integer,Integer> map = new HashMap<>();
	        while(r < tree.length){
	            map.put(tree[r],map.getOrDefault(tree[r],0)+1);
	            if(map.get(tree[r])==1)
	                count++;
	            r++;
	            while(count > 2){
	                map.put(tree[l],map.get(tree[l])-1);
	                if(map.get(tree[l])==0)
	                    count--;
	                l++;
	            }
	            len = Math.max(len,r-l);
	        }
	        
	        return len;
	        
	    }

}
