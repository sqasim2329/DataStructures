package com.data.dynamicProgramming;

public class FindEqaulO1inarray {
	static class m{
		int i=0;
	}
	
	void method() {
		m M=new m();
		System.out.println( M.i);
	}
	
	public static void main(String args[]) {
		int arr[]= {1,-1,1,1,1,-1,-1};
		findMaxCount(arr);
	}

	private static void findMaxCount(int[] arr) {
		
		int sum=0,count=0,j=0;
		while(j<=arr.length-1) {
			for(int i=j;i<=arr.length-1;i++) {
				sum=sum+arr[i];
				
				if(sum==0 && count < i-j+1) {
					count = i-j+1;
				}
			}
			sum = 0;
			j++;
		}
		System.out.println(count);
	}

}
