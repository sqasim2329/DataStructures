package com.data.graphs;
//https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
//check https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/--may be not correct
public class ShortestSourceToDest {
	
	static class Point{
		int a;
		int b;
		
		public Point(int a, int b) {
			this.a=a;
			this.b=b;
		}
		//wtite equals method in interview
	}
	
	static int fstep=Integer.MAX_VALUE;
	
	public void findShortestPath(int [][]arr,Point source, Point dest ) {
		boolean visited[][] = new boolean[arr.length][arr.length];
		int step=0;
		DFSUtil(arr,source,dest,visited,step);
		System.out.println(fstep);
	}


	private void DFSUtil(int[][] arr, Point source, Point dest, boolean[][] visited, int step) {
		if(source.a == dest.a && source.b == dest.b)
			fstep=Math.min(step, fstep);
		
		int x=source.a;
		int y=source.b;
		visited[x][y]=true;
		dfshelper(arr,new Point(x+1,y),dest,visited,step);
		dfshelper(arr,new Point(x-1,y),dest,visited,step);
		dfshelper(arr,new Point(x,y+1),dest,visited,step);
		dfshelper(arr,new Point(x,y-1),dest,visited,step);
		
	}
	
	private boolean isSafe(int i, int j, int [][]arr) {
		return (i>=0 && i<=arr.length-1 && j>=0 && j<=arr[i].length-1);
	}
	
	private void dfshelper(int[][] arr, Point source, Point dest, boolean[][] visited, int step) {
		if(isSafe(source.a,source.b,arr) && !visited[source.a][source.b] && arr[source.a][source.b]==1)
		{	visited[source.a][source.b]=true;
			DFSUtil(arr,source,dest,visited,step+1);
			visited[source.a][source.b]=false;;
		}
	}
	
	public static void main(String args[]) {
		int arr[][] = {{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }}; 
		 Point source = new Point(0, 0); 
		 Point dest = new Point(3, 4); 
		 ShortestSourceToDest g= new ShortestSourceToDest();
		 g.findShortestPath(arr, source, dest);
	}

}
