package com.data.dynamicProgramming;
//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/ 
public class LargestSUmContigousSubarray {
	
	public static void main(String args[]) {
		
		int arr[]= {-2, -3,, -3};
		System.out.println(maxSubArraySum(arr));
	}

	private static int findSum(int[] arr) {
		int maxEH = 0;
		int maxSF = 0;
		int start =0;
		int end =0;
		for(int i=0; i < arr.length;i++) {
			maxEH = maxEH + arr[i];
			if(maxEH < 0) {
				maxEH = 0;
				
			}
			g
			if(maxSF < maxEH) {
				maxSF = maxEH;
				start =end;
				end = i;
			}
		}
		System.out.println(start+"-->"+end);
		return maxSF;
	}
	//if all are negative numbers
	private static int maxSubArraySum(int a[]) 
    { 
    int max_so_far = a[0]; 
    int curr_max = a[0]; 
  
    for (int i = 1; i < a.length; i++) 
    { 
           curr_max = Math.max(a[i], curr_max+a[i]); 
        max_so_far = Math.max(max_so_far, curr_max); 
    } 
    return max_so_far; 
    } 

}
