package com.data.heap;

public class RemoveDuplicatesFromSortedArray {
	

        
	public int removeDuplicates(int[] nums) {
        int i =0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;//i is 0th based indexing
        
    }
        


}
