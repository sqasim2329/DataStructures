package com.data.divideAndConquer;

public class MostOccurringElmeentInSortedArray {
	
	public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = {0,1,1,2,2,2,2,7,7,7,9,9,9};
        int lo=0;
        int hi=nums.length-1;
        int max=0;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;   
            int first = findFirstPosofMid(nums[mid],nums);
            int last = findLastPosofMid(nums[mid],nums);
            max = Math.max(max,last-first+1);
            if((nums.length-1) - last <= max){// max represenst the max length, if (nums.length-1)-last pos <= max then there is no use of search on right side hence searhc on left side 
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        System.out.println(max);
    }
    
    private static int findFirstPosofMid(int val,int[] nums){
        int lo=0;
        int hi=nums.length-1;
        int indx=-1;
        while(lo <= hi){
            int mid =lo+(hi-lo)/2;
            if(nums[mid]>=val){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
            if(nums[mid]==val)
                indx = mid;
        }
        return indx;
    }
    
    private static int findLastPosofMid(int val,int[] nums){
        int lo=0;
        int hi=nums.length-1;
        int indx=-1;
        while(lo <= hi){
            int mid =lo+(hi-lo)/2;
            if(nums[mid]<=val){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
            if(nums[mid]==val)
                indx = mid;
        }
        return indx;
    }

}
