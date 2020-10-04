package com.data.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	
	int i;
	List<Integer> adj = new ArrayList<>();
	
	public GraphNode(int i, int j) {
		this.i = i;
		adj.add(j);
	}
	
	public GraphNode(int i) {
		this.i = i;
	}
	
	private void addEdge(int i, int j) {
		
	}

}
