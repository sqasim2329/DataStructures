package com.data.dynamicProgramming;

public class DuplicatesElementFromSorted {
	
	public static void main(String args[]) {
	int arr[]= {1,2,2,3};
	int n = removeDups(arr);
	for(int i=0;i<n;i++) {
		System.out.println(arr[i]);
	}
	}

	private static int removeDups(int[] arr) {
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[j++]=arr[i];
			}
		}
		
		arr[j++]=arr[arr.length-1];
		return j;
		
	}

}
