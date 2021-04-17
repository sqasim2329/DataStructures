package com.data.graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedgraph {
	
	private int v;
	private List<Integer> adj[];
	
	public DetectCycleInUndirectedgraph(int i) {
		v=i;
		adj = new ArrayList[v];
		for(int j=0;j<v;j++) {
			adj[j]= new ArrayList<>();
		}
		
	}
	
	public boolean isCyclic(int i, boolean[] vis, int parent) {
		vis[i]= true;
		for(int j:adj[i]) {
			if(!vis[j]) {
			if(isCyclic(j,vis,i)) {
					return true;
				}
			}
			
			else if(j!=parent)
				return true;
		}
		return false;
	}
	
	
	private boolean isCyclic() {
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				if(isCyclic(i,visited,-1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	void addEdge(int v,int w) { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
	public static void main(String args[]) {
		DetectCycleInUndirectedgraph g1 = new DetectCycleInUndirectedgraph(5);
		g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        System.out.println(g1.isCyclic());
        
        DetectCycleInUndirectedgraph g2 = new DetectCycleInUndirectedgraph(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        System.out.println(g2.isCyclic());
		
	}
	

}
