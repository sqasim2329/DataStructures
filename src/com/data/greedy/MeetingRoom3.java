package com.data.greedy;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom3{
	List<int[]>
	public List<Boolean> meetingRoom(int[][] cal, int[][] queries){
		List<Boolean> result = new ArrayList<>();
		for(int[] query:queries ) {
			if(checkIfValid(query,cal))
				result.add(true);
			else
				result.add(false);
		}
		
		return result;
	}
	
	private boolean checkIfvalid(int[] query,int[] calendar) {
		boolean flag = true;
		for(int i=0;i<calendar.length;i++) {
			int lo = Math.max(query[0], calendar[0]);
			int hi = Math.min(query[1], calendar[1]);
			if(lo < hi) {
				flag=false;
				break;
			}
				
		}
		
		return true;
	}

}
