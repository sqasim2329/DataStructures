package com.data.graphs;

import java.util.Iterator;
import java.util.LinkedList;
//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
//check wether the paths are correct, count is correct
public class CountPossiblePathBwTwovertices{
	int vertices;
	LinkedList<Integer> adj[];
	
	public CountPossiblePathBwTwovertices(int v) {
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
		CountPossiblePathBwTwovertices g = new CountPossiblePathBwTwovertices(5); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(1, 3); 
        g.addEdge(2, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 4); 
        
        int s=0;
        int d=3;
        int count=0;
        StringBuffer sb = new StringBuffer();
        count = g.countPaths(s,d,sb);
        System.out.println(count);
	}

	

	private int countPaths(int s, int d, StringBuffer sb) {
		if(s==d) {
			sb.append(s);
			System.out.println(sb);
		return 1;
		}
		
		Iterator<Integer> iterator = adj[s].iterator();
		int count =0;
		sb.append(s);
		while(iterator.hasNext()) {
			int adj = iterator.next();
			
			count += countPaths(adj,d,sb);
			
		}
		sb.deleteCharAt(sb.toString().length()-1);
		return count;
		
		
		
	}

}
