package com.data.arrays;
//in 0(1) space
public class RearrangeArrayMaxMin {
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6};//{1, 2, 3, 4, 5, 6, 7};
		int i=0;
		int j=arr.length-1;
		int out[]= new int[arr.length];
		int k=0;
		while(i<=j) { // for both even/odd number of elem
			if(i==j)
				out[k]=arr[i++];
			else {
				out[k++]=arr[j--];
				out[k++]=arr[i++];
			}
		}
		
		for(int n:out) {
			System.out.print(n+" ");
		}
	}
}
