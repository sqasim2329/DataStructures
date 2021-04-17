package com.data.google.microsoft;

public class OverlappingRectangles {
	
	
	class Solution {
	    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	        
	        if(rec1[2]<=rec2[0] || rec2[2]<=rec1[0]) return false;//horizontal
	        if(rec1[1]>=rec2[3] || rec2[1]>=rec1[3]) return false;//vertical
	        
	        return true;
	        
	        
	    }
	}


	    

}
