package com.data.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSRecursively {
	
	int v;
	LinkedList<Integer>[] g;
	boolean[] vis;
	
	public BFSRecursively(int v) {
		this.v=v;
		g= new LinkedList[v];
		vis= new boolean[v];
		for(int i=0;i<v;i++)
			g[i]=new LinkedList<>();
	}
	
	public static void main(String args[]) {
		BFSRecursively b= new BFSRecursively();
		
		b.BFSUtil();
	}

	private void BFSUtil() {
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<v;i++) {
			if(!vis[i])
				q.add(i);
				vis[i]=true;
				BFS(q);
		}
		
	}

	private void BFS(Queue<Integer> q) {
		int p=q.poll();
		System.out.println(p);
		for(int adj:g[p]) {
			if(!vis[adj]) {
			q.add(adj);
			vis[adj]=true;
			}
		}
		BFS(q);
	}

}
