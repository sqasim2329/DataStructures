package com.data.heap;

public class CheckIfMinHeap {
	
	public static void main(String args[]) {
		int[] a = {1, 2, 3, 4, 5, 6};
		boolean flag = true;
		//since all roots will be at middle or around middle not at ends hence divide by 2 and -2 because childs can be 2 
		for(int i=0;i<=(a.length-2)/2;i++) {
			if(a[i]> a[2*i+1] || (2*i+2!=a.length && a[i]>a[2*i+2])) {
				flag =false;
			}
		}
		System.out.println(flag);
	}
}
/*****
 * 
 *    					1
 *				 2			  3
 *			4			5
 *    / so here we will be able to iterate only till 3 after that we have children hence (a.length-2)/2;
 * 
 * 
 * ******/
 */