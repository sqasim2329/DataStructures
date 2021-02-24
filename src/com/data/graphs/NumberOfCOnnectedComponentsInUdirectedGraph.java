package com.data.graphs;

import java.util.LinkedList;

public class NumberOfCOnnectedComponentsInUdirectedGraph {
	
public int countComponents(int n, int[][] edges) {
        
        LinkedList<Integer>[] g = new LinkedList[n];
        boolean vis[]= new boolean[n];
        for(int i=0;i<n;i++)
            g[i]= new LinkedList<>();
        for(int[] edge:edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
            dfs(i,g,vis);
            count++;
            }
        }
        return count;
        
    }
    
    private void dfs(int s,LinkedList<Integer>[] g, boolean []vis){
        vis[s]=true;
        for(int adj:g[s]){
            if(!vis[adj]){
                dfs(adj,g,vis);
            }
        }
        
    }

}
