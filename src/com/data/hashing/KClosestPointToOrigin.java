package com.data.hashing;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
	
	class Solution {
	    public int[][] kClosest(int[][] points, int K) {
	        
	        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> ((a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1]))*-1);
	        int res[][]=new int[K][2];
	        for(int[] i:points){
	            q.add(i);
	            if(q.size()>K){
	                q.poll();
	            }
	        }
	        
	        while(K-- > 0){
	            res[K]=q.poll();
	        }
	        return res;
	    }
	}

}
/*****
 * 
 * Euclidean distance: between two points a,b
 * 		subtract ->>>> a[0]-b[0], a[1]-b[1]
 * 		square ->>>>> a[0]*a[0]-b[0]*b[0],a[1]*a[1]-b[1]*b[1]
 * 		add ----> a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1];
 * 
 * 
 * 
 * **/



