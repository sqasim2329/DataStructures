package com.data.graphs;

import java.util.LinkedList;

public class CountPossiblePathBWForUndirectedGraph {
	
	int vertices;
	LinkedList<Integer> adj[];
	
	
	public CountPossiblePathBWForUndirectedGraph(int v) {
		this.vertices = v;
		adj= new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
			
		}
	}
	
	public void addedge(int i,int j) {
		adj[i].add(j);
		adj[j].add(i);
	}
	
	public static void main(String args[]) {
		CountPossiblePathBWForUndirectedGraph g = new CountPossiblePathBWForUndirectedGraph(6); 
		g.addedge(0,1);
		g.addedge(2,3);
		g.addedge(3,4);
		g.addedge(4,5);
		g.addedge(1,2);
		g.addedge(1,4);
		g.addedge(3,0);
        
        int s=0;
        int d=4;
        int count=0;
        StringBuffer sb = new StringBuffer();
        boolean visisted[] = new boolean[6];
        count = g.countPaths(s,d,count,visisted);
        System.out.println(count);
	}

	private int countPaths(int s, int d, int count, boolean visisted[]) {
		visisted[s]=true;
		if(s==d)
				 count++;
		else
		for(int j:adj[s]) {
			if(!visisted[j]) {
			
			count = countPaths(j,d,count,visisted);
			
			}
		}
		visisted[s]=false;
		return count;
		
	}
}
