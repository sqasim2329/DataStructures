package com.data.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FindEqaulO1inarray {
	static class m{
		int i=0;
	}
	
	void method() {
		m M=new m();
		System.out.println( M.i);
	}
	
	public static void main(String args[]) {
		int arr[]= {1, 0, 1, 1, 1, 0, 0};
		findMaxCount(arr);
		findMaxCountMap(arr);
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
	
	private static void findMaxCountMap(int []arr) {
		int sum =0;
		int maxLen =0;
		int start =0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(sum == 0)
			{
				maxLen =i+1;
				start = 0;
			}
			
			if(map.containsKey(sum)) {
				int tmp = map.get(sum)+1;
				if(maxLen < i-tmp+1) {// i-tmp will exclue tmp
					maxLen = i-tmp+1;
					start = tmp;
				}
			}else {
				map.put(sum,i);
			}
		}
		System.out.println(maxLen+"--->"+start+"-");
	}

}
