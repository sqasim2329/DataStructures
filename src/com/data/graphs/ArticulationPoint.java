package com.data.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//if independent node has tow childresn
//if visited time is <= low time of adj vertex
//https://www.geeksforgeeks.org/all-topological-sorts-of-a-directed-acyclic-graph/
public class ArticulationPoint {
	static int time =0;
	
	private static List<Integer> articulationPoint(LinkedList<Integer>[] g){
		Set<Integer> visited = new HashSet<>();
		Map<Integer,Integer> visistedTimeMap  = new HashMap<>();
		Map<Integer,Integer> parentMap  = new HashMap<>();
		Map<Integer,Integer> lowTimeMap  = new HashMap<>();
		List<Integer> articulationPoints = new ArrayList<>();
		dfs(visited,visistedTimeMap,parentMap,lowTimeMap,0,articulationPoints,g);
		return articulationPoints;
	}

	private  static void dfs(Set<Integer> visited, Map<Integer, Integer> visistedTimeMap, Map<Integer, Integer> parentMap,
			Map<Integer, Integer> lowTimeMap, int vertex, List<Integer> articulationPoints,LinkedList<Integer>[] g) {
		visited.add(vertex);
		boolean isArticulationPoint=false;
		int child =0;
		visistedTimeMap.put(vertex,time);
		lowTimeMap.put(vertex,time);
		time++;
		for(int adj:g[vertex]) {
			if(parentMap.get(vertex)==adj) {
				continue;
			}
			if(!visited.contains(adj)) {
				child++;
				parentMap.put(adj, vertex);
				dfs(visited,visistedTimeMap,parentMap,lowTimeMap,adj,articulationPoints,g);
				if(visistedTimeMap.get(vertex) <= lowTimeMap.get(adj)) 
					isArticulationPoint=true;
				else
					lowTimeMap.put(vertex,Math.min(lowTimeMap.get(adj), lowTimeMap.get(vertex)));
			}else {
				lowTimeMap.put(vertex,Math.min(lowTimeMap.get(adj), lowTimeMap.get(vertex)));
			}
		}
		
		if((parentMap.get(vertex)!=null && isArticulationPoint)||(parentMap.get(vertex)==null && child>=2)) {
			articulationPoints.add(vertex);
		}
		
	}
	
	public void addEdge(int i,int j,LinkedList<Integer>[] g) {
		g[i].add(j);
		g[j].add(i);
	}
	
	public static void main(String args) {
		ArticulationPoint graph = new ArticulationPoint();
		LinkedList<Integer>[] g = new LinkedList[8];
        graph.addEdge(1, 2,g);
        graph.addEdge(2, 3,g);
        graph.addEdge(1, 3,g);
        graph.addEdge(1, 4,g);
        graph.addEdge(4, 5,g);
        graph.addEdge(5, 6,g);
        graph.addEdge(6, 7,g);
        graph.addEdge(7, 5,g);
        graph.addEdge(6, 8,g);
        System.out.println(articulationPoint(g));
		
	}

	

}
