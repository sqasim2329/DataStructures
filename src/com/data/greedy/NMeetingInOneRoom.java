package com.data.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingInOneRoom {
	
	static class Meeting implements Comparable<Meeting>{
		int st;
		int end;
		int index;
		
		public Meeting(int st,int end, int index) {
			this.st=st;
			this.end =end;
			this.index =index;
		}
		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(this.end, o.end);
		}
	}
	
	public static void main(String args[]) {
//		int[][] arr= {{1,2},{3,4},{0,6},{5,7},{8,9},{5,9}};
		int[][] arr= {{75250,112960},{50074,114515},{43659,81825},{8931,93424},{11273,54316},{27545,35533},{50879,73383},{77924,160252}};
		List<Meeting> ls = new ArrayList<>();
		List<Integer> indx = new ArrayList<>();
		for(int i = 0 ; i < arr.length;i++)
			ls.add(new Meeting(arr[i][0],arr[i][1],i+1));
		
		Collections.sort(ls);
		int prev = ls.get(0).end;
		indx.add(ls.get(0).index);
		for(int i=1;i<ls.size();i++) {
			Meeting curr = ls.get(i);
			if(prev <= curr.st) {
				prev = curr.end;
				indx.add(curr.index);
				
			}
		}
		
		indx.stream().forEach(System.out::println);
		
		}
	
	
		
		
	}


