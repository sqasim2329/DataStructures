package com.data.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	
	
	static class Intervals{
		int st;
		int end;
	}
	
	
	public static void main(String args[]) {
		Intervals[] intervals = {};
		System.out.println(minMeetingRooms(intervals));
		
	}


	private static int minMeetingRooms(Intervals[] intervals) {
		Arrays.sort(intervals,(a,b)-> Integer.compare(a.st,b.st));
		PriorityQueue<Intervals> q = new PriorityQueue<>((a,b)->Integer.compare(a.end, b.end));
		q.add(intervals[0]);
		for(int i=1;i<intervals.length;i++) {
			Intervals curr = intervals[i];
			Intervals existing = q.poll();
			if(curr.st >= existing.end) {
				existing.end = curr.end;
			}else {
				q.add(curr);
			}
			q.add(existing);
			
		}
		return q.size();
	}

}
