package com.data.google;

public class SumOfSquareNumbers {
	
	public boolean judgeSquareSum(int c) {
        for(long i = 0;i*i <= c;i++){
            long aSquare= i*i;
            int bSquare = c-(int)(aSquare);
            if(binarySearch(0,bSquare,bSquare))
                return true;
       }
        return false;
    }
    
    private boolean binarySearch(int lo,int hi,int val){
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(mid*mid == val) return true;
            if(mid * mid > val){
                hi = mid-1;
            }else
                lo = mid+1;
        }
        
        return false;
    }

}
