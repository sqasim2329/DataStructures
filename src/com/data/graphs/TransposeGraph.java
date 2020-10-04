package com.data.graphs;
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java
//clone a graph
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransposeGraph {
	int vertices;
	LinkedList<Integer> adj[];
	
	public TransposeGraph(int v) {
		this.vertices = v;
		adj= new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	public void addedge(int i,int j) {
		adj[i].add(j);
	}
	
	public static void main(String args[]) {
		TransposeGraph g= new TransposeGraph(5);
		g.addedge(0, 1); 
        g.addedge(0, 4); 
        g.addedge(0, 3); 
        g.addedge(2, 0); 
        g.addedge(3, 2); 
        g.addedge(4, 1); 
        g.addedge(4, 3);
        
        g.getTranspose();
	}

	private void getTranspose() {
		Map<Integer,List<Integer>> map= new HashMap<>();
		for(int i=0;i<5;i++) {
			for(int j:adj[i]) {
				if(map.containsKey(j)) {
					map.get(j).add(i);
				}else {
					List<Integer> ls= new ArrayList<>();
					ls.add(i);
					map.put(j,ls);
				}
			}
		}
		
		map.entrySet().stream().forEach(e-> System.out.print(e.getKey()+"-"+e.getValue().toString()));
		
	}
}
