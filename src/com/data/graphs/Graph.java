package com.data.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	
	private List<Graph> neighbors = new ArrayList<Graph>();
	private boolean isVisited = false;
	int index;
	private boolean isDirected ;
	
	public Graph(int i, boolean isDirected) {
		this.index = i;
		this.isDirected =isDirected;
	}

	public void addEdge(Graph a, Graph b) {
		
		if(!isDirected) {
		a.neighbors.add(b);
		b.neighbors.add(a);
		}else{
			a.neighbors.add(b);
		}
	}
	
	
	
	
	

}
