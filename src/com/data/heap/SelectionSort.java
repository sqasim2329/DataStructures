package com.data.heap;

public class SelectionSort {
	//find min element and swap the min element with last element of sorted arr. 
	public static void main(String args[]) {
		int arr[] = {30,10,50,40,60,20};
		for(int i = 0; i <= arr.length-1 ; i++) {
			int min = i;
			for(int j=i+1; j <= arr.length-1 ; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			if(min!=i) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
		
		for(int a:arr) {
			System.out.println(a);
		}
		
	}

}
