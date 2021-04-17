package com.data.google.microsoft;

public class CanPlaceFlowers {
	
	class Solution {
	    public boolean canPlaceFlowers(int[] flowerbed, int n) {
	        int count =1;// if i ==0 has value 0;
	        int res = 0;
	        for(int i=0;i<flowerbed.length;i++){
	            if(flowerbed[i]==0)
	                count++;
	            else{
	                res += (count-1)/2;
	                count = 0;
	            }
	        }
	        res +=count/2;//if i==n-1 has value 0;
	        return res>=n;
	        
	    }
	}

}
