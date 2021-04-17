package com.data.interviewBit;

public class ProbabilityXLTY {
	
	public double probability(int[] list1, int[] list2) {
	    int[] greaterElements = new int[list1.length];
	    for (int i = 0; i < list1.length; i++) {
	        int y = 0;
	        for (int j = 0 ; j < list2.length; j++) {//to search we can use binary search
	            if (list2[j] > list1[i])
	                y++;
	        }
	        greaterElements[i] = y;
	    }

	    int count = 0;
	    for (int i = 0; i < list1.length; i++)
	        count += greaterElements[i];
	   
	    return count / (list1.length * list2.length);
	}
	
	public static void main(String args[]) {
		ProbabilityXLTY p = new ProbabilityXLTY();
		int[] nums = {1,2,3,5,6,7,8,9};
		int val=5;
		int l = 0;
		int r = nums.length-1;
		int max = 0;
		while(l < r) {
			int mid = l+(r-l)/2;
			if(nums[mid]>val) {
				max = mid;//for number of smaller elemnets count = mid+1 but in num[mid]<val
				r = mid;
			}else {
				l=mid+1;
			}
		}
		System.out.println(nums.length-max);
		
		
	}
	
	

}



///1 2 3 5 6 7 8





