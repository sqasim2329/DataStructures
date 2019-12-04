package com.data.divideAndConquer;

public class WaysToReachLastCell {
	
	public static void main(String args[]) {
		int[][] arr = { 
				{ 4, 7, 1, 6 }, 
				{ 5, 7, 3, 9 }, 
				{ 3, 2, 1, 2 }, 
				{ 7, 1, 6, 3 } };
		int cost = 25;
		System.out.println(findWaysToReach(arr,cost,arr.length-1,arr[0].length-1));
	}

	private static int findWaysToReach(int[][] arr, int cost, int i, int j) {
		// TODO Auto-generated method stub
		if(cost < 0 || i <0 || j < 0)
			return 0;
		
		if(i==0 && j==0)
			return cost-arr[i][j]==0?1:0;
		
		if(i == 0)
			findWaysToReach(arr,cost-arr[i][j],0,j-1);
		
		if(j == 0)
			findWaysToReach(arr,cost-arr[i][j],i-1,0);
		
		int x = findWaysToReach(arr,cost-arr[i][j],i-1,j );
		int y = findWaysToReach(arr,cost-arr[i][j],i,j-1);
		
		return x+y;
	}

}
