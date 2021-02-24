package com.data.heap;

import java.util.Arrays;

public class HeapSort {
	
	private int[] arr = null;
	
	public HeapSort(int[] arr) {
		this.arr=arr;
	}
	
	public void sort(){
		
			HeapByArray hba= new HeapByArray(arr.length);
			for(int i = 0; i< arr.length;i++) {
				hba.insertInHeap(arr[i]);
			}
			for(int i=0; i< arr.length;i++) {
				arr[i]=hba.extractHeadOfHeap();
			}
			
		
				
	}
	
	public void printArray() {
		for(int i=0; i< arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	

}
