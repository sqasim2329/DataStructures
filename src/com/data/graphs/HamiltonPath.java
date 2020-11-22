package com.data.graphs;
//https://practice.geeksforgeeks.org/problems/hamiltonian-path/0
import java.util.LinkedList;

public class HamiltonPath {
	LinkedList<Integer> [] g;
	
	public HamiltonPath(int v) {
		g= new LinkedList[v];
		for(int i=0;i<v;i++) {
			g[i]= new LinkedList<>();
		}
	}
	
	private void addEdge(int i,int j) {
		g[i].add(j);
	}
	
	public boolean hamiltonpath(boolean[] vis,int c,int n,int i) {
		
		if(c==n)
			return true;
		
		vis[i] = true;
		for(int adj:g[i]) {
			if(!vis[adj]) {
				if(hamiltonpath(vis,c+1,n,adj))
					return true;
			}
		}
		vis[i]=false;
		return false;
		
	}
	
	public static void main(String args[]) {
		int v=7;
		HamiltonPath h= new HamiltonPath(v);
//		h.addEdge(0, 1);
//		h.addEdge(1, 2);
//		h.addEdge(2, 3);
//		h.addEdge(1, 3);
		
//		h.addEdge(0, 1);
//		h.addEdge(1, 2);
//		h.addEdge(1, 3);
		
		h.addEdge(0, 1);
		h.addEdge(0, 2);
		h.addEdge(1, 2);
		h.addEdge(2, 3);
		h.addEdge(3, 4);
		h.addEdge(4, 5);
		h.addEdge(4, 6);
		h.addEdge(5, 6);
		
		
		boolean vis[]= new boolean[v];
		System.out.println(h.hamiltonpath(vis, 1, v, 0));
		
	}

}
//Hamilton path is a path that visits each vertext in a directed/ undirected graph only once
//backTrack for one node only once