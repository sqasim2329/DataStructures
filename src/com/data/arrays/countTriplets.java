package com.data.arrays;
//A+B=C//use map if you have large number of elem or arr is fine
public class countTriplets {
	
	public static void main(String args[]) {
		int arr[]= {1 ,5, 3, 2};
		int freq[]=new int[100];
		int n=arr.length;
		for(int i=0;i<n;i++) {
			freq[arr[i]]++;
		}
		int count =0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(freq[arr[i]+arr[j]]>0)
					count++;
			}
		}
		
		System.out.println(count);
	}
	
	

}
