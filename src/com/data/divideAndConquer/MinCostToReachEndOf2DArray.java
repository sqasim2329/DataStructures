package com.data.divideAndConquer;

public class MinCostToReachEndOf2DArray {
	
	public static void main(String args[]) {
		
		int arr[][]= {
				{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 }
			};
		int row = arr.length-1;
		int col = arr[0].length-1;
		System.out.println(findMinCost(arr,row, col));
	}

	private static int findMinCost(int[][] arr, int i, int j) {
		if(i == -1 || j == -1)
			return Integer.MAX_VALUE;
		
		if(i== 0 && j == 0)
			return arr[i][j];
		
		int y = findMinCost(arr,i-1,j);
		int x = findMinCost(arr,i,j-1);
				
		int min = Integer.min(x, y);
		int currentCost =arr[i][j]; 
		
		return min+currentCost;
		
	}

}
