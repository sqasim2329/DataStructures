package com.data.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
import sun.security.provider.certpath.Vertex;

//if independent node has tow childresn
//if visited time is <= low time of adj vertex
//https://www.geeksforgeeks.org/all-topological-sorts-of-a-directed-acyclic-graph/
public class ArticulationPoint<T> {
	
	public static void main(String args[]) {
		
		List<Graph> nodeList =  new ArrayList<>();
		Graph graph ;
		for(int i=1;i<9;i++) {
			graph = new Graph(i,false);
		}
        graph.addEdge(nodeList.get(1), nodeList.get(2));
        graph.addEdge(nodeList.get(2), nodeList.get(3));
        graph.addEdge(nodeList.get(1), nodeList.get(3));
        graph.addEdge(nodeList.get(1), nodeList.get(4));
        graph.addEdge(nodeList.get(4), nodeList.get(5));
        graph.addEdge(nodeList.get(5), nodeList.get(6));
        graph.addEdge(nodeList.get(6), nodeList.get(7));
        graph.addEdge(nodeList.get(7), nodeList.get(5));
        graph.addEdge(nodeList.get(6), nodeList.get(8));
	}

}
