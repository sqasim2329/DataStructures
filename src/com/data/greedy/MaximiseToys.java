package com.data.greedy;

import java.util.Arrays;

public class MaximiseToys {
	
	public static void main(String args[]) {
		int nums[]= {1,12,5,111,200,1000,10};
		int k= 50;
		int count =  0;
		Arrays.sort(nums);
		for(int n:nums) {
			if( (k-n) > 0 ) {
				k = k-n;
				count++;
			}else {
				break;
			}
		}
		
		
		System.out.println(count);
		
		
		
	}

}
