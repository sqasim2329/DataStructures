package com.data.hashing;

import java.util.HashSet;
import java.util.Set;

public class TwoUnsortedArrayPairsWithSumX {
	
	public static void main(String args[]) {
//		int arr1[] = {-1, -2, 4, -6, 5, 7};
//        int arr2[] = {6, 3, 4, 0};
		
		int arr1[] = {1, 2, 4, 5, 7};
        int arr2[] = {5, 6, 3, 4, 8}; 
        int x =9;
        Set<Integer> set = new HashSet<>();
        if(arr1.length > arr2.length) {
        	addinSet(set,arr2);
        	checkAndPrint(arr1,set,x);
        }
        else {
        	addinSet(set,arr1);
        	checkAndPrint(arr2,set,x);
        }
        
        
	}

	private static void checkAndPrint(int[] arr1, Set<Integer> set, int x) {
		for(int i=0;i<arr1.length;i++)
			if(set.contains(x-arr1[i])) {
				int p=x-arr1[i];
				System.out.println(arr1[i]+" "+p);
			}
		
	}

	private static void addinSet(Set<Integer> set, int[] arr2) {
		for(int i=0;i<arr2.length;i++) {
			set.add(arr2[i]);
		}
		
	}

}

//https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
//use map
