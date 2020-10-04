package com.data.arrays;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {
	
//	static class Interval{
//		int start;
//		int end;
//		public Interval(int start, int end) {
//			this.start=start;
//			this.end =end;
//		}
//	}
	
	
	
	public static void main(String args[]) {
//		Interval arr[]=new Interval[4]; 
//        arr[0]=new Interval(6,8); 
//        arr[1]=new Interval(1,9); 
//        arr[2]=new Interval(2,4); 
//        arr[3]=new Interval(4,7);
        
//        arr[0]=new Interval(1,9); 
//        arr[1]=new Interval(2,4); 
//        arr[2]=new Interval(5,7); 
//        arr[3]=new Interval(6,8);
		int nums[][]= {{6,8},{5,7},{1,9},{2,4},{10,11}};
        mergeIntervals(nums);
	}

private static void mergeIntervals(int[][] nums) {
	Arrays.sort(nums,(i1,i2)->Integer.compare(i1[0], i2[0]));
	Stack<int[]> s = new Stack<>();
	s.push(nums[0]);
	for(int i=1;i<nums.length;i++) {
		if(s.peek()[1] >= nums[i][0]) {
			s.peek()[1]=Math.max(s.peek()[1], nums[i][1]);
		}else {
			s.push(nums[i]);
		}
	}
	
	while(!s.isEmpty()) {
		System.out.println(s.peek()[0]+" "+s.peek()[1]);
		s.pop();
	}
}



//	private static void mergeIntervals(Interval[] arr) {
//		Arrays.sort(arr,new Comparator<Interval>() {
//
//			@Override
//			public int compare(Interval o1, Interval o2) {
//				
//				return (o1.start-o2.start) *-1;
//			}
//			
//		});
//		int index=0;
//		for(int i=1;i<arr.length;i++) {
//			if(isOverlapping(arr[index],arr[i])) {
//				arr[index].end=Math.max(arr[index].end, arr[i].end);
//				arr[index].start=Math.min(arr[index].start, arr[i].start);
//				arr[i].end =-1;//so that we can skip this object
//				arr[i].start =-1;
//			}else {
//				index=i;
//			}
//		}
//		
//		for(int i=0;i<=index;i++) {
//			if(arr[i].start!=-1)
//			System.out.println(arr[i].start+"--"+arr[i].end);
//		}
//		
//		
//		
//	}
//
//
//
//	private static boolean isOverlapping(Interval i, Interval j) {
//		return ((i.end >=j.start && i.end <=j.end)||(j.end >=i.start && j.end <=i.end));
//	}

}
