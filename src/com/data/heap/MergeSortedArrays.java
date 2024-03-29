package com.data.heap;
//edge case [0],0  [1],1->[1]
public class MergeSortedArrays {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j=n-1;
        int p=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[p]=nums2[j];
                j--;
            }else{
                nums1[p]=nums1[i];
                i--;
            }
            p--;
        }
        
        System.arraycopy(nums2,0,nums1,0,j+1);
    }

}
/********
 * 
 * 4,5,6,0,0
 * 1,2
 * 
 * 
 * 
 * /
 */