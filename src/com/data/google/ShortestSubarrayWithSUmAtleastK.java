package com.data.google;

public class ShortestSubarrayWithSUmAtleastK {
	
	class Solution {
	    public int shortestSubarray(int[] A, int K) {
	       int n = A.length;
	       int prefixSum[] = new int[n+1];
	       int sum = 0; 
	       Deque<Integer> startIndexQ = new ArrayDeque<>();
	       for(int i=1;i<=n;i++) {
	           sum+=A[i-1];
	           prefixSum[i]=sum;
	       }
	        
	        startIndexQ.add(0);
	        int ans = n+1;
	        for(int endIndx = 1;endIndx<=n;endIndx++){
	            while(!startIndexQ.isEmpty() && prefixSum[endIndx]-prefixSum[startIndexQ.peekFirst()] >= K){
	                ans = Math.min(ans,endIndx-startIndexQ.pollFirst());// once we determine the p[y]-p[x] remove x since for any y' > y p[y']-p[x] will have length > y-x;
	            }
	            
	            while(!startIndexQ.isEmpty() && prefixSum[startIndexQ.peekLast()] >= prefixSum[endIndx]){
	                startIndexQ.pollLast();// for any x such that p[x] > p[endIndx] remove p[x] since p[y]-p[x] > p[y]-p[ednIndx] since sum should be atleadt equal to K;
	            }
	            
	            startIndexQ.addLast(endIndx);
	        }
	        return ans==n+1?-1:ans;//we weere not able to find shrtest 
	    }
	}


	// 2,-1,2,1
	    
	// 0,2,1,3,4

	// 0





}
