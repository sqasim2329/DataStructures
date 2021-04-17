package com.data.google;

import java.util.ArrayList;
import java.util.List;

public class SunSetView {
	
	public static void main(String args[]) {
		int[] nums= {3,4,6,4,3,4,5,6};
		List<Integer> ls = new ArrayList<>();
		int count=1;
		int max = nums[0];
		ls.add(max);
		for(int i=1;i<nums.length;i++) {
			if(nums[i]> max) {
				max = nums[i];
				ls.add(max);
				count++;
			}
		}
		ls.forEach(System.out::print);
		System.out.println(count);
	}

}
