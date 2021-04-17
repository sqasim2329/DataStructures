package com.data.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar {
	
	List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] arr:calendar){
            if(arr[0]<end && start < arr[1]){//vvvvvip
                return false;
            }
        }
        calendar.add(new int[]{start,end});
        return true;
    }
    
    class MyCalendarTwo {
        
        List<int[]> calendar;
        List<int[]> overlap;

        public MyCalendarTwo() {
            calendar = new ArrayList<>();
            overlap = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            for(int[] i:overlap){
                if(i[0] < end && start < i[1])
                    return false;
            }
            
            for(int[] i:calendar){
                 if(i[0] < end && start < i[1])
                    overlap.add(new int[]{Math.max(i[0],start),Math.min(i[1],end)});
            }
            
            calendar.add(new int[]{start,end});
            return true;
        }
    }

    
    
    class MyCalendarLogn {
        
        TreeMap<Integer,Integer> map;
        

        public MyCalendarLogn() {
        map = new TreeMap<>();    
        }
        
        public boolean book(int start, int end) {
            Integer prev = map.floorKey(start);
            Integer next = map.ceilingKey(start);
            if((prev == null || map.get(prev)<=start) && (next == null || end <= next)){
                map.put(start,end);
                return true;
            }
            
            return false;
        }
        
        public boolean isPresent(int point) {
        	Integer firstStart = map.floorKey(point);
        	Integer lastStart = map.ceilingKey(point);
        	
        	Integer end = map.get(lastStart);
        	return point >= firstStart && <= end;
        }
    }

}
