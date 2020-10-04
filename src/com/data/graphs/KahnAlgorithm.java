package com.data.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//o(V+E) o(V)
public class KahnAlgorithm {
	int v;
	
	LinkedList<Integer> [] g;
	
	public KahnAlgorithm(int v) {
		this.v =v;
		g= new LinkedList[v];
		for(int i=0;i<v;i++) {
			g[i]= new LinkedList<Integer>();
		}
	}
	
	private void addEdge(int i, int j) {
		g[i].add(j);
	}
	
	public static void main(String args[]) {
		KahnAlgorithm g = new KahnAlgorithm(6); 
		 g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0);
	        g.addEdge(0, 5);
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	        g.toposort();
	}

	private void toposort() {
		int[] indegree = new int[v];
		List<Integer> res = new LinkedList<>();
		//either use a queue or use the array
		for(int i=0;i<v;i++) {
			for(int adj:g[i])
				indegree[adj]++;
		}
		
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		int cnt=0;
		while(!q.isEmpty()) {
			int p =  q.poll();
			if(indegree[p]==0) {
				for(int adj:g[p]) {
					indegree[adj]--;
					if(indegree[adj]==0)
						q.add(adj);
				}
				res.add(p);
				 cnt++; ;
			}
		}
		if (cnt != v) { 
            System.out.println( 
                "There exists a cycle in the graph"); 
            return; 
        } 
		res.stream().forEach(System.out::print);
	}
		
		
	}
