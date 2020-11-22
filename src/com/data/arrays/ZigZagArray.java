package com.data.arrays;

public class ZigZagArray {
	
	public static void main(String args[]) {
		int arr[] ={4, 3, 7, 8, 6, 2, 1};
		int count=0;
		for (int i = 0; i < arr.length - 1; i++) {
			if ((count = count^1) == 1) {
				if(arr[i]>arr[i+1]) {
					swap(i,i+1,arr);
				}
			}else {
				if(arr[i]<arr[i+1]) {
					swap(i,i+1,arr);
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		
	      
	}

	private static void swap(int i, int j,int arr[]) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

}


//https://practice.geeksforgeeks.org/problems/last-index-of-1/0 -- start from right
//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
//https://www.geeksforgeeks.org/find-minimum-difference-pair/ -- sort the arr and then find difference b/w i and i+1

//https://www.geeksforgeeks.org/find-number-pairs-xy-yx/--look before interview


find duplicate in array
subaarray with size k
rain water
slidind window maximuym
3sum
2sum

https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/