package com.data.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://github.com/azl397985856/leetcode/blob/master/problems/1168.optimize-water-distribution-in-a-village-en.md
public class OptimizeWaterDsitribution {
	
	class Edge implements Comparable<Edge>{
		int index1;
		int index2;
		int weight;
		
		
		public Edge(int index1, int index2, int weight) {
			super();
			this.index1 = index1;
			this.index2 = index2;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	
	class DisjointSet{
		int [] representative;
		int [] rank;
		
		public DisjointSet(int v) {
			representative = new int[v+1];
			for(int i=0;i<=v;i++) {
				representative[i]=i;
			}
			rank = new int[v+1];
		}
		
		public boolean union(int i, int j) {
			int pi = findSet(i);
			int pj = findSet(j);
			
			if(pi==pj)
			return false;
			else {
				if(rank[pi]>=rank[pj]) {
					rank[pi]= rank[pi]==rank[pj]?rank[pi]+1:rank[pi];
					representative[pj]=pi;
				}else {
					representative[pi]=pj;
				}
				return true;
			}
		}

		private int findSet(int i) {
			if(i==representative[i])
			return i;
			representative[i]=findSet(representative[i]);
			return representative[i];
		}
	}
	
	
	public static void main(String args[]) {
		OptimizeWaterDsitribution opt= new OptimizeWaterDsitribution();
		int n = 5; 
		int[] wells = {1,2,2,3,2};
		int[][] pipes = {{1,2,1},{2,3,1},{4,5,7}};
		System.out.println(opt.findMinCost(n,wells,pipes));
	}


	private int findMinCost(int n, int[] wells, int[][] pipes) {
		List<Edge> edges = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			edges.add(new Edge(0,i,wells[i-1]));
		}
		
		for(int []p:pipes) {
			edges.add(new Edge(p[0],p[1],p[2]));
		}
		
		Collections.sort(edges);
		int cost = 0;
		DisjointSet d = new DisjointSet(n);
		for(Edge edge:edges) {
			if(d.union(edge.index1,edge.index2)) {
				cost+=edge.weight;
			}
		}
		return cost;
		
	}
	
	

}
