package com.data.google.microsoft;

import java.util.Arrays;

public class MaxProfitInJobScheduling {
	
	class Job{
        int start;
        int end;
        int profit;
        public Job(int start,int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
      for(int i=0;i<startTime.length;i++){
            jobs[i]=new Job(startTime[i],endTime[i],profit[i]);
      }
        Arrays.sort(jobs,(a,b)->(a.end-b.end));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0]=jobs[0].profit;
        for(int i=1;i<n;i++){
            int prof = jobs[i].profit;
            //search for previous job which does not overlap and give profit
            int prevIndex = binarySearch(jobs,i);
            if(prevIndex!=-1)
                prof+=dp[prevIndex];
            
            dp[i]=Math.max(prof,dp[i-1]);
        }
        
        return dp[n-1];
    }
    
    private int binarySearch(Job[] jobs,int index){
        int l = 0;
        int r =index-1;
        while(l <= r){
            int mid=l+(r-l)/2;
            if(jobs[mid].end <= jobs[index].start){
                if(jobs[mid+1].end <= jobs[index].start)
                    l=mid+1;
                else
                    return mid;
            }else
                r = mid-1;
        }
        return -1;
    }
    
    
    
}

}
