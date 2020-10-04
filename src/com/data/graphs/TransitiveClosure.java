package com.data.graphs;

import java.util.ArrayList;
import java.util.List;
//o(v2)  , https://www.geeksforgeeks.org/transitive-closure-of-a-graph/--o(v3)
public class TransitiveClosure {
	
	static List<GraphNode> list =  new ArrayList<>();
	public static void main(String args[]) {
		GraphNode node1 = new GraphNode(0,1);
		node1.adj.add(2);
		GraphNode node3 = new GraphNode(1,2);
		GraphNode node4 = new GraphNode(2,0);
		node4.adj.add(3);
		GraphNode node6 = new GraphNode(3,3);
		
		list.add(node1);
		list.add(node3);
		list.add(node4);
		list.add(node6);
		
		int[][] tg = new int[4][4];
		transitiveClosure(tg);
		for(int i=0;i<tg.length;i++) {
			System.out.println();
			for(int j=0;j<tg[i].length;j++)
				System.out.print(tg[i][j]);
		}
	}

	private static void transitiveClosure(int[][] tg) {
		for(int i=0;i<tg.length;i++) {
			DFS(i,i,tg);
		}
		
	}

	private static void DFS(int i, int j, int[][] tg) {
		tg[i][j]=1;
		
		List<Integer> adj = list.get(j).adj;
		for(int v:adj) {
			if(tg[i][v]==0)
				DFS(i,v,tg);
		}
		
	}

}
