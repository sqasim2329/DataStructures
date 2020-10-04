package com.data.arrays;

import java.util.Arrays;

public class MinimumPlatformsRequired {
	
	private int findPlatform(int arr[], int dep[], int n) 
	{ 
	   
	   Arrays.sort(arr); 
	   Arrays.sort(dep); 
	   
	   int plat_needed = 0, result = 0; 
	   int i = 0, j = 0; 
	   while (i < n && j < n) 
	   { 

	      if (arr[i] <= dep[j]) 
	      { 
	          plat_needed++; 
	          i++;  
	          if (plat_needed > result)  
	              result = plat_needed; 
	      }  
	      else
	      { 
	          plat_needed--; 
	          j++; 
	      } 
	   } 
	   
	   return result; 
	} 
	
	public static void main(String args[]) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 }; 
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 }; 
        int n = arr.length; 
        MinimumPlatformsRequired m= new MinimumPlatformsRequired();
        System.out.println(m.findPlatform(arr, dep, n));
	}

}
