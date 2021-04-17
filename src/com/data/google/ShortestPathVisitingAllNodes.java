package com.data.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {
	
	class Solution {
	    public int shortestPathLength(int[][] graph) {
	        int n = graph.length;
	        if(n == 0 || graph[0].length == 0)
	            return 0;
	        Queue<int[]> q = new LinkedList<>();
	        Set<String> seen = new HashSet<>();
	        int fullMask = (1 << n)-1;//n^2-1//everything will be one;
	        for(int i=0;i<n;i++){
	                q.add(new int[]{i,1<<i});
	                seen.add(formString(1,1<<i));
	        }
	        int steps = 1;        
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0;i<size;i++){
	                int[] curr = q.poll();
	                for(int adj:graph[curr[0]])//all adj nodes wrt to this index/vertex
	                {
	                    int mask = curr[1] | 1<<adj;
	                    if(mask == fullMask) return steps;
	                    String key = formString(adj,mask);
	                    if(!seen.add(key)) continue;
	                    q.add(new int[]{adj,mask});
	                }
	            }
	            steps++;
	        }
	        return -1;
	        
	    }
	    
	    private String formString(int vertex,int bitRep){
	        return vertex+"-"+bitRep;
	    }
	}
}
/*****
 * 
 * 
 *    eg--> 0-1-2
 *    full mask == 1<<3-1 == 0111
 * 	 q = 0,1 1,2 2,4| 1,3 2,2 0,3, 1,6| 0,7 
 *   0 pops
 *   	0001
 *      0010
 *      0011 --> 1, 3 not seen hence add to queue
 *   1 pops 
 *   	0010	   
 *      0010 --> 2
 *      0010   2,2 added into quue
 *      
 *      0010
 *      0001
 *      0011 -> 0,3 added into queu
 *      
 *    2 pops
 *      0100
 *      0010
 *      0110 -> 1,6 added to queu
 *------------------------------
 *    1 pops
 *     0011
 *     0001 -- 0, 3 already exists      
 *    2 pops
 *     0010
 *     0001 -> 1,3 already exist
 *    0 pops
 *     0011
 *     0001 -> 1,3 already exits
 *    1 pops
 *    0110
 *    0001 -> 0,7 added to queue 
 *    
 *    when 0,7 is poped that means we were able visit all nodes  in 2 steps 
 *           
 * ****/
