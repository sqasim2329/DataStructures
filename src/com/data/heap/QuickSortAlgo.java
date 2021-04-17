package com.data.heap;
O(nlogn), average but worst O(n2)
import java.util.Arrays;

public class QuickSortAlgo {
	
	public static void main(String args[]) {
		int arr[]= {9,4,6,3,7,1,2,11,5};
		QuickSort(arr,0,arr.length-1);
		for(int i=0;i<=arr.length-1;i++) {
			System.out.println(arr[i]);
		}
	}

	private static void QuickSort(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		if(p<q) {
		int pivot = findPivot(arr, p,q);
		QuickSort(arr,p,pivot-1);
		QuickSort(arr,pivot+1,q);
	 }
		
	}

	private static int findPivot(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		int i = p-1;
		int pivot = q;
		for(int j=p; j<=q;j++) {
			if(arr[j]<=arr[pivot]) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		return i;
	}

}
