package com.data.heap;

public class HeapByArrayMain {

	public static void main(String[] args) {
		System.out.println("Creating a blank Heap");
		HeapByArray heap = new HeapByArray(10);
		
		heap.insertInHeap(9);
		heap.insertInHeap(1);
		heap.insertInHeap(7);
		heap.insertInHeap(11);
		heap.insertInHeap(15);
		heap.extractHeadOfHeap();
	}
}//end of class
