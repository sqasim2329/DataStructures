package com.data.interviewBit;

public class FirstMissingPosiitveNumber {
	
	public int findNumber(int[] nums) {
        
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]>=0 && nums[i]<n && nums[nums[i]]!=nums[i])
                swap(nums,i,nums[i]);
            else
            i++;
        }
        
        int k=1;
        while(k<n && k==nums[k])
            k++;
        
        if(n==0 || k<n)
            return k;
        else
            return nums[0]==k?k+1:k;
        
    }
	
	private void swap(int nums[],int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
