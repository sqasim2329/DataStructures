package com.data.arrays;
//google onsite interview question
public class ZigZagArray {
	
	public static void main(String args[]) {
		int arr[] ={4, 3, 7, 8, 6, 2, 1};
		
		method1(arr);
		
		
	      
	}
	private static void method1(int[] arr) {
		boolean flag=true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (flag) {
				if(arr[i]>arr[i+1]) {
					swap(i,i+1,arr);
				}
			}else {
				if(arr[i]<arr[i+1]) {
					swap(i,i+1,arr);
				}
			}
			flag=!flag;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.println();
		}
		
		
	}
	
	private static void swap(int i, int j,int arr[]) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}

//wiggle sort
public void wiggleSort(int[] nums) {
    int n = nums.length;
    boolean less = true;
    for(int i=0;i<n-1;i++){
        if(less){
            if(nums[i]>nums[i+1] )
                swap(nums,i,i+1);
        }
        else{
        if( nums[i]<nums[i+1] )
            swap(nums,i,i+1);
        }
        less = !less;
    }
}

private void swap(int[] nums,int i , int j){
    
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
}

	




//https://practice.geeksforgeeks.org/problems/last-index-of-1/0 -- start from right
//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
//https://www.geeksforgeeks.org/find-minimum-difference-pair/ -- sort the arr and then find difference b/w i and i+1

//https://www.geeksforgeeks.org/find-number-pairs-xy-yx/--look before interview


//find duplicate in array
//subaarray with size k
//rain water
//slidind window maximuym
//3sum
//2sum

//https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/