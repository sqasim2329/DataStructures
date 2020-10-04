package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	    Graph[] gph;
	    class Graph implements Comparable<Graph>{
	        Map<Integer,Integer> map = new HashMap<>();
	        List<Integer> neighbours = new ArrayList<>();
	        int distance;
	        int index;
	        public Graph(int index,int distance){
	            this.index = index;
	            this.distance = distance;
	        }
	        
	        public int compareTo(Graph other){
	            return this.distance - other.distance;
	        }
	    }
	    public int networkDelayTime(int[][] times, int N, int K) {
	        int max = 0;
	        gph=new Graph[N+1];
	        for(int i=1;i<=N;i++){
	            gph[i]=new Graph(i,Integer.MAX_VALUE);
	        }
	        for(int i=1;i<=times.length;i++){
	            gph[times[i-1][0]].map.put(times[i-1][1],times[i-1][2]);
	            gph[times[i-1][0]].neighbours.add(times[i-1][1]);
	            gph[times[i-1][0]].distance = Integer.MAX_VALUE;
	            }
	        
	        PriorityQueue<Graph> q = new PriorityQueue<>();
	        gph[K].distance = 0;
	        for(int i=1;i<=N;i++){
	            q.add(gph[i]);
	        }
	        
	        while(!q.isEmpty()){
	            Graph p = q.poll();
	            for(int adj:p.neighbours){
	                Graph n = gph[adj];
	                if(q.contains(n)){
	                    if(n.distance > p.distance + p.map.get(n.index)){
	                    	q.remove(n);
	                        n.distance = p.distance + p.map.get(n.index);
	                        q.add(n);
	                    }
	                        
	                }
	            }
	            
	        }
	        
	        for(Graph g:gph){
                max = Math.max(g.distance,max);
            }
	        
	        return max==Integer.MAX_VALUE?-1:max;
	    }
	    
	    
	    public static void main(String args[]) {
	    	int[][] times = {{1,2,1},{2,3,2},{1,3,4}};
	    	int N=3;
	    	int k=1;
	    	NetworkDelayTime g = new NetworkDelayTime();
	    	System.out.println(g.networkDelayTime(times,N,k));
	    }
	}
