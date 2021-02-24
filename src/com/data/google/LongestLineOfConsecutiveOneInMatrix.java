package com.data.google;

public class LongestLineOfConsecutiveOneInMatrix {
	
	public int solve(int[][] M) {
		if(M.length==0)
            return 0;
        int row = M.length;
        int col = M[0].length;
        int[][][] dp = new int[row][col][4]; // 4 represents the direction, horizontal, vertical, diagonal, antidiagonal
            int max =0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++){
                if(M[i][j]==1){
                     dp[i][j][0] =(j > 0)?1+dp[i][j-1][0]:1;
                     dp[i][j][1] =(i > 0)?1+dp[i-1][j][1]:1;
                     dp[i][j][2] =(i>0 && j > 0)?1+dp[i-1][j-1][2]:1;
                     dp[i][j][3] =(i>0 && j < col-1)?1+dp[i-1][j+1][3]:1;
                        int curr = Math.max(Math.max(dp[i][j][0],dp[i][j][1]),Math.max(dp[i][j][2],dp[i][j][3]));
                        max = Math.max(max,curr);
                }
            }
        } 
        return max;
	}

}
