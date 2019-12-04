package com.data.dynamicProgramming;

public class MaxProductOfContigousSubarray {
	
	public static void main(String args[]) {
		int arr[]= {-1,-1};
		System.out.println(findSum(arr));
	}

	private static int findSum(int[] arr) {
		int maxEH=1,maxSF=1;
		for(int i=0;i<arr.length;i++) {
			maxEH =maxEH*arr[i];
			if(maxEH ==0) {
				maxEH =1;
			}
			maxSF = Math.max(maxEH, maxSF);
		}
		return maxSF;
	}

}
