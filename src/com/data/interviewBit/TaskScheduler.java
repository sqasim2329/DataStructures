package com.data.interviewBit;

public class TaskScheduler {
	
	class Solution {
	    public int leastInterval(char[] tasks, int n) {
	        
	        int[] freq = new int[26];
	        for(char task:tasks){
	            freq[task-'A']++;
	        }
	        Arrays.sort(freq);
	        int idleSlots = freq[25]-1;//if you have 2 tasks then in between 1 idle slot, hence 2 tasks -1 is the answer
	        int idleSlotsPeriod = idleSlots * n;
	        for(int i=24;i>=0;i--){
	            idleSlotsPeriod -= Math.min(freq[i],idleSlots); // A__A__A now BBB can be in between  either take idle sots/ tasks to complete whichever is minimum
	        }
	        //cannot have task of 4 freq in idle slots of 2 units
	        return idleSlotsPeriod>0?idleSlotsPeriod+tasks.length:tasks.length;
	        
	    }
	}




}
