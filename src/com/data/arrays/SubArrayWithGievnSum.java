package com.data.arrays;
//Sliding window technique
public class SubArrayWithGievnSum {
	
	public static void main(String args[]) {
		int []arr = {1, 4, 20, 3, 10, 5};
		int sum = 33;
		System.out.println(slidingWindow(arr, sum));
		
	}

	private static boolean slidingWindow(int[] arr, int sum) {
		int j=0;
		int csum = arr[0];
		int n= arr.length;
		for(int i=1;i<n;i++) {
			while(csum > sum) {
				csum -= arr[j];
				j++;
			}
			
			if(csum==sum) {
				int p=i-1;
				System.out.println(j+"--"+p);
				return true;
			}
			
			if(i<n) {
				csum+=arr[i];
			}
		}
		
		return false;
	}

}
