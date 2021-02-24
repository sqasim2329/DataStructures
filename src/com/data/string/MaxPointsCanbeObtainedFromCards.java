package com.data.string;

public class MaxPointsCanbeObtainedFromCards {
	
	class Solution {
	    public int maxScore(int[] cardPoints, int k) {
	        int max = Integer.MIN_VALUE;
	        int sum = 0;
	        int n = cardPoints.length;
	        for(int i =0;i<k;i++){
	            sum+=cardPoints[i];
	        }
	        
	        if(k==cardPoints.length)
	            return sum;
	        max = sum;
	        for(int i=0;i<k;i++){
	            sum += cardPoints[n-1-i];
	            sum -= cardPoints[k-1-i];
	            max = Math.max(sum,max);
	        }
	        
	        return max;
	    }
	   
	}

}
