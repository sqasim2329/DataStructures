package com.data.arrays;

public class RainWaterTrapping {
    
    	  public int trap(int[] arr) {
    	        
    	        int Lmax = 0;
    	        int Rmax = 0;
    	        int l=0;
    	        int r=arr.length-1;
    	        int res = 0;
    	        while(l<=r){
    	            if(arr[l]<=arr[r]){
    	                if(arr[l] > Lmax){
    	                    Lmax = arr[l++];
    	                }else{
    	                    res+=Lmax-arr[l++];
    	                }
    	            }else{
    	                if(arr[r]>Rmax){
    	                    Rmax = arr[r--];
    	                }else{
    	                    res+=Rmax-arr[r--];
    	                }
    	            }
    	        }
    	        
    	        return res;
    	        
    	    }
}