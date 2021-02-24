package com.data.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://www.geeksforgeeks.org/dfs-n-ary-tree-acyclic-graph-represented-adjacency-list/
//https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
public class LevelFromSourceNode {
	
	LinkedList<Integer>[] g;
	
	class Graph{
		int index;
		int level;
		List<Graph> adj;
		boolean visited;
		
		
		
		public Graph(int i) {
			this.index = i;
			adj=new LinkedList<>();
			
		}

	}
	
	public LevelFromSourceNode(int v) {
		g = new LinkedList[v];
		for(int i=0;i<v;i++) {
			g[i] = new LinkedList<>();
		}
	}
	
	List<Graph> nodelist = new ArrayList<>();
	
	
	
//	public LevelFromSourceNode(int V) {
//		for(int i=0;i<V;i++)
//		nodelist.add(new Graph(i));
//	}

	public static void main(String args[]) {
		
		LevelFromSourceNode g = new LevelFromSourceNode(8);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(1,5);
		g.addEdge(2,6);
		g.addEdge(6,7);
		
		System.out.println(g.solve(0));
	}
	
	private void findlevel() {
		Queue<Graph> q= new LinkedList<>();
		Graph source = nodelist.get(0);
		source.level = 0;
		q.add(source);		
		while(!q.isEmpty()) {
			Graph g = q.poll();
			int lev =g.level;
			System.out.println(g.index+"-->"+g.level);
			for(Graph n:g.adj) {
				if(!n.visited) {
					n.level = lev+1; 
					q.add(n);
				}
			}
		}
		
	}



//	private void addEdge(int i,int j) {
//		Graph parent = nodelist.get(i);
//		Graph neighbour = nodelist.get(j);
//		parent.adj.add(neighbour);
//	}
	
	private void addEdge(int i, int j) {
		g[i].add(j);
	}
	
	
	private List<List<Integer>> solve(int s){
		List<List<Integer>> res = new ArrayList<>();
		dfs(res,s,0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int s, int level) {
		
		if(res.size() == level) {
			res.add(new LinkedList<Integer>());
		}
		
		List<Integer> ls = res.get(level);
		ls.add(s);
		for(int adj:g[s]) {
			dfs(res,adj,level+1);
		}
		
	}
	
	
	private void bfs(int s,LinkedList<Integer>[] g) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		List<List<Integer>> res = new ArrayList<>();
		boolean vis[]= new boolean[g.length];
		while(!q.isEmpty()) {
			int size = q.poll();
			List<Integer> ls = new ArrayList<>();
			for(int i=0;i<size;i++) {
				int v = q.poll();
				vis[v]=true;
				ls.add(v);
				for(int adj:g[v]) {
					if(!vis[adj])
						q.add(adj);
				}
			}
			res.add(ls);
			
		}
	}

}
