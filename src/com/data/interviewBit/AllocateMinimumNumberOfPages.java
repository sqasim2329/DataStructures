package com.data.interviewBit;

public class AllocateMinimumNumberOfPages {
	
	public static int allocatePages(int m, int [] pages) {
		int lo = Integer.MAX_VALUE;
		int hi = 0;
		for(int i=0;i<pages.length;i++) {
			lo = Math.min(lo, pages[i]);
			hi +=pages[i];
		}
		
		while(lo <= hi) {
			
			int mid = lo+(hi-lo)/2;
			int staudentsRequired = countStudentsForPages(mid,pages);
			if(staudentsRequired > m)
				lo= mid+1;
			else
				hi= mid-1;
		}
		
		return lo;
	}
	
	private static int countStudentsForPages(int num, int[]pages) {
		int count = 1;
		int totalPages = 0;
		for(int i:pages) {
			totalPages +=i;
			if(totalPages > num) {
				count++;
				totalPages = i;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		int pages[] = {12, 34, 67, 90};
		int m=2;
		System.out.println(allocatePages(m,pages));
	}

}
