package com.data.stack;

import java.util.Arrays;
import java.util.Comparator;

public class SortInWaveForm {
		
		public static void main(String args[]) {
		Integer arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i=i+2) {
		int tmp=arr[i];
		arr[i]=arr[i+1];
		arr[i+1]=tmp;
		}
		for(int i=0;i<=arr.length-1;i++) {
			System.out.print(arr[i]+" ");
		}
		}
		
	

}
