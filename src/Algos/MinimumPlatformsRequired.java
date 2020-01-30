package Algos;

public class MinimumPlatformsRequired {
	
	static int findPlatform(int arr[], int dep[], int n) 
	{ 
	   
	   Arrays.sort(arr); 
	   Arrays.sort(dep); 
	   
	   // plat_needed indicates number of platforms 
	   // needed at a time 
	   int plat_needed = 1, result = 1; 
	   int i = 1, j = 0; 
	   
	   // Similar to merge in merge sort to process  
	   // all events in sorted order 
	   while (i < n && j < n) 
	   { 
	      // If next event in sorted order is arrival,  
	      // increment count of platforms needed 
	      if (arr[i] <= dep[j]) 
	      { 
	          plat_needed++; 
	          i++; 
	   
	          // Update result if needed  
	          if (plat_needed > result)  
	              result = plat_needed; 
	      } 
	   
	      // Else decrement count of platforms needed 
	      else
	      { 
	          plat_needed--; 
	          j++; 
	      } 
	   } 
	   
	   return result; 
	} 

}
