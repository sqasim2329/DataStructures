package com.data.linkedin;

public class GrowthIn2DimensionArray {
	
	public static void main(String args[]) {
		String[] nums = {"1 4", "2 3", "1 4"};
		int minRow = nums.length;
		int minCol = nums.length;
		
		for(String str:nums) {
			int r = Integer.parseInt(str.split(" ")[0]);
			int c = Integer.parseInt(str.split(" ")[1]);
			minRow = Math.min(minRow, r);
			minCol = Math.min(minCol, c);
		}
		System.out.println(minRow * minCol);
	}

}
