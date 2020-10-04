package com.data.arrays;

import java.util.HashMap;
import java.util.Map;
//can do better than o(n^2)?
public class PythagoreanTriplets {
	
	public static void main(String args[]) {
		int arr[]= {3,7, 2,24,12,1,5,6,4,9,13,10,25};
		int n= arr.length;
		Map<Integer,Integer> freqMap = new HashMap<>();
		for(int i=0;i<n;i++) {
			freqMap.put(arr[i]*arr[i],arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				Integer x =(arr[i]*arr[i])+(arr[j]*arr[j]);
				if(freqMap.get(x)!=null) {
					System.out.print(arr[i]+" "+arr[j]+" "+Math.sqrt(x));
					System.out.println();
				}
			}
		}
	}

}
