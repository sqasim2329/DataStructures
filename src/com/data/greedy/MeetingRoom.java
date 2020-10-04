package com.data.greedy;

import java.util.Arrays;

public class MeetingRoom {
	
	static class Intervals{
		int st;
		int end;
	}
	
	public static void main(String args[]) {
		Intervals[] intervals = {};
		System.out.println(canAttendAllMeetings(intervals));
	}

	private static boolean canAttendAllMeetings(Intervals[] intervals) {
		Arrays.sort(intervals,(a,b)-> Integer.compare(a.end,b.end));
		Intervals firstInterval = intervals[0];
		for(int i=1;i<intervals.length;i++) {
			Intervals curr = intervals[i];
			if(firstInterval.end > curr.st) {
				return false;
			}
		}
		return true;
	}

}
