package com.data.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	public static void main(String args[]) {
		Integer arr[] = {6,4,1,3,9,7,0};
		getKthLargestElement(arr,3);
	}

	private static void getKthLargestElement(Integer[] arr, int k) {
		List<Integer> intList = Arrays.asList(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>(intList.subList(0, k));
			for(int i = k;i < intList.size(); i++) {
				if(pq.peek() < intList.get(i)) {
					pq.poll();
					pq.add(intList.get(i));
				}
			}
			
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->(a-b)*-1);	
		pq2.addAll(Arrays.asList(arr));
		for(int i=0; i<k; i++){
			pq2.poll();
			if(i==k-1)
		System.out.println(pq.peek());
		}
	}

}
