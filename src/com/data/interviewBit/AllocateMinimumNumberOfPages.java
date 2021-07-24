package com.data.interviewBit;
//In this problem we want to find: Maximum of minimum total sweetness
//In "Split Array Largest sum" we want to find: Minimum of maximum largest sum
//
//In both places we do binary search on target answer, the difference is subtle but the key:
//
//In this when we overshoot the target, we will include that number in previous sum, as that is how we will maintain the target as the minimum number and binary search will find this optimal minimum
//In "Split Array Largest sum" when we overshoot the target, we will include the number in the next sum, so we can ensure all numbers are less than target - binary search does the rest of the magic
//https://leetcode.com/problems/koko-eating-bananas/
//	https://leetcode.com/problems/minimize-max-distance-to-gas-station/
//lo = min
//hi = sum
//Allocate pages  
//maximizeSweetness

//lo = max
//hi = sum
//split array
//painters parttion
//ship within d days

//lo = 1
//hi = max
//cut ribbon equal lengths
//koko
public class AllocateMinimumNumberOfPages {
	
	public static int allocatePages(int m, int [] pages) {
		int lo = Integer.MAX_VALUE;
		int hi = 0;
		for(int i=0;i<pages.length;i++) {
			lo = Math.min(lo, pages[i]);
			hi +=pages[i];
		}
		
		while(lo <= hi) {
			
			int mid = lo+(hi-lo)/2;
			int staudentsRequired = countStudentsForPages(mid,pages);
			if(staudentsRequired > m)
				lo= mid+1;
			else
				hi= mid-1;
		}
		
		return lo;
	}
	
	private static int countStudentsForPages(int num, int[]pages) {
		int count = 1;
		int totalPages = 0;
		for(int i:pages) {
			totalPages +=i;
			if(totalPages > num) {
				count++;
				totalPages = i;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		int pages[] = {12, 34, 67, 90};
		int m=2;
		System.out.println(allocatePages(m,pages));
	}
	
	public int maximizeSweetness(int[] sweetness, int K) {
        int lo=Integer.MAX_VALUE/10;
        int hi=0;
        for(int sweet:sweetness)
        {
            lo = Math.min(lo,sweet);
            hi += sweet;
        }
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int cut = getCutForSweetnes(mid,sweetness);
            if(cut > K)
                lo= mid+1;
            else
                hi=mid-1;
        }
        
        return lo;
    }
    
    private int getCutForSweetnes(int mid,int[] nums){
        int cnt =0;
        int sum =0;
        for(int i:nums){
            sum+=i;
            if(sum > mid){
                sum = 0;
                cnt++;
            }
        }
        return cnt;
    }

}
