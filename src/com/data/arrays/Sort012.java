package com.data.arrays;

import java.util.Arrays;

public class Sort012 {
	
	public static void main(String args[]) {
		int arr[]= {0, 1, 2, 0, 1, 2};
		int n= arr.length;
		int cnt0=0,cnt1=0,cnt2=0;
		for(int i=0;i<n;i++) {
			switch(arr[i]) {
			case 0: cnt0++;
					break;
			case 1: cnt1++;
			break;
			case 2: cnt2++;
			break;
			}
		}
		int k=0;
		while(cnt0>0) {
			cnt0--;
			arr[k++]=0;
		}
		while(cnt1>0) {
			cnt1--;
			arr[k++]=1;
		}
		while(cnt2>0) {
			cnt2--;
			arr[k++]=2;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}

}
