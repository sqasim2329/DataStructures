package com.data.linkedin;

public class MergeTwoSortedArraysWOAnyExtraSpace {
	
public void merge(int arr1[], int arr2[], int n, int m) {
        
        int i = 0;
        int j = 0;
        int k = arr1.length-1;
        while(i <= k && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }else{
                int tmp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = tmp;
                k--;
                j++;
            }
        }
        
            Arrays.sort(arr2);
            Arrays.sort(arr1);
        // code here
    }



}
