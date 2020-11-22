package com.data.heap;

public class InsertionSort {
	
	public static void main(String args[]) {
		int arr[] = {30,10,50,40,20};
		for(int i = 0; i <= arr.length-1; i++) {
			int currentVal = arr[i];
			int j = i;
			while(j > 0  && arr[j-1] > currentVal) {
				arr[j] = arr[j-1];\
				j--;
			}
			arr[j] = currentVal;
		}
		for(int a: arr) {
		System.out.println(a);
		}
	}

}
