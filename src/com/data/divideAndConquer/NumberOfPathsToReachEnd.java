package com.data.divideAndConquer;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPathsToReachEnd {
	
	
	public static void main(String args[]) {
		
		int arr[][]= {
				{4,7,1,6},
				{5,7,3,9},
				{3,2,1,2},
				{7,1,6,3}
		};
		int cost =25;
		int[][]dp=new int[4][4];
		Map<String,Integer> map = new HashMap<>();
		System.out.println(
		findNumberOfPaths(arr,cost,arr.length-1,arr[0].length-1,map));
	}

	private static int findNumberOfPaths(int[][] arr, int cost, int i, int j) {
		
		if(cost < 0 )
			return 0;
			
		if(i==0 && j==0)
			return cost-arr[i][j]==0?1:0;
		
		if(i==0)
			return findNumberOfPaths(arr,cost-arr[i][j],0,j-1);
		
		if(j==0)
			return findNumberOfPaths(arr,cost-arr[i][j],i-1,0);
		
		int x = findNumberOfPaths(arr,cost-arr[i][j],i-1,j);
		int y = findNumberOfPaths(arr,cost-arr[i][j],i,j-1);
		return x+y;
		
	}
	
private static int findNumberOfPaths(int[][] arr, int cost, int i, int j,Map<String,Integer> map) {
		String key = i+"|"+j+"|"+cost;
		if(map.containsKey(key))
		return map.get(key);
	
		if(cost < 0 )
			return 0;
			
		if(i==0 && j==0)
			return  cost-arr[i][j]==0?1:0;
		
		if(i==0)
			map.put(key,findNumberOfPaths(arr,cost-arr[i][j],0,j-1));
		
		else if(j==0)
			map.put(key,findNumberOfPaths(arr,cost-arr[i][j],i-1,0));
		else {
		int x = findNumberOfPaths(arr,cost-arr[i][j],i-1,j,map);
		int y = findNumberOfPaths(arr,cost-arr[i][j],i,j-1,map);
		map.put(key,x+y);
		}
		return map.get(key);
		
	}

}
