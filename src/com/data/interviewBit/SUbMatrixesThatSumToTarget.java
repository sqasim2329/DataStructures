package com.data.interviewBit;

import java.util.HashMap;
import java.util.Map;

public class SUbMatrixesThatSumToTarget {
	
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int [][] dp = new int[r+1][c+1];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1]+matrix[i-1][j-1]-dp[i-1][j-1];
            }
        }
        
        int count = 0;
        int sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r1 = 1 ;r1 <=r;r1++){
            for(int r2=r1;r2<=r;r2++){
                map.clear();
                map.put(0,1);
                for(int col=1;col<=c;col++){
                    sum=dp[r2][col]-dp[r1-1][col]; 
                    count+=map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
        
    }

}

/***
 * 					0 0 0 0  
 *                  0 0 1 0
 *                  0 1 3 3
 *                  0 1 4 4
 *                  //dp[r2][col]-dp[r1-1][col]
 *                  Vertical scanning
 *                  Take 1, 1-2, 1-3 rows
 *                  Take 2, 2-3 rows , dp has sum from 1st row  also hence subtract that row data-->dp[r1-1][col] 
 *                  Take 3 row
 * 
 * **/
