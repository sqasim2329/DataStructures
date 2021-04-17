package com.data.google;

import java.util.TreeMap;

public class MyCalendar3 {
	
	class MyCalendarThree {
	    
	    TreeMap<Integer,Integer> map;

	    public MyCalendarThree() {
	        map = new TreeMap<>();
	    }
	    
	    public int book(int start, int end) {
	        map.put(start, map.getOrDefault(start,0)+1);
	        map.put(end, map.getOrDefault(end,0)-1);
	        int ans = 0;
	        int active =0;
	        for(int val:map.values()){
	            active += val;
	            if(active > ans)
	                ans = active;
	        }
	        
	        return ans;
	    }
	}

	/**
	 * Your MyCalendarThree object will be instantiated and called as such:
	 * MyCalendarThree obj = new MyCalendarThree();
	 * int param_1 = obj.book(start,end);
	 */
	
//	Number of boundary for given start and end;

}


class MyCalendarThree {

    TreeMap<Integer, Integer> count;
    int max;

    public MyCalendarThree() {
        count = new TreeMap();
        count.put(-1, 0);
        max = 0;
    }
    
    public int book(int start, int end) {
        count.put(start, count.floorEntry(start).getValue());
        count.put(end, count.floorEntry(end).getValue());
        for(Map.Entry<Integer, Integer> entry : count.subMap(start, end).entrySet()){
            int val = entry.getValue() + 1;
            entry.setValue(val);
            max = Math.max(max, val);
        }
        return max;
    }
}
//https://leetcode.com/discuss/interview-question/613816/Google-or-Onsite-or-Meeting-Rooms-3/575219

//"static void main" must be defined in a public class.
public class Main {
 public static void main(String[] args) {
     System.out.println("Hello World!");
     int[][] intervals= {{1, 3}, {4, 6}, {6, 8}, {9, 11}, {6, 9}, {1, 3}, {4, 10}};
     int rooms=3;
     int[][] queries ={{1, 9}, {2, 6}, {7, 9}, {3, 5}, {3, 9}, {2, 4}, {7, 10}, {5, 9}, {3, 10}, {9, 10}};
     Main m = new Main();
     for(boolean bool:m.meetingRoomIII(intervals,rooms,queries)){
         System.out.println(bool);
     }
 }
 
 public boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
 TreeMap<Integer,Integer> events = new TreeMap<>();
 boolean[] res = new boolean[ask.length];
 for(int[] interval: intervals){
     events.put(interval[0], events.getOrDefault(interval[0], 0) + 1); //start event
     events.put(interval[1], events.getOrDefault(interval[1], 0) - 1); //end event
 }
 int i = 0;
 for(int[] query: ask){
     
     events.put(query[0], events.getOrDefault(query[0], 0) + 1); //start query
     events.put(query[1], events.getOrDefault(query[1], 0) - 1); //end query
     if(Num_Events(events) > rooms){
         events.put(query[0], events.getOrDefault(query[0], 0) - 1); //start query
         events.put(query[1], events.getOrDefault(query[1], 0) + 1); //end query
     }else{
         res[i] = true;
     }
     i++;
 }
 return res;
}
private int Num_Events(TreeMap<Integer, Integer> events) {
 int active_events = 0;
 int res = 0;
 for(int freq: events.values()){
     active_events += freq;
     res = Math.max(active_events, res);
 }
 return res; 
 }
}
