package com.data.arrays;
//1 to n
public class FindMissingNumber {
	
	public static void main(String args[]) {
		int a[] = {1,2,4,5};
		
		int m = a[0];
		int n = 1;
		
		for(int i=1;i<a.length;i++) {
			m=m^a[i];
		}
		
		for(int j=2;j<=a.length+1;j++)// including the missing number  or max element
		{
			n=n^j;
		}
		
		System.out.println((m^n));
		
	}

}
