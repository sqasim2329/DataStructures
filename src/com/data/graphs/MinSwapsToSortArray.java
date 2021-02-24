package com.data.graphs;
//https://www.geeksforgeeks.org/number-swaps-sort-adjacent-swapping-allowed/--MERGE SORT NO OF INVERSION
//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/	first N elements(1--N)
public class MinSwapsToSortArray {
	
	boolean[] visited;
	
	public MinSwapsToSortArray(int v) {
		visited= new boolean[v];
	}
	
	private int findMinSwaps(int arr[]) {
		int swaps =0;
		for(int i=0;i<arr.length;i++) {
			int j=i;
			int cycleNodes=0;
			
			while(!visited[j]) {
				visited[j]=true;
				j=arr[j]-1;
				cycleNodes++;
				
			}
			
			if(cycleNodes>0)
			swaps+=cycleNodes-1;
		}
		return swaps;
	}
	
	public static void main(String args[]) {
//		int arr[]={4, 3, 2, 1};
//		int arr[]={1, 5, 4, 3, 2};
		int arr[]={2, 3, 4, 1,6,5}; 
		MinSwapsToSortArray m= new MinSwapsToSortArray(arr.length);
		System.out.println(m.findMinSwaps(arr));
		
		
	}

}


//2,3,4,1,6,5