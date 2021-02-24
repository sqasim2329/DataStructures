package com.data.greedy;

import java.util.Arrays;
import java.util.Collections;

//?\https://www.geeksforgeeks.org/minimize-sum-product-two-arrays-permutations-allowed/
public class MinimiseSumOfProduct {
	
	public static void main(String args[]) {
	
	int a[] = { 6, 1, 9, 5, 4 } ;
	int b[] = { 3, 4, 8, 2, 4 };
	
	Arrays.sort(a);
	Arrays.sort(b);
	
	int j = a.length-1;
	int i = 0;
	int sum =0;
	while( i < a.length) {
		sum+=a[i++]*b[j--];
		
	}
	
	int sum2=0;
	for(int k=0;k<a.length;k++) {
		sum2+=a[k]*b[a.length-1-k];
	}
	System.out.println(sum);
	System.out.println(sum2);
	}
	

}
