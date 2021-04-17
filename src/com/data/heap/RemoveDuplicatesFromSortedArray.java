package com.data.heap;

public class RemoveDuplicatesFromSortedArray {
	

        
	public int removeDuplicates(int[] nums) {
        int i =0;
        
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        
        return i+1;// we have to give count oif elements
        
    }
        


}
