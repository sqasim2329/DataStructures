package com.data.graphs;
//https://www.geeksforgeeks.org/find-number-of-islands/

//instead of using boolean array updated visited elem to 0;
public class NumberIslands {
	boolean [][] visited;
	
	public NumberIslands(int size) {
		visited = new boolean[size][size];
	}
	
	private void findNumberOfIslands(int [][]arr) {
		int count=0;
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[i].length;j++) {
				if(!visited[i][j] && arr[i][j]==1) {
					formIslands(i,j,arr);
					count++;
				}
			}
		
		System.out.println(count);
	}
]]]]]]]]]]]]]]]]]]]]]]]]]]]
	private void formIslands(int i, int j,int[][] arr) {
		visited[i][j]=true;
		populateVisited(i-1, j, arr);
		populateVisited(i+1, j, arr);
//		populateVisited(i-1, j+1, arr);
//		populateVisited(i+1, j-1, arr);
		populateVisited(i, j-1, arr);
		populateVisited(i, j+1, arr);
//		populateVisited(i+1, j+1, arr);
//		populateVisited(i-1, j-1, arr);
		
	}

	private void populateVisited(int i, int j, int[][] arr) {
		if(isSafe(i,j,arr) && arr[i][j]==1 && !visited[i][j]) 
			formIslands(i,j,arr);
	}

	private boolean isSafe(int i, int j, int [][]arr) {
		return (i>=0 && i<arr.length && j>=0 && j<arr[i].length);
	}
	
	
	public static void main(String args[]) {
		int arr[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 0, 0, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 0, 1 } }; 
//            int arr[][] = new int[][] { { 1, 1, 1, 1, 1 }, 
//                { 1, 1, 1, 1, 1 }, 
//                { 1, 1, 1, 1, 1 }, 
//                { 1, 1, 1, 1, 1 }, 
//                { 1, 1, 1, 1, 1 } }; 
            NumberIslands n= new NumberIslands(arr.length);
            n.findNumberOfIslands(arr);
	}
	
	
}
