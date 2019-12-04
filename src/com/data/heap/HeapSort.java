package com.data.heap;

import java.util.Arrays;

public class HeapSort {
	
	private int[] arr = null;
	
	public HeapSort(int[] arr) {
		this.arr=arr;
	}
	
	public void sort(){
		for(int i=0;i<arr.length;i++) {
			HeapByArray hba= new HeapByArray(arr.length);
			for(i = 0; i< arr.length;i++) {
				hba.insertInHeap(arr[i]);
			}
			for(i=0; i< arr.length;i++) {
				arr[i]=hba.extractHeadOfHeap();
			}
			
		}
				
	}
	
	public void printArray() {
		for(int i=0; i< arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	

}
