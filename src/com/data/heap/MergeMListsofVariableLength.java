package com.data.heap;

import java.util.PriorityQueue;

public class MergeMListsofVariableLength {
	
	 static class Node implements Comparable<Node>{
		int val;	
		int listIndex;
		int index;
		public Node(int val, int listIndex, int index) {
			super();
			this.val = val;
			this.listIndex = listIndex;
			this.index = index;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
		public void setListIndex(int listIndex) {
			this.listIndex = listIndex;
		}
		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
		
		
	}
	
	public static void main(String args[]) {
		int arr[][] = {{10,20,30,40,50},{15,25,35},{27,29,37,48,93},{32,33}};
		printSortedArray(arr);
	}

	private static void printSortedArray(int[][] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<= arr.length-1;i++) {
			pq.add(new Node(arr[i][0],i,0));
		}
		
		while(!pq.isEmpty()) {
			Node min = pq.poll();
			int minVal = min.val;
			int listIndex = min.listIndex;
			int index = min.index;
			System.out.println(minVal);
			if( index +1 <= arr[listIndex].length-1) {
				min.setVal(arr[listIndex][index+1]);
				min.setListIndex(listIndex);
				min.setIndex(index+1);
				pq.add(min);
			}
			
			
		}
		
	}

}
