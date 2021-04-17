package com.data.google;
public class RussianDoll {
	
	class Solution {
	    public int maxEnvelopes(int[][] envelopes) {
	    
	    Arrays.sort(envelopes,new Comparator<int[]>(){
	        public int compare(int[]a,int [] b){
	            int comp = a[0]-b[0];
	            if(comp==0)
	                comp = b[1]-a[1];// One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
	            return comp;
	            
	        }
	    });
	    int [] a = new int[envelopes.length];
	    for(int i=0;i<envelopes.length;i++)
	        a[i]=envelopes[i][1];
	    return longestIncreasingSubsequence(a); // Computes LIS on heights.
	    }
	    
	    private int longestIncreasingSubsequence(int[] a){
	       int[] dp = new int[a.length];
	        int len =0;
	        for(int i:a){
	            int indx = Arrays.binarySearch(dp,0,len,i);
	            if(indx < 0)
	                indx = -(indx+1);
	            dp[indx]=i;
	            if(indx == len)
	                len++;
	        }
	        return len;
	    }
	    
	    
	    
	}


	// 2,3 5,4 6,7 6,4


//	[[4,5],[4,6],[6,7],[2,3],[1,1]]
//
//	1,1 2,3 4,5 4,6 6,7// if sorted on basis a[1]-b[1]
	
	/// 4,5 will fit into 4,6 and that is not allowed






}
