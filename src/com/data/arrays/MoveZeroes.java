package com.data.arrays;

public class MoveZeroes {
	
public void moveZeroes(int[] nums) {
        
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[index++] = nums[i];
        }
        
        for(int i =index;i<nums.length;i++){
            nums[i]=0;
        }
        
    }

}

/***
 * 
 * 
 * Input: [0,1,0,3,12]6777777777
Output: [1,3,12,0,0]
 * ***/
 