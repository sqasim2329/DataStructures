package com.data.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SorTKSortArray {
	
	public int[] sort(int []a,int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<k+1;i++) {
			q.add(a[i]);
		}
		int index=0;
		for(int i=k+1;i<a.length;i++) {
				a[index++]=q.poll();
				q.add(a[i]);
			}
		
	
		while(!q.isEmpty()) {
			a[index++]=q.poll();
		}
			
		return a;
		
	}
	
	
	public static void main(String args[]) {
		int a[] = {10, 9, 8, 7, 4, 70, 60, 50};
		int k=4;
		SorTKSortArray s = new SorTKSortArray();
		a =s.sort(a,4);
		Arrays.stream(a).forEach(System.out::print);
		
	}

}
