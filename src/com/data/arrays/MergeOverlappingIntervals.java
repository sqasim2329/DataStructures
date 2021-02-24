package com.data.arrays;

import java.util.Arrays;
import java.util.LinkedList;

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
		merge(nums);
	}

	public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        LinkedList<int[]> res = new LinkedList<>();
        for(int[] interval:intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0])
                res.add(interval);
            else
                res.getLast()[1]= Math.max(res.getLast()[1],interval[1]);
        }
        return res.toArray(new int[res.size()][]);
        
    }
	
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
		      return 0;
		    }
		    Arrays.sort(intervals,(a,b)-> a[1] - b[1]);
		    int prevEnd = intervals[0][1];
		    int count = 1;
		    for (int i = 1; i < intervals.length; i++) {
		      if (intervals[i][0] >= prevEnd) {
		        prevEnd = intervals[i][1];
		        count++;
		      }
		    }
		    return intervals.length - count;
		  }    
    }
	
	//Min arrows to burst ballons
	//I came up with the same solution. 
	//How did you solve it for input [[-2147483646,-2147483645],[2147483646,2147483647]]? 
	//use Integer.compare(a[0],b[0]);
	public int findMinArrowShots(int[][] points) {
        if(points.length == 0 || points[0].length==0)
            return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int prevEnd = points[0][1];
        int cnt = 1;
        for(int i=1;i<points.length;i++){
            if(prevEnd >= points[i][0]){
                prevEnd = Math.min(points[i][1],prevEnd);
            }else{
                prevEnd = points[i][1];
                cnt++;
            }
        }
        
        return cnt;       
        
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
