package com.data.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSamllestElement {
	
	public static void main(String args[]) {
		Integer arr[] = {6,4,1,3,9,7,0};
		getKthSmallestElement(arr,3);
	}

	private static void getKthSmallestElement(Integer[] arr, int i) {
		
		List<Integer> ls = Arrays.asList(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (a-b) *-1);
		pq.addAll(ls.subList(0, i));
		for(int j=i ;j< ls.size();j++) {
			if(pq.peek()>ls.get(j)) {
				pq.poll();
				pq.add(ls.get(j));
			}
		}
		System.out.println(pq.peek());
		
		
	}
	

}
