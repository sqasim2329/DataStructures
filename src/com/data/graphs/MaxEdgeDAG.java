package com.data.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//O(v^2)+O(v+e)
///https://www.geeksforgeeks.org/check-if-a-graph-is-strongly-unilaterally-or-weakly-connected/
//https://www.geeksforgeeks.org/breadth-first-search-without-using-queue/?ref=leftbar-rightbar
//https://www.geeksforgeeks.org/minimum-cost-graph/?ref=leftbar-rightbar--sat
//Number of connected components in an undirected graph
//https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/--sat
//use set<Integer> [] g instead of 
// use adjacenyc matrix will reduce space
public class MaxEdgeDAG {
	int v;
	LinkedList<Integer>[] g ;
	boolean [][] ee;
	int [] indegree;
	
	public MaxEdgeDAG(int v) {
		this.v=v;
		ee = new boolean[v][v];
		indegree = new int[v];
		g=new LinkedList[v];
		for(int i=0;i<v;i++) {
			g[i]=new LinkedList<>();
		}
	}
	
	private void addEdge(int i, int j) {
		g[i].add(j);
		ee[i][j]=true;
		ee[j][i]=true;
	}
	
	
	private void dagUtil() {
		
		List<Integer> res= new LinkedList<>();
		for(int i=0;i<v;i++) {
			for(int adj:g[i]) {
				indegree[adj]++;
			}
		}
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<v;i++)
			if(indegree[i]==0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int p=q.poll();
			for(int adj:g[p]) {
				if(--indegree[adj]==0)
					q.add(adj);
			}
			res.add(p);
		}
		
		for(int i=0;i<res.size();i++)
			for(int j=i+1;j<res.size();j++)
				if((!ee[i][j] && !ee[i][j])&& i!=j) {
					ee[i][j]=true;
					ee[j][i]=true;
					System.out.println(i+"---"+j);
				}
	}
	
	public static void main(String args[]) {
		MaxEdgeDAG g= new MaxEdgeDAG(6); 
	    g.addEdge(5, 2); 
	    g.addEdge(5, 0); 
	    g.addEdge(4, 0); 
	    g.addEdge(4, 1); 
	    g.addEdge(2, 3); 
	    g.addEdge(3, 1);
	    g.dagUtil();
	}
	
	private void adjacencylistToMatrix(LinkedList<Integer> g, int[][] gmatrix.int v) {
		for(int i=0;i<v;i++) {
			for(int adj:g[i])
			gmatrix[i][adj]=1;
		}
	}
		

}