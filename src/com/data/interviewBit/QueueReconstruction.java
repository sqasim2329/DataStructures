package com.data.interviewBit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {
	
	class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people,new Comparator<int[]>(){
	            
	            @Override
	            public int compare(int[] a, int[]b){
	                int comp = Integer.compare(a[0],b[0]);
	                if(comp == 0){
	                    comp = Integer.compare(a[1],b[1])*-1;
	                }
	                return comp*-1;
	            }
	        });
	        
	        List<int[]> result = new LinkedList<>();
	        for(int [] p:people){
	            result.add(p[1],p);
	        }
	        
	        return result.toArray(new int[result.size()][]);
	        
	    }
	}
}
