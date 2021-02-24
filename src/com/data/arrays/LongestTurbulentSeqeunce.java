package com.data.arrays;
//same like wiggle sort
public class LongestTurbulentSeqeunce {
	
	public int maxTurbulenceSize(int[] A) {
	
	 int inc = 1, dec = 1, result = 1;
     for (int i = 0; i < A.length-1; i++) {
         if (A[i] > A[i+1]) {
             dec = inc + 1;
             inc = 1;
         } else if (A[i] < A[i + 1]) {
             inc = dec + 1;
             dec = 1;
         } else {
             inc = 1;
             dec = 1;
         }
         result = Math.max(result, Math.max(dec, inc));
     }
     return result;
	
     
 }

///[2,0,2,4,2,5,0,1,2,3]
//hence inc and dec must be made one


}
