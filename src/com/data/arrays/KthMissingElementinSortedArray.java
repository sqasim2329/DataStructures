package com.data.arrays;
//kth missing elem in unsorted arr, just do a sort and then us ebelow techonoque
public class KthMissingElementinSortedArray {
	
	public static void main(String args[]) {
//		int a[] = {2, 3, 5, 9, 10};
//		int k=1;
//		int a[] = {2, 3, 5, 9, 10, 11, 12};       
//        int k = 4;
		int []a = {1, 5, 11, 19}; 
		int k = 11; 
		int count = k;
		for(int i=0;i<a.length;i++) {
			if(a[i]+1!=a[i+1]) {
				int diff =a[i+1]-a[i]-1;
				if(diff >=count) {
					System.out.println(a[i]+count);
					break;
				}else {
					count = count-diff;//get rid of not required missing elemt;
				}
			}
		}
		
	}
	
}

