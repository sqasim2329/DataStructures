package com.data.google;

public class FrogPositionAfterTseconds {
	
	 public double frogPosition(int n, int[][] edges, int t, int target) {
	        
	        LinkedList<Integer>[] g = new LinkedList[n+1];
	        boolean visited[] = new boolean[n+1];
	        double probability[] = new double[n+1];
	        for(int i=0;i<=n;i++)
	            g[i]=new LinkedList<Integer>();
	        
	        for(int[] edge:edges){
	            g[edge[0]].add(edge[1]);
	            g[edge[1]].add(edge[0]);
	        }
	            
	        
	        Queue<Integer> q = new LinkedList<>();
	        q.add(1);
	        probability[1]=1d;
	        visited[1]=true;
	        while(!q.isEmpty()){
	            int size = q.size();
	            if(t == 0){
	                break;
	            }
	            for(int i=0;i<size;i++){
	                Integer tmp = q.poll();
	                int m=0;
	                for(int adj:g[tmp]) if(!visited[adj]) m++;//find probability for unvisted only
	                for(int adj:g[tmp]){
	                    if(!visited[adj]){
	                    visited[adj]=true;
	                    probability[adj]=probability[tmp]/m;
	                    q.add(adj);    
	                    }   
	                }
	                if(m > 0) probability[tmp]=0;//frog don't stay vertex u, he keeps going to the next vertex
	            }
	            t--;
	        }
	        
	        return probability[target];
	    }

}
