package com.data.dynamicProgramming;

public class CutRibbonIntoEqualLengths {
	
	public static int cutRibbon(int[]nums, int k) {
		int max =0;
		for(int i:nums)
			max = Math.max(i, max);
		
		int l = 1;
		int r = max;
		while(l<=r) {
			int mid = l+(r-l)/2;
			int noOfRibbonWithLenMid = getCount(nums,mid);
			if(noOfRibbonWithLenMid > k)
				l=mid+1;
			else
				r=mid-1;
			
		}
		return l;
		
	}
	
	private static int getCount(int[] arr, int mid) {
		int res =0;
		for(int i:arr)
			res+=i/mid;
		return res;
	}



public static void main(String args[]) {
	int[]arr = {1, 2, 3, 4, 9};
	int k = 5;
	System.out.println(cutRibbon(arr,k));
	
	}
}
//koko and banana
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        
        int lo = 1;
        
        int hi = piles[0];
        
        for(int i=0;i<piles.length;i++){
            hi =Math.max(hi,piles[i]);
        }
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int count = getHoursToEatAllBananas(mid,piles);
            if(count > h)
                lo=mid+1;
            else
                hi=mid-1;
        }
        
        return lo;
        
    }
    
    private int getHoursToEatAllBananas(int k,int[] piles){
        int count = 0;
        
        for(int i:piles){
            count+=i/k;
            if(i%k!=0)count++;
        }
        return count;
    }
}
    
    
    
    
    
    