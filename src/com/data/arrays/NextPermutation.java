package com.data.arrays;

public class NextPermutation {
	
	public static void main(String args[]) {
//		int[] array = {0, 1, 1, 1, 4};
		int[] array = {0, 1, 2, 5, 3,3,0};
		nextPermutation(array);
		
	}

	private static void nextPermutation(int[] a) {
		int i=a.length-1;
		while(i>0 && a[i-1]>=a[i])
			i--;
		if(i<=0)
			swapAndPrint(0,a.length,a);
		
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
		while(i < j)
			swapAndPrint(i,j,a);
		}
	

	private static void swapAndPrint(int i, int j, int[] a) {
		
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;	
	}
		
	

}
