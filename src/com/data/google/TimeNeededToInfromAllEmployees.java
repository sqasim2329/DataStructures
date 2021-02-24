package com.data.google;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToInfromAllEmployees {
	class Solution {
	    //since it is tree no need of visited array
	    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
	        
	        LinkedList<Integer> []g= new LinkedList[n];
	        for(int i=0;i<n;i++){
	            g[i] = new LinkedList<>();
	        }
	        
	        for(int i=0;i<manager.length;i++){
	            if(manager[i]==-1)continue;
	            g[manager[i]].add(i);
	        }
	        
	        int totalTime =0;
	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[]{headID,0});// manger and timetaken for news to reach this manager
	        while(!q.isEmpty()){
	                int[] s = q.poll();
	                int managerr = s[0];
	                int timeTakenForNews = s[1];
	                totalTime=Math.max(totalTime,timeTakenForNews);
	                for(int adj:g[managerr]){
	                        q.add(new int[]{adj,informTime[managerr]+timeTakenForNews});//timetaken for news to adj from manager + timeTakenFornews
	                    }
	            }
	       
	        
	        return totalTime;
	    }
	    
	    
	}


}
