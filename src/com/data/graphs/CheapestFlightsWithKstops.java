package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// at most K stops, hence  we have to stops processing once K becomes 0 for those flights
public class CheapestFlightsWithKstops {
	
	class Solution {
	    class Pair{
	        int indx;
	        int cost;
	        public Pair(int indx, int cost){
	            this.indx = indx;
	            this.cost = cost;
	        }
	    }
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
	        Map<Integer,List<Pair>> map = new HashMap<>();
	        for(int[] flight:flights){
	            map.putIfAbsent(flight[0],new ArrayList<>());
	            map.get(flight[0]).add(new Pair(flight[1],flight[2]));
	        }
	        pq.add(new int[]{src,0,K+1});//K+1 to include processing of teh src node
	        while(!pq.isEmpty()){
	                int[]node = pq.poll();
	                int stops = node[2];
	                if(node[0] == dst)
	                    return node[1];
	                if(stops==0) continue;
	                if(map.containsKey(node[0])){
	                    for(Pair adj:map.get(node[0])){
	                        pq.add(new int[]{adj.indx,adj.cost+node[1],stops-1});
	                    }    
	                }
	            }
	        return -1;
	    }
	}

}
