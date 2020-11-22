package com.data.dynamicProgramming;

import java.util.Arrays;

public class MaxLengthChain {
	
	public static void main(String args[]) {
		int [][]nums= {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		
		System.out.println(findLongestChain(nums));
	}

	
		public static int findLongestChain(int[][] pairs) {
	        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
	        int count =1;
	        int prev = pairs[0][1];
	        for(int i=1;i<pairs.length;i++){
	            if(prev < pairs[i][0]){
	                count++;
	                prev = pairs[i][1];
	            }
	        }
	        
	        return count;
	        
	    }
	

}
