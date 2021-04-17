package com.data.dynamicProgramming;

public class CountSubMatricesWithAllOnes {
	
	class Solution {
	    public int numSubmat(int[][] mat) {
	        int n = mat.length;
	        int m = mat[0].length;
	        int [][]dp = new int[n][m];
	        for(int i=0;i<n;i++){
	            int cnt = 0;
	            for(int j = m-1;j>=0;j--){
	                if(mat[i][j]==1){
	                    cnt++;
	                }else{
	                    cnt=0;
	                }
	                dp[i][j]=cnt;
	            }
	        }
	        
	        int ans = 0;
	        for(int i=0;i<n;i++){
	            for(int j = 0;j<m;j++){
	                int min = dp[i][j];
	                for(int k=i;k<n;k++){
	                    min = Math.min(dp[k][j],min);
	                    ans +=min;
	                }
	                
	            }
	        }
	        
	        return ans;
	        
	    }
	}


	// 1 0 1
	// 1 1 0
	// 1 1 0  

	    
//	    1+2+2
//	    2+2+1
//	    2+1 

	// 0,1,1,0
	// 0,1,1,1
	// 1,1,1,0
	    
//	     2+2+2
//	     1+1+1
//	     3+2
//	     2+1+3+2+1

}
