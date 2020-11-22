package com.data.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFormedFromArray {
	
	public static void main(String args[]) {
		
//		int arr[]= {54, 546, 548, 60};
		int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
//		sort with comparator will not for primitive values in array 
//		Arrays.sort(arr,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				String a=String.valueOf(o1)+String.valueOf(o2);
//				String b=String.valueOf(o2)+String.valueOf(o1);
//				return a.compareTo(b)*-1;
//			}
//			
//		});
		
		
		List<Integer> ls = new ArrayList<>();
		for(int i=0;i<arr.length;i++)
			ls.add(arr[i]);
		Collections.sort(ls,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) 
			 {
				String a=String.valueOf(o1)+String.valueOf(o2);
				String b=String.valueOf(o2)+String.valueOf(o1);
				return a.compareTo(b)*-1;
			}
		});
		
		ls.stream().forEach(System.out::print);
		
	}

}
