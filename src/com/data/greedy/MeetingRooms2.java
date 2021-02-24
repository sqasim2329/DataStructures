package com.data.greedy;

import java.util.Arrays;
import java.util.Comparator;
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
	
	public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[]a, int b[]){
                return a[1]-b[1];
            }
        });
        pq.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            int[] existing = pq.poll();
            if(existing[1]<=intervals[i][0]){
                existing[1]=intervals[i][1];
            }else{
                pq.add(intervals[i]);
            }
            pq.add(existing);
        }
        
        return pq.size();
    }

}
