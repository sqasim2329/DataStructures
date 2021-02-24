package com.data.graphs;

import java.util.LinkedList;
///https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
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
        boolean visisted[] = new boolean[6];
        
        System.out.println(g.countPaths(s,d,visisted));
	}

	private int countPaths(int s, int d, boolean visisted[]) {
		
		if(s==d)
				 return 1;
		visisted[s] = true;
		int count = 0;
		for(int j:adj[s]) {
			if(!visisted[j]) {
			
			count += countPaths(j,d,visisted);
			
			}
		}
		visisted[s]=false;
		return count;
		
	}
}
