package com.data.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWIndowMaximum {
	
	public static void main(String args[]) {
		int[] nums= {1,3,-1,-3,5,3,6,7};
		int k= 3;
		int m = nums.length-(k-1);// if n =8 and k=3 then output arr will be 6
		Deque<Integer> dq = new LinkedList<>();
		int j=0;
		int out[]=new int[m];
		int i;
		int n= nums.length;
		for(i=0;i<k;i++) {
			while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
				dq.pollLast();
			dq.addLast(i);
		}
		
		for(;i<n;i++) {
			while(!dq.isEmpty() && dq.peekFirst() <=i-k)
				dq.pollFirst();
			
			while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()] )
				dq.pollLast();
			
			dq.addLast(i);
			if(i>=k-1) {
				out[j++]=nums[dq.peek()];
			}
		}
		
		for(int l=0;l<j;l++) {
			System.out.print(out[l]);
		}
	}

}
