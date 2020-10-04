package com.data.graphs;

import java.util.LinkedList;

public class CountTreesinForest {
	int vertices;
	LinkedList<Integer> adj[];
	
	public CountTreesinForest(int v) {
		this.vertices = v;
		adj= new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int i,int j) {
		adj[i].add(j);
	}
	
	
	public static void main(String args[]) {
		CountTreesinForest c= new CountTreesinForest(6);
//		c.addEdge(0, 1);  
//        c.addEdge(0, 2);  
//        c.addEdge(3, 4);
        
        c.addEdge(0, 1);  
        c.addEdge(1, 2);  
        c.addEdge(3, 4);
        c.addEdge(2, 5);
        c.addEdge(3, 5);
        c.addEdge(4, 5);
        
        System.out.println(c.countTree());
	}

	private int countTree() {
		
		int res= 0;
		boolean[] vis= new boolean[6];
		for(int i=0;i<5;i++ ) {
			if(!vis[i]) {
				DFSUtil(i,vis);
				res++;
			}
		}
		return res;
	}

	private void DFSUtil(int i, boolean[] vis) {
		vis[i]=true;
		for(int j:adj[i]) {
			if(!vis[j]) {
				DFSUtil(j,vis);
			}
		}
		
	}
}
