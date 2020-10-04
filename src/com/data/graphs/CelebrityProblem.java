package com.data.graphs;
//https://www.geeksforgeeks.org/the-celebrity-problem/
//https://practice.geeksforgeeks.org/problems/x-total-shapes/0
public class CelebrityProblem {
	
	public static void main(String args[]) {
		int MATRIX[][] = { {0, 0, 1, 0},
		           {0, 0, 1, 0},
		           {0, 0, 0, 0},
		           {0, 0, 1, 0} };
		
		System.out.println(findCelebrity(MATRIX));
	}

	private static int findCelebrity(int[][] mATRIX) {
		int n = mATRIX.length;
		int celeb = 0;
		for(int i=1;i<n;i++) {
			if(knows(celeb,i,mATRIX))
				celeb =i;
		}
		
		for(int i=0;i<n;i++) {
			if(i!=celeb && (knows(celeb,i,mATRIX) || !knows(i,celeb,mATRIX)))
				return -1;
		}
		return celeb;
	}

	private static boolean knows(int celeb, int i, int[][] mATRIX) {
		return mATRIX[celeb][i]==1;
	}

}
