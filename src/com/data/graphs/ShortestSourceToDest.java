package com.data.graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
//check https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/--may be not correct
public class ShortestSourceToDest {
	
	class Point {
		int row;
		int col;
		int dist;
		public Point(int row,int col ,int dist) {
			this.row = row;
			this.col = col;
			this.dist =dist;
		}
	}
	
	public int shortestPath(int[][] nums,int []source,int [] dest) {
		int row = nums.length;
		int col = nums[0].length;
		boolean[][]vis = new boolean[row][col];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(source[0],source[1],0));
		int distance = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Point src = q.poll();
			int r =src.row;
			int c =src.col;
			vis[r][c] = true;
			if(r == dest[0] && c ==dest[1]) {
				return src.dist;
			}
			if(isSafe(r+1,c,nums) && !vis[r+1][c] && nums[r+1][c]==1) {
				q.add(new Point(r+1,c,src.dist+1));
			}
			
			if(isSafe(r-1,c,nums) && !vis[r-1][c] && nums[r-1][c]==1) {
				q.add(new Point(r-1,c,src.dist+1));
			}
			
			if(isSafe(r,c+1,nums) && !vis[r][c+1] && nums[r][c+1]==1) {
				q.add(new Point(r,c+1,src.dist+1));
			}
			
			if(isSafe(r,c-1,nums) && !vis[r][c-1] && nums[r][c-1]==1) {
				q.add(new Point(r,c-1,src.dist+1));
			}
		}
		
		return -1;
	}
	
	private boolean isSafe(int r, int c, int[][] nums) {
		
		return r>=0 && r<nums.length && c>=0 && c<=nums[r].length;
	}

	public static void main(String args[]) {
		int arr[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }}; 
		int src[]= {0,0};
		int dest[]= {3,4};
		 ShortestSourceToDest g= new ShortestSourceToDest();
		 System.out.println(g.shortestPath(arr, src, dest));
	}

}
