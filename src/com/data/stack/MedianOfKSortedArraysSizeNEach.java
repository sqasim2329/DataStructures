package com.data.stack;

import java.util.PriorityQueue;

public class MedianOfKSortedArraysSizeNEach {
	
	public class Solution {
		  public int median(int[][] input) {
		    if(input == 0 || input.length == 0) return 0;
		     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
		     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
		     int totCount = 0;
		     for(int[] arr: input) {
		        for(int num : arr) {
		            totCount++;
		            if(maxHeap.isEmpty() || num < maxHeap.peek()) {
		                 maxHeap.add(num);
		                if(maxHeap.size() - minHeap.size() > 1)
		                  minHeap.add(maxHeap.poll());
		            } else {
		              minHeap.add(num);
		              if(minHeap.size() > maxHeap.size())
		                  maxHeap.add(minHeap.poll());
		            } 
		        }  
		     } 
		     
		     if(totCount%2 != 0) return maxHeap.peek();
		     else
		       return (maxHeap.peek() + minHeap.peek()) / 2;
		  }  

		  public static void main(String[] args) {
		    Solution s = new Solution();
		    System.out.println(s.median(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
		    System.out.println(s.median(new int[][]{{10, 100, 1000}, {5, 55, 555}, {23, 2323, 232323}}));
		  }
		}

}
