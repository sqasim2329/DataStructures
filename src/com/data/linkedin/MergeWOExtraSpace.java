package com.data.linkedin;

public class MergeWOExtraSpace {
	
	public void merge(int arr1[], int arr2[], int n, int m) {
        int x = arr1.length;
        int y = arr2.length;
        int gap = (x+y);
        gap = gap/2 + gap%2;
        while(gap>1){
            int i = 0;
            int j = i+gap-1;
            while(j < x){
                checkNSwap(arr1,arr1,i,j);
                i++;
                j++;
            }
            
            j=0;
            while(i < x && j < y){
                checkNSwap(arr1,arr2,i,j);
                i++;
                j++;
            }
            
            
            i=0;
            while(j < y){
                checkNSwap(arr2,arr2,i,j);
                i++;
                j++;
            }
            gap = gap/2 + gap%2;
        }
        
    }
    
    private void checkNSwap(int[] arr1, int[] arr2, int i, int j){
        if(arr1[i]>arr2[j]){
            int tmp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = tmp;
        }
    }

}
