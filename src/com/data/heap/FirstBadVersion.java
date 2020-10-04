package com.data.heap;

public class FirstBadVersion {
	
public int firstBadVersion(int n) {
        
        int l=1;
        int r=n;
        
        while(l<r){
            int mid = l+(r-l)/2;
            if(isBadVersion(mid)){
                r = mid;
            }else{
                l=mid+1;
            }
        }
        return l;
        
    }

}

/******
 * 
 * 
 * 		[1,2,3,4,5]
 * 		[G,G,G,B,B]
 * check if mid is bad, if mid is bad, 1 st bad version might be on left hence r = mid;
 * check if mid is good, if mid is good, 1 st bad version will be on right hence l=mid+1;
 * 
 * 
 * ********/
