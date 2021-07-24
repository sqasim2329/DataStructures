package com.data.linkedin;

import java.util.Arrays;

public class SegregateEVenAndOddNumber {
	
	public static void main(String args[]) {
//		int[] a = {8, 22, 65, 70, 33, 60, 2, 34, 43, 21};
		int[] a= {18, 52, 37, 70, 3, 63, 2, 34};
			int mid = 0;
			int lo = 0;
			int hi = a.length-1;
			while(mid<=hi) {
				switch(a[mid]%2) {
				case 0: int tmp = a[lo];
						a[lo] = a[mid];
						a[mid] = tmp;
						lo++;
						mid++;
						break;
				case 1: int tmp2 = a[mid];
						a[mid] = a[hi];
						a[hi] = tmp2;
						hi--;
						break; 		
				}
			}
		
		Arrays.stream(a).forEach(System.out::println);
		
	}

}


