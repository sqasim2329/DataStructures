package com.data.heap;
//https://www.techiedelight.com/convert-max-heap-min-heap-linear-time/same as below question
public class HeapSortMain {
	
	public static void main(String args[]) {
		int arr[] = {10,5,35,5,25,6,1};
		HeapSort hs = new HeapSort(arr);
		hs.sort();
		hs.printArray();
	}

}
