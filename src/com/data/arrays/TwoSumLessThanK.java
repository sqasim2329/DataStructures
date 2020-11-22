package com.data.arrays;

import java.util.Arrays;

public class TwoSumLessThanK {
	
	public int twoSumLessThanK(int[] A, int K) {
        int max =-1;
        int i = 0;
        int j = A.length-1;
        Arrays.sort(A);
        while(i < j){
            if(A[i]+A[j]<K){
                max = Math.max(A[i]+A[j],max);// since A[i]< A[i+1]
                i++;
            }else{
                j--;
            }
        }
        
        return max;
        
    }

}
