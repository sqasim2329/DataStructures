package com.data.google;

import java.util.PriorityQueue;

public class MaximumPairDecrements {
	
	public static void main(String args[]) {
		int [] arr = {1, 2, 3, 4, 5};
		System.out.println(solve(arr));
	}
	
	private static int solve(int [] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++)
		pq.add(arr[i]);
		int ops=0;
		while(pq.size()>1) {
			
			int first  = pq.poll();
			int second  = pq.poll();
			first--;
			second--;
			if(first > 0)
				pq.add(first);
			
			if(second > 0)
				pq.add(second);
			
			ops++;
			
		}
		return ops;
		
	}

}
