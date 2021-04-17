package com.data.google;

import java.util.PriorityQueue;

public class MaxValueOfEquation {
	
	class Solution {
	    public int findMaxValueOfEquation(int[][] points, int k) {
	        
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])*-1));
	        int max =Integer.MIN_VALUE;
	        for(int[] point:points){
	            while(!pq.isEmpty() && Math.abs(pq.peek()[1]-point[0])>k)pq.poll();
	            if(!pq.isEmpty()){
	                max = Math.max(max,(point[1]+point[0]+pq.peek()[0]));
	            }
	            pq.add(new int[]{point[1]-point[0],point[0]});
	        }
	        return max;
	    }
	}



	// x1,y1  x2,y2  x3,y3  x4,y4

	// xi < xj sorted as per x axis

	// hence yi+yj+xj-xi//since xj is always greater than xi
	// there yj+xj+(yi-xi) for any jth point we need maximum of yi-xi to find max value
	// and also we need xi for verifying xi-xj<=k, so need a priorityQueue<Pair<Integer,Intger>>






}
