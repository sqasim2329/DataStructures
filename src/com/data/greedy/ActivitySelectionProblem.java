package com.data.greedy;

import java.util.Arrays;

public class ActivitySelectionProblem {
	
	class Activity{
		
		int start;
		int finish;
		
		public Activity(int start, int finish) {
			super();
			this.start = start;
			this.finish = finish;
		}
	}
	
	public static void main(String args[]) {
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};
		int arr[][] = {{5, 9}, {1, 2}, {3, 4}, {0, 6}, 
                {5, 7}, {8, 9}};
		Arrays.sort(arr, (a,b)->(a[1]-b[1]));
//		Arrays.sort(arr, (a,b)->(a[1]-b[1])*-1); 
		
		printMaxActivities(start,finish);
		printMaxActivities(arr);
		
		
	}

	private static void printMaxActivities(int[][] arr) {
		if(arr.length!=0) {
			printStartAndFinish(arr[0][0], arr[0][1]);
			int length = arr.length;
			int previousFinish = arr[0][1];
			for(int i =1; i <= length-1; i++ ) {
				if(previousFinish < arr[i][0]) {
					printStartAndFinish(arr[i][0], arr[i][1]);
					previousFinish = arr[i][1];
				}
			}
		}
		
	}

	private static void printMaxActivities(int[] s, int[] f) {
		if(s.length != 0 && f.length!=0) {
			printStartAndFinish(s[0],f[0]);
			int length = s.length;
			int previousFinish = f[0];
			for(int i=1; i < length-1; i++) {
				if(previousFinish <= s[i]) {
					printStartAndFinish(s[i],f[i]);
					previousFinish = f[i];
				}
			}
		}
		
	}

	private static void printStartAndFinish(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println(i+" to "+j);
	}
	
	

}
//can be easily using stack