package com.data.interviewBit;

public class MaxPointsInALine {
	
	class Solution {
	    public int maxPoints(int[][] points) {
	        //1. if two point are parallel to y axis then slope is Integer.MAX_VALUE;
	        //2. if two point are parallel to x axis then slope is 0;
	        //3. if two points are in a slope then slope can be determined by y2-y1/x2-x1;
	        int max = 0;
	        if(points.length <=2)
	            return points.length;
	        for(int i=0;i<points.length;i++){
	            int[] a = points[i];
	            Map<Double,Integer> slopeMap = new HashMap<>();
	            for(int j=i+1;j<points.length;j++){
	                int[] b = points[j];
	                double slope = getSlope(a,b);
	                slopeMap.put(slope,slopeMap.getOrDefault(slope,1)+1);//why 1 instead of 0 since slope map is Map<slope,no of points> 2 required to make slope
	                max = Math.max(max,slopeMap.get(slope));
	            }
	        }
	        return max;
	    }
	    
	    
	    private double getSlope(int[] a, int[] b){
	        if(a[0]==b[0]) return Integer.MAX_VALUE;
	        if(a[1]==b[1]) return 0d;
	        return ((double)(b[1]-a[1]))/((double)(b[0]-a[0]));
	    }
	}

}
