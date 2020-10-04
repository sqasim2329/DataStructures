package com.data.graphs;

import java.util.LinkedList;
//https://www.cnblogs.com/lz87/p/10354361.html
//Max path value in directed graph
public class MaxPathValueInDirectedGraph {
	
	LinkedList<Integer>[] g;
	int v;
	String s;
	
	public MaxPathValueInDirectedGraph(int v, String s) {
		this.v=v;
		this.s= s;
		g= new LinkedList[v];
		for(int i=0;i<v;i++) {
			g[i]= new LinkedList<Integer>();
		}
	}
	
	private void addEdge(int i, int j) {
		g[i].add(j);
	}
	
	
	private Integer findMaxPath() {
		boolean []vis= new boolean[v];
		char word[]= new char[26];
		for(int i=0;i<v;i++)
		if(!vis[i])
			if(!dfsUtil(i,vis,word)) {
				return null;
			}
		
		int max=0;
		for(char j:s.toCharArray()) {
			if(word[j-'A']>max) {
				max = word[j-'A'];
			}
		}
		
		return max;
	}
	
	private boolean dfsUtil(int i, boolean[] vis, char[] word) {
		char letter = s.charAt(i);
		word[letter-'A']++;
		vis[i]=true;
		for(int adj:g[i]) {
			if(!vis[adj]) {
				if(!dfsUtil(adj,vis,word))
					return false;
			}
				else {// else is required since if there exits a cycle
						return false;
				}
		}
		return true;
		
	}

	public static void main(String args[]) {
		String s="ABACA";
//		s="A";
//		s="AB";
		MaxPathValueInDirectedGraph m = new MaxPathValueInDirectedGraph(5,s);
		int[][] arr={{0, 1},{0, 2},{2, 3},{3, 4}};
//		int [][]arr = {{0, 0}};
//		int [][]arr = {{0, 1},{1,0}};
		for(int i=0;i<arr.length;i++) {
			m.addEdge(arr[i][0], arr[i][1]);
		}
		System.out.println(m.findMaxPath());
		}
	}


