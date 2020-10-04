package com.data.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	
	 public int[] intersection(int[] nums1, int[] nums2) {
	        
	        int i =0;
	        int j =0;
	        Set<Integer> res = new HashSet<>();
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        while(i<nums1.length && j < nums2.length){
	            if(nums1[i] < nums2[j])
	                i++;
	            else if(nums2[j] < nums1[i])
	                j++;
	            else{
	                res.add(nums1[i]);
	                i++;
	                j++;
	            }
	        }
	        return res.stream().mapToInt(k->k).toArray();
	    }
	 

}


/********
 * 
 * 
 *  Can you two sets and detrmine common ele
 *  change Set to list for Intersection of two sorted arrays2 
 * 
 * ****/
 