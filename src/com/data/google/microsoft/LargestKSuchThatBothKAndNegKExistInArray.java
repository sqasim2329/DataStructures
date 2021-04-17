package com.data.google.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestKSuchThatBothKAndNegKExistInArray {
	
	public static void main(String args[]) {
		int[] inp = {3, 2, -2, 5, -3};
		method1(inp);
		method2(inp);
	}
	private static void method2(int[] inp) {
		int i = 0; int j=inp.length-1;
		Arrays.sort(inp);
		int max = 0;
		while(i < j) {
			int sum = inp[i]+inp[j];
			if(sum == 0)
				max = Math.max(max, Math.abs(inp[i]));
			if(sum < 0) {
				i++;
			}else {
				j--;
			}
		}
		
		System.out.println(max);
		
		
	}
	//O(n) time and O(n) space
	private static void method1(int[] inp) {
		Set<Integer> seen = new HashSet<>();
		int max = 0;
		for(int i:inp) {
			if(seen.contains(-i)) {
				max = Math.max(max, Math.abs(i));
			}
			seen.add(i);
		}
		System.out.println(max);
	}

}
