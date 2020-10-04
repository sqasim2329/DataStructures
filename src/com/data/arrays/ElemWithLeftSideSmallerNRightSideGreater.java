package com.data.arrays;

public class ElemWithLeftSideSmallerNRightSideGreater {
	
	public static void main(String args[]) {
		int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		int n = arr.length;
		System.out.println(arr[findelem(arr, n)]);
	}

	private static int findelem(int[] arr, int n) {
		int[] lmax = new int[n]; 
		lmax[0]= Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			lmax[i]=Math.max(lmax[i-1],arr[i-1]);
		}
		int Rmin = Integer.MAX_VALUE;
		for(int i=n-1;i>=0;i--) {
			if(lmax[i] < arr[i] && Rmin > arr[i])
				return i;
		Rmin = Math.min(Rmin, arr[i]);	
		}
		return -1;
	}

}
