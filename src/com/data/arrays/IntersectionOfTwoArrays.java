package com.data.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//use hashmap for optimized performance
public class IntersectionOfTwoArrays {
	
	 public int[] intersection(int[] nums1, int[] nums2) {
		 Set<Integer> set = new HashSet<>();
	        List<Integer> ls = new ArrayList<>();
	      for(int i:nums1)
	          set.add(i);
	        
	        for(int i:nums2)
	            if(set.contains(i)){
	                set.remove(i);
	                 ls.add(i);   
	            }
	        
	        return ls.stream().mapToInt(i->i).toArray();
	    }
	    }
	 
	 
	 public int[] intersection(int[] nums1, int[] nums2) {
	        
	        Set<Integer> set = new HashSet<>();
	        Set<Integer> set2 = new HashSet<>();
	        for(int x:nums1){
	            set.add(x);
	        }
	        for(int x:nums2){
	            set2.add(x);
	        }
	        List<Integer> ls = new ArrayList<>();
	        for(int x:set2){
	            if(set.contains(x)){
	                ls.add(x);
	            }
	        }
	        
	        return ls.stream().mapToInt(i->i).toArray();
	        
	    }
	 
	 
	 public int[] intersect2(int[] nums1, int[] nums2) {
         Map<Integer,Integer> map = new HashMap<>();
         List<Integer> ls = new ArrayList<>();
         for(int i:nums1){
             map.put(i,map.getOrDefault(i,0)+1);
         }
     
     for(int i:nums2){
             if(map.containsKey(i) && map.get(i)!=0){
                 ls.add(i);
                 map.put(i,map.get(i)-1);
             }
         }
     
     return ls.stream().mapToInt(k->k).toArray();
 }
	 
	 public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
	        
	        int i=0,j=0,k=0;
	        int n1=arr1.length;
	        int n2=arr2.length;
	        int n3=arr3.length;
	        List<Integer>  res = new ArrayList<>();
	        while(i<n1 && j <n2 && k<n3){
	            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
	                res.add(arr1[i]);
	                i++;j++;k++;
	            }
	            
	            else if(arr1[i] < arr2[j])
	                i++;
	            else if(arr2[j] < arr3[k])
	                j++;
	            else 
	                k++;
	        }
	        
	        return res;
	        
	    }
	 

}


/********
 * 
 * 
 *  Can you two sets and detrmine common ele
 *  change Set to list for Intersection of two sorted arrays2 
 *  
 *  can you use two sets to add values and check from the smaller set
 *  for intersection2 problem use a map<ele, freqOfEleme> if elem found reduce freq by 1 and add to list
 * ****/
 