package com.data.google;

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
