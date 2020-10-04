package com.data.arrays;

import java.util.Arrays;

public class CountInversionOfArray {
	
	public static void main(String args[]) {
//		int[] arr = { 1, 20, 6, 4, 5 }; 
		int[] arr = { 1, 4, 3, 2}; 
		System.out.println(mergeSortCount(arr,0,arr.length-1));
	}

	private static int mergeSortCount(int[] arr, int l, int r) {
		int c =0;
		if(l<r) {
			int m=l+(r-l)/2;
			c+=mergeSortCount(arr,l,m);
			c+=mergeSortCount(arr,m+1,r);
			c+=mergeSort(arr,l,m,r);
			
		}    
		return c;
		
	}

	private static int mergeSort(int[] arr, int l, int m, int r) {
		int k=l;
		int [] left = Arrays.copyOfRange(arr, l, m+1);
		int [] right = Arrays.copyOfRange(arr, m+1, r+1);
		int c=0;
		int i=0,j=0;
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j])
				arr[k++]=left[i++];
			else {
				arr[k++]=right[j++];
				c+=((m+1)-(l+i));
			}
		}
		
		while(i<left.length) {
			arr[k++]=left[i++];
		}
		while(j<right.length) {
			arr[k++]=right[j++];
		}
		return c;
	}

}
