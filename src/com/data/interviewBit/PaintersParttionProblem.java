package com.data.interviewBit;

public class PaintersParttionProblem {
	
	public class Solution {
	    public int paint(int A, int B, int[] C) {
	        int lo = 0;
	        int hi = 0;
	        for(int boardLength:C)
	        {
	            lo= Math.max(lo,boardLength);
	            hi+=boardLength;
	        }
	        
	        while(lo < hi){
	            int midBoardLength = lo+(hi-lo)/2;
	            int painters = getPainters(midBoardLength,C,B);
	            if(painters > A){
	                lo= midBoardLength+1;
	            }
	            else{
	                hi = midBoardLength;
	            }
	        }
	        return lo*B;
	        
	        
	    }
	    
	    private int getPainters(int midBoardLength,int[] C, int B){
	        midBoardLength = midBoardLength*B;
	        int painters = 1;
	        int totalTime=0;
	        for(int c:C)
	        {
	            totalTime += c*B ;
	            if(totalTime > midBoardLength){
	                totalTime = c*B;
	                painters++;
	            }
	                
	        }
	        return painters;
	    }
	}
	
	class Solution {
	    public int shipWithinDays(int[] weights, int D) {
	        
	        int lo = 0;
	        int hi = 0;
	        for(int i:weights){
	            lo = Math.max(lo,i);
	            hi+=i;
	        }
	        int ans = hi;
	        while(lo<=hi){
	            int mid = lo+(hi-lo)/2;
	            int days = getDays(mid,weights);
	            if(days > D){
	                lo=mid+1;
	            }else{
	                hi = mid-1;
	            }
	        }
	        
	        return lo;
	        
	    }
	    
	    private int getDays(int mid,int [] weights){
	        int count=1;
	        int sum = 0;
	        for(int i:weights){
	            sum+=i;
	            if(sum > mid){
	                sum = i;
	                count++;
	            }
	        }
	        return count;
	    }
	}
	
	class Solution {
	    public int splitArray(int[] nums, int m) {
	        
	        int lo = 0;
	        int hi = 0;
	        for(int i:nums){
	            lo= Math.max(lo,i);
	            hi+=i;
	        }
	        
	        int ans = hi;
	        while(lo <= hi){
	            int mid = lo+(hi-lo)/2;
	            int split = getSplits(mid,nums);
	            if(split > m)
	                lo=mid+1;
	            else
	            {
	                hi=mid-1;
	            }
	                
	        }
	        
	        return lo;
	    }
	    
	    private int getSplits(int mid,int nums[]){
	        int count = 1;
	        int sum = 0;
	        for(int i:nums){
	            sum+=i;
	            if(sum > mid){
	                sum = i;
	                count++;
	            }
	        }
	        
	        return count;
	    }
	}

	        
	    
	    


}
