package com.data.hashing;

import java.util.HashSet;
import java.util.Set;

public class PairSwappingMakesSumOftwoArraySame {
	
	public static void main(String args[]) {
//		int a[]= {4, 1, 2, 1, 1, 2};
//		int b[]= {3, 6, 3, 3};
		int a[]= {5, 7, 4, 6};
		int b[]= {1, 2, 3, 8};
		int x = a.length;
		int y = b.length; 
		int sum1 = getSum(a);
		int sum2 = getSum(b);
		int diff = Math.abs((sum1-sum2)/2);
		if(diff==0) {
			System.out.println("No Swap");
			return;
		}
		if( x>y )
		printSwapPairs(a,b,diff);
		else
		printSwapPairs(b,a,diff);
	}

	private static void printSwapPairs(int[] a, int[] b, int diff) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<b.length;i++) {
			set.add(b[i]);
		}
		
		for(int i=0;i<a.length;i++) {
			if(set.contains(a[i]+diff)) {
				int p = a[i]+diff;
				System.out.println(a[i]+" "+p);
				return;
			}
		}
		
		
	}

	private static int getSum(int[] a) {
		int sum =0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		return sum;
	}

}
