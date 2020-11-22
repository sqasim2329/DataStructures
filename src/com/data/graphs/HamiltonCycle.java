package com.data.graphs;

import java.util.Arrays;

public class HamiltonCycle {
	
	public void hamCycle(int[][] g) {
		int path[]= new int[g.length];
		Arrays.fill(path, -1);
		path[0]=0;
		if(backTrack(path,g,1))
			System.out.println(path);
		else
			System.out.println("No Solution exists");
	}

	private boolean backTrack(int[] path, int[][] g, int pos) {
		
		if(pos == g.length) {
			if(g[path[pos-1]][path[0]]==1)
				return true;
			else
				return false;
		}
		
		
		
		for(int v=1;v<g.length;v++) {
			if(isSafe(v,path,pos,g)) { 
				path[pos]=v;
				if(backTrack(path,g,pos+1))
					return true;
				else
					path[pos]=-1;
			}	
		}
		
		return false;
	}

	private boolean isSafe(int v, int[] path, int pos, int[][] g) {
		if(g[path[pos-1]][v]==0)
			return false;
		for(int i=0;i<pos;i++) {
			if(path[i]==v)
				return false;
		}
		
		return true;
	}

}
/*
 * 
 * 
 * 		[0][1][2][3][4]
 * 		check at each i starting from 1 if there is no duplicate before and also there is 
 * 		a edge from pos-1 to pos in path
 * 
 * 
 */
