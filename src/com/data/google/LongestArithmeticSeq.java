package com.data.google;

public class LongestArithmeticSeq {
	
	class Solution {
	    public int longestArithSeqLength(int[] A) {
	        int n= A.length;
	        HashMap<Integer,Integer>[] dp= new HashMap[n];//diff,length of elements
	        int max =0;
	        for(int i=0;i<n;i++){
	            dp[i]= new HashMap<>();
	            for(int j=0;j<i;j++){
	                int diff = A[i]-A[j];
	                int len = dp[j].getOrDefault(diff,1)+1;//by default get length and +1 for elements   
	                dp[i].put(diff,len);
	                max =Math.max(dp[i].get(diff),max);
	            }
	        }
	        return max;
	    }
	}

}
