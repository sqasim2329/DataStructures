package com.data.arrays;

public class InCreasingTripletSubsequence {
	
	public static boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(min > num)
                min =num;
            else if(secMin > num && num > min)
                secMin = num;
            else if(num > secMin )
                return true;
            
        }
        return false;
    }
	
	public static void main(String args[]) {
//		int nums[]= {1,2,3,4,5};
		int nums[]= {1,4,3,2,1};
		System.out.println(increasingTriplet(nums));
	}

}
