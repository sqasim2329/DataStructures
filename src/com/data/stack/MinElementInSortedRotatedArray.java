package com.data.stack;

public class MinElementInSortedRotatedArray {
	
	public static void main(String args[]) {
//		int arr[]= {3,4,5,1,2};
		int arr[]= {2, 3, 4, 5, 6, 7, 8, 1};
		int l=0;
		int r=arr.length-1;
		while(l<r) {
			int mid = l+(r-l)/2;
			if(arr[mid]>arr[r]) {
				l = mid+1;
			}else {
				r=mid;
			}
		}
		int nums[]= {0,3,2,1};
		System.out.println(findMin(nums));
		
		
	}
	
public static int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        return nums[findMin(l,r,nums)];
        
        
    }
    
    private static int findMin(int l,int r,int[] nums){
       while(l<r) {
    	   if(nums[l]<nums[r])
    		   return nums[l];
    	   int mid = l+(r-l)/2;
    	   if(nums[mid]>=nums[l])
    		   l=mid+1;
    	   else
    		   r=mid;
       }
        return nums[l];
    }


}
