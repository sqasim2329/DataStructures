package com.data.google.microsoft;

public class MaximumNetworkRank {
	
	class Solution {
	    public int maximalNetworkRank(int n, int[][] roads) {
	        
	        int[][] commonRoads = new int[n][n];
	        int[] city = new int[n];
	        for(int[] road:roads){
	            int i = road[0];
	            int j = road[1];
	            city[i]++;
	            city[j]++;
	            commonRoads[i][j]++;
	            commonRoads[j][i]++;
	        }
	        int max = 0;
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                max = Math.max(max,city[i]+city[j]-commonRoads[i][j]);
	            }
	        }
	        return max;
	    }
	}


	// city 1. city 2
	    
//	     calculate the total number of roads connecting to City 1 and city 2 and subtract the common roads.

}
