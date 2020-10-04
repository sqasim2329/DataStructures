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
		int a[] = {2, 6, 3, 12, 56, 8 };
		int k=3;
		SorTKSortArray s = new SorTKSortArray();
		a =s.sort(a,3);
		Arrays.stream(a).forEach(System.out::print);
		
	}

}
