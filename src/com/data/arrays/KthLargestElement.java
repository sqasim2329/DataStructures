package com.data.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	public static void main(String args[]) {
		Integer arr[] = {6,4,1,3,9,7,0};
		KthLargestElement(arr,3);
	}	
	
	private static void getKthLargestElement(Integer[] arr, int k) {
		List<Integer> intList = Arrays.asList(arr);
		int n = arr.length;
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->(a-b));	
		pq2.addAll(intList.subList(0, k));
		for(int i=k; i<n; i++){
			if(pq2.peek() < intList.get(i)) {
				pq2.poll();
				pq2.add(intList.get(i));
			}
		}
		System.out.println(pq2.peek());
	}
	
	private static void KthLargestElement(Integer[] arr, int k) {
		List<Integer> intList = Arrays.asList(arr);
		int n = arr.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
		for(int i=0; i<n; i++){
		if(pq.size()<k) {
			pq.add(arr[i]);
		}else if(pq.peek()<arr[i]) {
			pq.poll();
			pq.add(arr[i]);
		}
		}
		System.out.println(pq.peek());
	}
	
	
	

}
