package com.data.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianStreams {
	
	public static void main(String ars[]) {
		int[] testInt = {4,6,12,7,9,14,8,11,3};
//		int[] testInt = {4,5,15,1,3};
		getMedian(testInt);
	}

	private static void getMedian(int[] testInt) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> -1* a.compareTo(b));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> a.compareTo(b));
		List<Integer> arrList = new ArrayList<>();
		double median;
		for(int i=0;i<testInt.length;i++) {
			arrList.add(testInt[i]);
			addNumber(testInt[i],maxHeap,minHeap);
			rebalance(maxHeap,minHeap);
			median = fetchMedian(maxHeap,minHeap);
			Collections.sort(arrList);
			System.out.println("Median of List of numbers "+arrList.toString()+" is "+median);
		}
		
		
		
	}

	private static double fetchMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		// TODO Auto-generated method stub
		if(maxHeap.size() == minHeap.size()) {
			return (double)(maxHeap.peek()+minHeap.peek())/2;
		}else if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}else {
			return minHeap.peek();
		}
		
	}

	private static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		// TODO Auto-generated method stub
		if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		}
		else if(minHeap.size() -maxHeap.size() > 1) {
		maxHeap.add(minHeap.poll());
		}
		
	}

	private static void addNumber(int i, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		// TODO Auto-generated method stub
		if(maxHeap.size() == 0 || maxHeap.peek() > i) {
			maxHeap.add(i);			
		}else {
			minHeap.add(i);
		}
		
	}

}
