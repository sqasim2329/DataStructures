package com.data.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	
	static class orange{
		int x;
		int y;
		public orange(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String args[]) {
		int[][] arr= { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		Queue<orange> q1 = new LinkedList<>();
		Queue<orange> q2 = new LinkedList<>();
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[0].length; j++) {
				if(arr[i][j]==2) {
					q1.add(new orange(i,j));
				}
			}
		}
		Integer count=0;
		count= findTimeTakentoRotOranges(arr,q1,q2,count);
		System.out.println(count==0?-1:count);
		
	}

	private static Integer findTimeTakentoRotOranges(int[][] arr, Queue<orange> q1, Queue<orange> q2, Integer count) {
		while(!q1.isEmpty() || !q2.isEmpty()) {
		while(!q1.isEmpty()) {
			orange or = q1.poll();
			rotAndPopulateQueueWithOranges(arr,or,q2);
		}
		if(!q2.isEmpty()) {
			count++;
		}
		while(!q2.isEmpty()) {
			orange or = q2.poll();
			rotAndPopulateQueueWithOranges(arr,or,q1);
		}
		if(!q1.isEmpty()) {
			count++;
		}
		}
		
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[0].length; j++) {
				if(arr[i][j]==1) {
					count=-1;
				}
			}
		}
		return count;
	}

	private static void rotAndPopulateQueueWithOranges(int[][] arr,orange or, Queue<orange> q) {
		int i = or.x;
		int j = or.y;
		if((isValid(i+1,j,arr) && arr[i+1][j]==1)) {
			arr[i+1][j]=2;
			q.add(new orange(i+1,j));
		}
		 if((isValid(i,j+1,arr) && arr[i][j+1]==1)) {
			arr[i][j+1]=2;
			q.add(new orange(i,j+1));
		}
		 if((isValid(i-1,j,arr) && arr[i-1][j]==1)) {
			arr[i-1][j]=2;
			q.add(new orange(i-1,j));
		}
		 if((isValid(i,j-1,arr) && arr[i][j-1]==1)) {
			arr[i][j-1]=2;
			q.add(new orange(i,j-1));
		}
	}

	private static boolean isValid(int i, int j,int[][] arr) {
		if(i >= 0 && i <= arr.length-1 && j >= 0 && j <=arr[0].length-1)
		return true;
		else
			return false;
	}

}
