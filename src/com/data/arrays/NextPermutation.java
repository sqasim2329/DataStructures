package com.data.arrays;

import java.util.Arrays;

public class NextPermutation {
	
	public static void main(String args[]) {
		int[] array = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
//		int[] array = {1,2,3};
		nextPermutation(array);
		Arrays.stream(array).forEach(System.out::println);
	}

	private static void nextPermutation(int[] a) {
		int i=a.length-1;
		while(i>0 && a[i-1]>=a[i])
			i--;
		if(i<=0) {
			swap(0,a.length-1,a);
		return;
		}
		
		int j=a.length-1;
		while(a[j]<=a[i-1]) {
			j--;
		}
		
		swap(j,i-1,a);
		j=a.length-1;
		
//		if(i>=j) {
//			for(int k=0;k< a.length;k++) {
//				System.out.print(a[k]);
//			}
//		}
		while(i < j) {
			swap(i,j,a);
			i++;
			j--;
		}
		}
	

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;	
	}
		
	

}
