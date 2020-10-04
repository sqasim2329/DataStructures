package com.data.arrays;

import java.util.Arrays;

public class ReverseArrayInGroups {
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int k = 3; 
      
        int n = arr.length; 
        
        for(int i=0;i<n;i=i+k) {
        	int x =i;
        	int y = Math.min(i+k-1,n-1);
        	while(x < y) {
        		int tmp = arr[x];
        		arr[x] = arr[y];
        		arr[y] = tmp;
        		x++;
        		y--;	
        	}
        	
        }
        
        
        Arrays.stream(arr).forEach(System.out::println);
      
	}

}
