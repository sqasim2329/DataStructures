package com.data.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxEvenSumSubseqeunceOfLengthK {
	
	public static void main(String args[]) {
		
		int[] nums = {4, 2, 6, 7, 8};
		int k =3;
		
		System.out.println(maxEvenSum(nums,k));
		
	}

	private static int maxEvenSum(int[] nums, int k) {
		
		List<Integer> even =new ArrayList<>();
		List<Integer> odd =new ArrayList<>();
		int maxEvenSum =0;
		for(int i:nums) {
			if(i%2 == 0) 
				even.add(i);
			else
				odd.add(i);
		}
		Collections.sort(even);
		Collections.sort(odd);
		int i=even.size()-1;
		int j=odd.size()-1;
		while(k > 0) {
			if(k%2 ==1 ) {//if odd
				maxEvenSum += even.get(i);
				i--;
				k--;
			}else {
				if(i >=1 && j>=1) {
					if(even.get(i)+even.get(i-1) <= odd.get(j)+odd.get(j-1)) {
						maxEvenSum+=odd.get(j)+odd.get(j-1);
						j-=2;
					}else {
						maxEvenSum+=even.get(i)+even.get(i-1);
						i-=2;
					}
				}else if(i >=1) {
					maxEvenSum+=even.get(i)+even.get(i-1);
					i-=2;
				}else if(j >=1){
					maxEvenSum+=odd.get(j)+odd.get(j-1);
					j-=2;
				}
				k-=2;
			}
		}
		return maxEvenSum;
	}

}
/***
 * 
 *     4, 2, 6, 7, 8 k =3
 *     basic odd+ odd = even
 *     	even+ even = odd
 *     if K is odd then we need even always since if we keep an odd even + odd becomes odd which we donot want
 *     hence first for k%2==1 we add max from even list
 *     then we add 2 elemenst from odd list or 2 elemnts from even list
 * 
 * 	
 * 
 * 
 * *******/
