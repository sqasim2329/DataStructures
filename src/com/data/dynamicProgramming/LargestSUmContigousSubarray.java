package com.data.dynamicProgramming;

public class LargestSUmContigousSubarray {
	
	public static void main(String args[]) {
		
		int arr[]= {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findSum(arr));
	}

	private static int findSum(int[] arr) {
		int maxEH = 0;
		int maxSF = 0;
		
		for(int i=0; i < arr.length;i++) {
			maxEH = maxEH + arr[i];
			if(maxEH < 0) {
				maxEH = 0;
			}
			
			maxSF = Math.max(maxSF, maxEH);
		}
		
		return maxSF;
	}

}
