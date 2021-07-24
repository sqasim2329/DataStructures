package com.data.linkedin;

import java.util.ArrayList;
import java.util.List;

public class AllNumberDisappearedInArray {
	
	class Solution {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	    	public List<Integer> findDisappearedNumbers(int[] nums) {
	            for(int i=0;i<nums.length;i++){
	                int index = Math.abs(nums[i])-1;
	                if(nums[index] > 0)
	                    nums[index]=-nums[index];
	            }
	            List<Integer> ls = new ArrayList<>();
	            for(int i=0;i<nums.length;i++){
	                if(nums[i]>0)
	                ls.add(i+1);
	            }
	            
	            return ls;
	        }
	}


	// 3,2,3,4,8,2,7,1
	    
	    
	    
	//[4,3,2,7,8,2,3,1]

	    

	    
	    
	    
	    4,3,2,7,8,2,3,1
	    1,2,3,4,3,2,7,8    
	        
//find index of curr num, since elemenst are between 1 to N index of curr num will number-1;
// check if number at index is greater than 0 then mark it as negative
// filter only the positive number and add 1 to the index of that pos number and add to list	    
	    
}
